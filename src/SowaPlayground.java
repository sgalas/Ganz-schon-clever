import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SowaPlayground {

    static void testgui(){
        JFrame f=new JFrame();//creating instance of JFrame
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1920,1080));//400 width and 500 height
        f.setTitle("Rzuć na tacę!");
        JLabel x = new JLabel("X");

        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("START GAME");
        JMenu m2 = new JMenu("HOW TO PLAY");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("LOAD");
        JMenuItem m22 = new JMenuItem("SAVE AS");
        m1.add(m11);
        m1.add(m22);

//        x.setBounds(110,265,41,41);
        x.setPreferredSize(new Dimension(100,100));
        x.setBackground(java.awt.Color.BLUE);
        x.setOpaque(true);
        f.add(x);
        x.setVisible(true);

        f.setLocationRelativeTo(null);
        f.add(mb, BorderLayout.CENTER);
        f.setVisible(true);//making the frame visible
    }


    public static void main(String[] args) throws InterruptedException {
        Player a = Player.createNewPlayer(12, "nick");
//        DiceRoll ab = DiceRoll.rollDice();
//        List<Dice> sellist =ab.getDices();
//        sellist.remove(0);
//        sellist.remove(1);
//        sellist.remove(2);
//        a.setDiceRoll(new DiceRoll(sellist));
        a.setDiceRoll(DiceRoll.rollDice());

        List<Dice> used = new ArrayList<>();
        used.add(new Dice(Color.WHITE, 5));
        used.add(new Dice(Color.BLUE, 3));
        used.add(new Dice(Color.YELLOW, 1));
        a.setUsedSlot(new UsedSlot(used));
        Tray tray = new Tray();
        tray.putDice(new Dice(Color.PURPLE, 1));
        tray.putDice(new Dice(Color.GREEN, 4));
        a.setTray(tray);

        ClientGUI abc = new ClientGUI(a);




    }

}
