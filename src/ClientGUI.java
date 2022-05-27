import javax.swing.*;
import java.awt.*;
import java.awt.Color;

public class ClientGUI {
    JFrame f=new JFrame();//creating instance of JFrame
    JLayeredPane lp = new JLayeredPane();
    JButton y00 =new JButton(); //creating instance of JButton
    JButton y01 = new JButton();
    JButton y02 = new JButton();
    JButton y10 = new JButton();
    JButton y20 = new JButton();
    JButton y30 = new JButton();
    JButton y03 = new JButton();
    JButton y11 = new JButton();
    JButton y12 = new JButton();
    JButton y13 = new JButton();
    JButton y21 = new JButton();
    JButton y22 = new JButton();
    JButton y23 = new JButton();
    JButton y31 = new JButton();
    JButton y32 = new JButton();
    JButton y33 = new JButton();
    JButton b01 = new JButton();
    JButton b02 = new JButton();
    JButton b03 = new JButton();
    JButton b10 = new JButton();
    JButton b11 = new JButton();
    JButton b12 = new JButton();
    JButton b13 = new JButton();
    JButton b20 = new JButton();
    JButton b21 = new JButton();
    JButton b22 = new JButton();
    JButton b23 = new JButton();

    public ClientGUI(){

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1920,1080));//400 width and 500 height

        y00 = new JButton("3");
        y00.setBounds(110,115,41, 41);//x-axis, y-axis, width, height
        lp.add(y00, 2);//adding button in JFrame
        y00.setVisible(true);


        y01 = new JButton("2");
        y01.setBounds(110,165,41, 41);//x-axis, y-axis, width, height
        lp.add(y01, 2);//adding button in JFrame
        y01.setVisible(true);

        y02 = new JButton("1");
        y02.setBounds(110,215,41, 41);//x-axis, y-axis, width, height
        lp.add(y02, 2);//adding button in JFrame
        y02.setVisible(true);

        y10 = new JButton("6");
        y10.setBounds(175,115,41, 41);//x-axis, y-axis, width, height
        lp.add(y10, 2);//adding button in JFrame
        y10.setVisible(true);

        y20 = new JButton("5");
        y20.setBounds(240,115,41, 41);//x-axis, y-axis, width, height
        lp.add(y20, 2);//adding button in JFrame
        y20.setVisible(true);

        y30 = new JButton("X");
        y30.setBounds(305,115,42, 42);//x-axis, y-axis, width, height
        y30.setBackground(Color.green);
        lp.add(y30, 2);//adding button in JFrame
        y30.setVisible(true);

        y03 = new JButton("X");
        y03.setBackground(Color.green);
        y03.setBounds(110,265,42, 42);//x-axis, y-axis, width, height
        lp.add(y03, 2);//adding button in JFrame
        y03.setVisible(true);

        y11 = new JButton("1");
        y11.setBounds(175,165,42, 42);//x-axis, y-axis, width, height
        lp.add(y11, 2);//adding button in JFrame
        y11.setVisible(true);

        y12 = new JButton("X");
        y12.setBounds(175,215,42, 42);//x-axis, y-axis, width, height
        lp.add(y12, 2);//adding button in JFrame
        y12.setVisible(true);
        y12.setBackground(Color.green);

        y13 = new JButton("3");
        y13.setBounds(175,265,42, 42);//x-axis, y-axis, width, height
        lp.add(y13, 2);//adding button in JFrame
        y13.setVisible(true);

        y21 = new JButton("X");
        y21.setBounds(240,165,42, 42);//x-axis, y-axis, width, height
        lp.add(y21, 2);//adding button in JFrame
        y21.setBackground(Color.green);
        y21.setVisible(true);

        y22 = new JButton("2");
        y22.setBounds(240,215,42, 42);//x-axis, y-axis, width, height
        lp.add(y22, 2);//adding button in JFrame
        y22.setVisible(true);

        y23 = new JButton("4");
        y23.setBounds(240,265,42, 42);//x-axis, y-axis, width, height
        lp.add(y23, 2);//adding button in JFrame
        y23.setVisible(true);

        y31 = new JButton("5");
        y31.setBounds(305,165,42, 42);//x-axis, y-axis, width, height
        lp.add(y31, 2);//adding button in JFrame
        y31.setVisible(true);

        y32 = new JButton("4");
        y32.setBounds(305,215,42, 42);//x-axis, y-axis, width, height
        lp.add(y32, 2);//adding button in JFrame
        y32.setVisible(true);

        y33 = new JButton("6");
        y33.setBounds(305,265,42, 42);//x-axis, y-axis, width, height
        lp.add(y33, 2);//adding button in JFrame
        y33.setVisible(true);

        b01 = new JButton("2");
        b01.setBounds(600,165,42, 42);//x-axis, y-axis, width, height
        lp.add(b01, 2);//adding button in JFrame
        b01.setVisible(true);

        b02 = new JButton("3");
        b02.setBounds(670,165,42, 42);//x-axis, y-axis, width, height
        lp.add(b02, 2);//adding button in JFrame
        b02.setVisible(true);

        b03 = new JButton("4");
        b03.setBounds(740,165,42, 42);//x-axis, y-axis, width, height
        lp.add(b03, 2);//adding button in JFrame
        b03.setVisible(true);



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
        y00.setIcon(new ImageIcon("src/Images/img_1.png"));
    }
}

