import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
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

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket server= new ServerSocket(5454);
        server.setReuseAddress(true);
        ArrayList<Communication> gracze=new ArrayList<>();
        while(gracze.size()!=4)
        {
            Socket client = server.accept();
            gracze.add(new Communication(client));
            System.out.println(gracze.size());
        }
        for(int z=0;z<4;z++){
            System.out.println("NOWA RUNDA");
            for(int i=0;i<4;i++)
            {
                System.out.println("Petla po prostu");
                gracze.get(i).getPrintWriter().println("A");
                //pasywi
                for(int j=0;j<4;j++)
                {
                    if(i!=j)
                    {
                        gracze.get(j).getPrintWriter().println("P");
                        System.out.println("Wysylamy "+j);
                    }
                }
                System.out.println("Dawania rol");
                //Dice roll
                List<Dice> kostki=DiceRoll.rollDice().getDices();
                DiceRoll roll=new DiceRoll(kostki);
                System.out.println("Generacja kostek");
                gracze.get(i).getOos().writeObject(roll);


                try {
                  Tray tray=(Tray)gracze.get(i).getOis().readObject();
                  System.out.println(tray);
                    UsedSlot used =(UsedSlot) gracze.get(i).getOis().readObject();
                    System.out.println(used);
                    for (int j = 0; j < 4; j++) {
                        if (i != j) {
                            gracze.get(j).getOos().writeObject(tray);
                            gracze.get(j).getOos().writeObject(used);
                        }
                    }
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thready");
                ArrayList<Thread> thready=new ArrayList<>();
                for (int thread_num = 0; thread_num < 4; thread_num++) {
                    if(thread_num!=i) {
                        Thread tr=new Thread(new RunnableJob(gracze.get(thread_num)));
                        tr.start();
                        thready.add(tr);

                    }
                }
                System.out.println("Po threadach");
                Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
                int ileOdeslanych=0;

                while(ileOdeslanych!=3) {
                    ileOdeslanych=0;
                    for(Thread thread:thready) {
                        if(!thread.isAlive()) {
                            ileOdeslanych++;
                            }
                        }
                    }
                    System.out.println(ileOdeslanych);
                    Thread.sleep(500);
                }
                System.out.println("Wychodzenie");
                }
            }


}
