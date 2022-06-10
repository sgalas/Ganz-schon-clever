import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RunnableJob implements Runnable{
    private Socket s;
    public RunnableJob(Socket s)
    {
        this.s=s;
    }
    @Override
    public void run()
    {
        try( DataInputStream inStream = new DataInputStream(s.getInputStream()))
        {
            inStream.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
