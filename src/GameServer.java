import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameServer{
    private ArrayList<Player> playerList;
    public static ByteBuffer str_to_bb(String msg){
        return ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8));
    }
    public static String bb_to_str(ByteBuffer buffer){
        byte[] bytes;
        if(buffer.hasArray()) {
            bytes = buffer.array();
        } else {
            bytes = new byte[buffer.remaining()];
            buffer.get(bytes);
        }
        return new String(bytes, StandardCharsets.UTF_8);
    }
    public static void main(String[] args) throws IOException, InterruptedException {

        ByteBuffer wiadomosc=ByteBuffer.allocate(256);
        Selector selector = Selector.open();
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress("localhost", 5454));
        serverSocket.configureBlocking(false);
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        ArrayList<SocketChannel> gracze=new ArrayList<>();
        while(gracze.size()!=4)
        {   selector.select();
            Set<SelectionKey> selectedKeys = selector.selectedKeys();
            if(!selectedKeys.isEmpty()) {
                SocketChannel client = serverSocket.accept();
                gracze.add(client);
            }
        }
        while(true) {
            for(int i=0;i<4;i++)
            {
                SocketChannel aktyw=gracze.get(i);
                wiadomosc.clear();
                List<Dice> kostki=DiceRoll.rollDice().getDices();
                StringBuilder kosciB=new StringBuilder();
                for(Dice kos:kostki)
                {
                    aktyw.write(str_to_bb(Integer.toString(kos.getColor().ordinal())+","+Integer.toString(kos.getValue())));
                    aktyw.write(str_to_bb("\n"));
                }
                TimeUnit.SECONDS.sleep(1);
                Set<SelectionKey> selectedKeys;
                do {
                    selector.select();
                    selectedKeys = selector.selectedKeys();
                } while(selectedKeys.isEmpty());
                wiadomosc.clear();
                aktyw.read(wiadomosc);
                for (int j = 0; j < 4; j++) {
                    if (i != j) {
                        SocketChannel pasyw=gracze.get(i);
                        pasyw.write(wiadomosc);
                    }
                }
                int ileOdeslalo=0;
                while(ileOdeslalo!=3)
                {
                    selector.select();
                    selectedKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectedKeys.iterator();
                    ileOdeslalo+=selectedKeys.size();
                    while(iter.hasNext()) {
                        SelectionKey key = iter.next();
                        SocketChannel client = (SocketChannel) key.channel();
                        try {
                            int byteCount = client.read(buffer);
                            if (byteCount == -1) {
                                key.channel().close();
                                key.cancel();
                                continue;
                            }
                        } catch (IOException e) {
                            client.close();
                            key.cancel();
                        }
                    }
                }
            }
        }

    }

    protected void activePlayerTurn(Player player) {

    }

    protected void passivePlayerTurn(Player player) {

    }
}
