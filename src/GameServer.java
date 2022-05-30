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
import java.util.Set;
import java.util.ArrayList;

public class GameServer extends Game{
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

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        ByteBuffer wiadomosc=ByteBuffer.allocate(256);
        serverSocket.bind(new InetSocketAddress("localhost", 5454));
        serverSocket.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(256);
        ArrayList<SocketChannel> gracze=new ArrayList<>();
        while(gracze.size()!=4)
        {
            SocketChannel client = serverSocket.accept();
            gracze.add(client);
        }
        while(true) {
            for(int i=0;i<3;i++)
            {
                SocketChannel aktyw=gracze.get(i);
                aktyw.write(str_to_bb("Mozesz"));
                aktyw.read(wiadomosc);
                String odczyt=bb_to_str(wiadomosc);
                System.out.println(wiadomosc);
            }
        }

    }

    @Override
    protected void activePlayerTurn(Player player) {

    }

    @Override
    protected void passivePlayerTurn(Player player) {

    }
}
