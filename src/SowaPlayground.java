import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class SowaPlayground {

    static void testgui(){
        JFrame f=new JFrame();//creating instance of JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1920,1080));//400 width and 500 height
        JLabel x = new JLabel("X");

//        x.setBounds(110,265,41,41);
        x.setPreferredSize(new Dimension(100,100));
        x.setBackground(java.awt.Color.BLUE);
        x.setOpaque(true);
        f.add(x);
        x.setVisible(true);

        f.setLocationRelativeTo(null);
        f.setVisible(true);//making the frame visible
    }


    public static void main(String[] args) throws InterruptedException {
        //ClientGUI abc = new ClientGUI();
        testgui();
    }

}
