import javax.swing.*;
import java.awt.*;

public class LoadingGUI {
    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Gra Rzuć na tacę");
        JFrame frame2 = new JFrame("Gra offline");
        JFrame frame3 = new JFrame("Gra offline");
        JFrame frame4 = new JFrame("Gra offline");
        JFrame frame5 = new JFrame("Gra online");
        JFrame frame6 = new JFrame("Gra online - klient");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define new buttons
        JButton jb1 = new JButton("Gra offline");
        JButton jb2 = new JButton("Gra online");
        jb2.addActionListener(e -> {
            frame.setVisible(false);
            frame5.setVisible(true);
        });


        // create empty JTextField
        JTextField field1 = new JTextField();
        field1.setText("Nick1      ");
        JTextField field2 = new JTextField();
        field2.setText("Nick2      ");
        JTextField field3 = new JTextField();
        field3.setText("Nick3      ");
        JTextField field4 = new JTextField();
        field4.setText("Nick4      ");
        JTextField field5 = new JTextField();
        field5.setText("IP         ");


        final int[] howmanyplayers = new int[1];
        JButton jb5 = new JButton("2");
        jb5.addActionListener(e -> {howmanyplayers[0] = 2;
            frame3.setVisible(false);
            frame4.setVisible(true);
        });

        JButton jb6 = new JButton("3");
        jb6.addActionListener(e -> {
            howmanyplayers[0] = 3;
            frame3.setVisible(false);
            frame4.setVisible(true);        });

        JButton jb7 = new JButton("4");
        jb7.addActionListener(e -> {
            howmanyplayers[0] = 4;
            frame3.setVisible(false);
            frame4.setVisible(true);
        });

        jb1.addActionListener( e -> {
            frame.setVisible(false);
            frame2.setVisible(true);
        });

        JButton jb8 = new JButton("OK");


        JButton jb9 = new JButton("Server");
        JButton jb10 = new JButton("Klient");
        jb10.addActionListener(e -> {
            frame5.setVisible(false);
            frame6.setVisible(true);
        });

        JButton jb11 = new JButton("Połącz");
        jb11.addActionListener(e -> {

        });

        // Define the panel to hold the buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(jb1);
        panel.add(jb2);

        JPanel panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        JPanel panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());

        JPanel panel5 = new JPanel();
        panel5.setLayout(new FlowLayout());

        JPanel panel6 = new JPanel();
        panel6.setLayout(new FlowLayout());





        panel3.add(jb5);
        panel3.add(jb6);
        panel3.add(jb7);

        JButton jb3 = new JButton("Wczytaj grę");
        JButton jb4 = new JButton("Nowa gra");
        jb4.addActionListener(e ->{
            frame2.setVisible(false);
            frame3.setVisible(true);
        });

        panel2.add(jb3);
        panel2.add(jb4);
        panel4.add(field1);
        panel4.add(field2);
        panel4.add(field3);
        panel4.add(field4);
        panel4.add(jb8);
        panel5.add(jb9);
        panel5.add(jb10);
        panel6.add(field5);
        panel6.add(jb11);

        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame2.add(panel2);
        frame3.add(panel3);
        frame4.add(panel4);
        frame5.add(panel5);
        frame6.add(panel6);

        frame.pack();
        frame2.pack();
        frame3.pack();
        frame4.pack();
        frame5.pack();
        frame6.pack();

        frame.setVisible(true);
    }

}
