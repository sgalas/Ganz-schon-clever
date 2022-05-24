import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI {
    JFrame f=new JFrame();//creating instance of JFrame
    JLayeredPane lp = new JLayeredPane();
    JButton b=new JButton(); //creating instance of JButton
    JLabel flaga = new JLabel();
    JButton b2 = new JButton();
    JButton b3 = new JButton();
    JButton b4 = new JButton();
    JButton b5 = new JButton();
    JButton b6 = new JButton();
    JButton b7 = new JButton();
    public ClientGUI(){

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1920,1080));//400 width and 500 height

        b = new JButton("2");
        b.setBounds(110,115,41, 41);//x-axis, y-axis, width, height
        lp.add(b, 2);//adding button in JFrame
        b.setVisible(true);


        b2 = new JButton("3");
        b2.setBounds(170,115,41, 41);//x-axis, y-axis, width, height
        lp.add(b2, 2);//adding button in JFrame
        b2.setVisible(true);

        b3 = new JButton("3");
        b3.setBounds(240,115,41, 41);//x-axis, y-axis, width, height
        lp.add(b3, 2);//adding button in JFrame
        b3.setVisible(true);

        b4 = new JButton("3");
        b4.setBounds(310,120,41, 41);//x-axis, y-axis, width, height
        lp.add(b4, 2);//adding button in JFrame
        b4.setVisible(true);

        b5 = new JButton("2");
        b5.setBounds(110,165,41, 41);//x-axis, y-axis, width, height
        lp.add(b5, 2);//adding button in JFrame
        b5.setVisible(true);

        b6 = new JButton("2");
        b6.setBounds(110,215,41, 41);//x-axis, y-axis, width, height
        lp.add(b6, 2);//adding button in JFrame
        b6.setVisible(true);

        b7 = new JButton("2");
        b7.setBounds(110,265,41, 41);//x-axis, y-axis, width, height
        lp.add(b7, 2);//adding button in JFrame
        b7.setVisible(true);
//        b.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });

        JLabel background = new JLabel(new ImageIcon("src/Images/gownonapatyku.png"));
        background.setBounds(0,0,1292,835);
        background.setVisible(true);
        lp.add(background, 1);

//        flaga = new JLabel(new ImageIcon("src/Images/FlagaSzkocji.png"));
//        flaga.setBounds(100,100,100,100);
//        lp.add(flaga, JLayeredPane.DEFAULT_LAYER);
//        flaga.setVisible(true);

        lp.repaint();
        f.repaint();
        f.add(lp);
        f.setLocationRelativeTo(null);
        f.setVisible(true);//making the frame visible


    }
    public void testing(){
        b.setIcon(new ImageIcon("src/Images/img_1.png"));
    }
}

