import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RunnableJob implements Runnable{
    Communication com;
    public RunnableJob(Communication com)
    {
        this.com=com;
    }
    public void run()
    {
        try
        {
            com.getBufferedReader().readLine();
            System.out.println("Otrzymano linie");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
