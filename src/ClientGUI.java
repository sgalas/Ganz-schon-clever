import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ClientGUI {
    JButton createFiled(JButton button, String label, int x, int y, JLayeredPane lp){
        button = new JButton(label);
        button.setBackground(Color.white);
        button.setBounds(x,y,41, 41);//x-axis, y-axis, width, height
        lp.add(button, 2);//adding button in JFrame
        button.setVisible(true);

        return button;
    }

    JButton createImaged(JButton button, String path, int x, int y, JLayeredPane lp){
        button.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(path))));
        button.setBounds(x,y,41,41);
        button.setMargin(new Insets(0,0,0,0));
        lp.add(button);
        button.setVisible(true);

        return button;
    }
    JToggleButton createImaged(JToggleButton button,  String path, int x, int y, JLayeredPane lp){
        button.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(path))));
        button.setBounds(x,y,41,41);
        button.setMargin(new Insets(0,0,0,0));
        lp.add(button);
        button.setVisible(true);

        return button;
    }

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
    JButton b23 = new JButton();
    JToggleButton d1 = new JToggleButton();

    public ClientGUI(){

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1920,1080));//400 width and 500 height

        y00 = createFiled(y00, "3", 110, 115, lp);
        y01 = createFiled(y01, "2", 110, 165, lp);
        y02 = createFiled(y02, "1", 110, 215, lp);
        y10 = createFiled(y10, "6", 175, 115, lp);
        y20 = createFiled(y20, "5", 240, 115, lp);
        y11 = createFiled(y11, "1", 175, 165, lp);
        y13 = createFiled(y13, "3", 175, 265, lp);
        y22 = createFiled(y22, "2", 240, 215, lp);
        y23 = createFiled(y23, "4", 240, 265, lp);
        y31 = createFiled(y31, "5", 305, 165, lp);
        y32 = createFiled(y32, "5", 305, 215, lp);
        y33 = createFiled(y33, "6", 305, 265, lp);

        y30 = createImaged(y30, "Images/X_Button.png", 305, 115, lp);
        y03 = createImaged(y03, "Images/X_Button.png", 110, 265, lp);
        y12 = createImaged(y12, "Images/X_Button.png", 175, 215, lp);
        y21 = createImaged(y21, "Images/X_Button.png", 240, 165, lp);

        b01 = createFiled(b01, "2", 600,165,lp);
        b02 = createFiled(b01, "3", 670,165,lp);
        b03 = createFiled(b01, "4", 740,165,lp);
        b10 = createFiled(b10, "5", 530,220,lp);
        b11 = createFiled(b11, "6", 600,220,lp);
        b12 = createFiled(b12, "7", 670,220,lp);
        b13 = createImaged(b13, "Images/12_Button.png", 740, 220, lp);

//        d1.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(path))));
//        d1.setBounds(x,y,41,41);
//        d1.setMargin(new Insets(0,0,0,0));
//        lp.add(d1);
//        d1.setVisible(true);
        d1 = createImaged(d1, "Images/Dice_One.png", 1000, 600, lp);
        //d1.setSelectedIcon(new ImageIcon("Images/Dice_One_Selected.png"));

        y00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y00.setIcon(new ImageIcon("Images/X_Button.png"));
            }
        });


        JLabel background = new JLabel(new ImageIcon("src/Images/BoardBackground.png"));
        background.setBounds(0,0,1292,835);
        background.setVisible(true);
        lp.add(background, 1);

        lp.repaint();
        f.repaint();
        f.add(lp);
        f.setLocationRelativeTo(null);
        f.setVisible(true);//making the frame visible


    }
    public void testing(){
    }
}

