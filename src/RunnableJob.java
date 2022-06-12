import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RunnableJob implements Runnable{
    Communication com;
    Player zwrot;
    public RunnableJob(Communication com)
    {
        this.com=com;
    }
    public void run()
    {
        try
        {
            this.zwrot=(Player)com.getOis().readObject();
            System.out.println("Otrzymano linie");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public Player getPlayer()
    {
        System.out.println("otrzymuje zwrot");
        return zwrot;
    }
}
