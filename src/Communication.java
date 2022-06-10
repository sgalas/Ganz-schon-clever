import java.io.*;
import java.net.Socket;

public class Communication {
    private Socket s;
    private PrintWriter out;
    private BufferedReader br;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public Communication(Socket s)
    {
        this.s=s;
        try {
            out = new PrintWriter(s.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            oos = new ObjectOutputStream(s.getOutputStream());
            ois=new ObjectInputStream(s.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Socket getSocket()
    {
        return s;
    }
    public PrintWriter getPrintWriter()
    {
        return out;
    }
    public BufferedReader getBufferedReader()
    {
        return br;
    }
    public ObjectOutputStream getOos()
    {
        return oos;
    }
    public ObjectInputStream getOis()
    {
        return ois;
    }
}
