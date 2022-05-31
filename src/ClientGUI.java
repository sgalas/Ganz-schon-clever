import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.Random;

public class ClientGUI {

    /**
     * Metoda tworząca przycisk o odpowiednich parametrach, wypełniony odpowiednią wartością
     * @param button obiekt przycisku - pusty, domyślny
     * @param label tekst do wyświetlenia w przycisku
     * @param x współrzędna x przycisku
     * @param y współrzędna y przycisku
     * @param lp obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createFiled(JButton button, String label, int x, int y, JLayeredPane lp){
        button.setBackground(Color.white);
        button.setBounds(x,y,41, 41);//x-axis, y-axis, width, height
        button.setForeground(Color.black);
        lp.add(button, JLayeredPane.POPUP_LAYER);//adding button in JFrame
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworząca przycisk z obrazem jako tłem
     * @param button  obiekt przycisku - pusty, domyślny
     * @param path ścieżka do pliku obrazka
     * @param x współrzędna x przycisku
     * @param y współrzędna y przycisku
     * @param lp obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createImaged(JButton button, String path, int x, int y, JLayeredPane lp){
        button.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(path))));
        button.setBounds(x,y,41,41);
        button.setMargin(new Insets(0,0,0,0));
        lp.add(button, JLayeredPane.POPUP_LAYER);
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworząca "pustą" kość - nie nadając jej wartości
     * @param button pusty obiekt przycisku
     * @param x współrzędna x przycisku
     * @param y współrzędna y przycisku
     * @param lp obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createDice(JButton button, int x, int y, JLayeredPane lp){
        button.setBounds(x,y,41,41);
        button.setMargin(new Insets(0,0,0,0));
        lp.add(button, JLayeredPane.POPUP_LAYER);
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworzaca label z tekstem "<"
     * @param more obiekt jlabel
     * @param x koordynat x
     * @param y koordynat y
     * @param lp obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JLabel createMore(JLabel more, int x, int y, JLayeredPane lp){
        more.setBounds(x,y,40,40);
        more.setFont(new Font("Serif", Font.PLAIN, 40));
        more.setForeground(Color.white);
        more.setVisible(true);
        lp.add(more, JLayeredPane.DRAG_LAYER);

        return more;
    }
    //Inicjalizacja wszystkich przycisków - konieczna w tym miejscu z powodu odnoszenia się do nich z różnych metod
    JFrame f=new JFrame(); // Ramka "zerowa" - podstawa gui
    JLayeredPane lp = new JLayeredPane(); // Jedyny element JFrame, zawierający wszystkie przyciski
    JButton y00 =new JButton(); //Przycisk żółty - kolumna 0 rząd 0
    JButton y01 = new JButton(); // Przycisk żółty - kolumna 0 rząd 1
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
    JButton g1 = new JButton();
    JButton g2 = new JButton();
    JButton g3 = new JButton();
    JButton g4 = new JButton();
    JButton g5 = new JButton();
    JButton g6 = new JButton();
    JButton g7 = new JButton();
    JButton g8 = new JButton();
    JButton g9 = new JButton();
    JButton g10 = new JButton();
    JButton g11 = new JButton();
    JButton o1 = new JButton();
    JButton o2 = new JButton();
    JButton o3 = new JButton();
    JButton o4 = new JButton();
    JButton o5 = new JButton();
    JButton o6 = new JButton();
    JButton o7 = new JButton();
    JButton o8 = new JButton();
    JButton o9 = new JButton();
    JButton o10 = new JButton();
    JButton o11 = new JButton();

    JButton p1 = new JButton();
    JButton p2 = new JButton();
    JButton p3 = new JButton();
    JButton p4 = new JButton();
    JButton p5 = new JButton();
    JButton p6 = new JButton();
    JButton p7 = new JButton();
    JButton p8 = new JButton();
    JButton p9 = new JButton();
    JButton p10 = new JButton();
    JButton p11 = new JButton();

    JLabel more1 = new JLabel("<");
    JLabel more2 = new JLabel("<");
    JLabel more3 = new JLabel("<");
    JLabel more4 = new JLabel("<");
    JLabel more5 = new JLabel("<");
    JLabel more6 = new JLabel("<");
    JLabel more7 = new JLabel("<");
    JLabel more8 = new JLabel("<");
    JLabel more9 = new JLabel("<");
    JLabel more10 = new JLabel("<");

    JButton diceWhite = new JButton(); //kość biała
    JButton diceYellow = new JButton();
    JButton diceBlue = new JButton();
    JButton dicePurple = new JButton();
    JButton diceGreen = new JButton();
    JButton diceOrange = new JButton();


    public ClientGUI() {

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1310, 850)); //Ustawienie wielkości okna

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

        b01 = createFiled(b01, "2", 600, 160, lp);
        b02 = createFiled(b02, "3", 670, 160, lp);
        b03 = createFiled(b03, "4", 740, 160, lp);
        b10 = createFiled(b10, "5", 530, 210, lp);
        b11 = createFiled(b11, "6", 600, 210, lp);
        b12 = createFiled(b12, "7", 670, 210, lp);
        b13 = createFiled(b13, "8", 740, 210, lp);
        b20 = createFiled(b20, "9", 530, 260, lp);
        b21 = createImaged(b21, "Images/10_Button.png", 600, 260, lp);
        b22 = createImaged(b22, "Images/11_Button.png", 670, 260, lp);
        b23 = createImaged(b23, "Images/12_Button.png", 740, 260, lp);

        g1 = createImaged(g1, "Images/More_One_Button.png", 105, 410, lp);
        g2 = createImaged(g2, "Images/More_Two_Button.png", 173, 410, lp);
        g3 = createImaged(g3, "Images/More_Three_Button.png", 241, 410, lp);
        g4 = createImaged(g4, "Images/More_Four_Button.png", 309, 410, lp);
        g5 = createImaged(g5, "Images/More_Five_Button.png", 377, 410, lp);
        g6 = createImaged(g6, "Images/More_One_Button.png", 445, 410, lp);
        g7 = createImaged(g7, "Images/More_Two_Button.png", 513, 410, lp);
        g8 = createImaged(g8, "Images/More_Three_Button.png", 581, 410, lp);
        g9 = createImaged(g9, "Images/More_Four_Button.png", 649, 410, lp);
        g10 = createImaged(g10, "Images/More_Five_Button.png", 717, 410, lp);
        g11 = createImaged(g11, "Images/More_Six_Button.png", 785, 410, lp);

        o1 = createFiled(o1, "", 105,535,lp);
        o2 = createFiled(o2, "", 173,535,lp);
        o3 = createFiled(o3, "", 241,535,lp);
        o4 = createFiled(o4, "", 309,535,lp);
        o5 = createFiled(o5, "", 377,535,lp);
        o6 = createFiled(o6, "", 445,535,lp);
        o7 = createFiled(o7, "", 513,535,lp);
        o8 = createFiled(o8, "", 581,535,lp);
        o9 = createFiled(o9, "", 649,535,lp);
        o10 = createFiled(o10, "", 717,535,lp);
        o11 = createFiled(o11, "", 785,535,lp);

        p1 = createFiled(p1, "", 105,660,lp);
        p2 = createFiled(p2, "", 173,660,lp);
        p3 = createFiled(p3, "", 241,660,lp);
        p4 = createFiled(p4, "", 309,660,lp);
        p5 = createFiled(p5, "", 377,660,lp);
        p6 = createFiled(p6, "", 445,660,lp);
        p7 = createFiled(p7, "", 513,660,lp);
        p8 = createFiled(p8, "", 581,660,lp);
        p9 = createFiled(p9, "", 649,660,lp);
        p10 = createFiled(p10, "", 717,660,lp);
        p11 = createFiled(p11, "", 785,660,lp);

        more1 = createMore(more1, 145, 660, lp);
        more2 = createMore(more2, 213, 660, lp);
        more3 = createMore(more3, 281, 660, lp);
        more4 = createMore(more4, 349, 660, lp);
        more5 = createMore(more5, 417, 660, lp);
        more6 = createMore(more6, 485, 660, lp);
        more7 = createMore(more7, 553, 660, lp);
        more8 = createMore(more8, 621, 660, lp);
        more9 = createMore(more9, 689, 660, lp);
        more10 = createMore(more10, 757, 660, lp);

        diceWhite.addActionListener(e -> diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Selected.png")));

        y00.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                y00.setText("");
                y00.setIcon(new ImageIcon("src/Images/X_Button.png"));
            }
        });


        JLabel background = new JLabel(new ImageIcon("src/Images/BoardBackground.png"));
        background.setBounds(0, 0, 1292, 835);
        background.setVisible(true);
        lp.add(background, JLayeredPane.DEFAULT_LAYER);

//        more.setBounds(200,200,100,100);
//        more.setFont(new Font("Serif", Font.PLAIN, 40));
//        more.setVisible(true);
//        lp.add(more, JLayeredPane.DRAG_LAYER);

        f.add(lp);
        lp.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);//making the frame visible
        initialiseActive();

    }

    public void initialiseActive(){
        diceWhite = createDice(diceWhite, 900, 400, lp);
        Random random=new Random();
        int startingDiceValue = random.nextInt(1,7);
        switch (startingDiceValue){
            case 1:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                break;
            case 2:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                break;
            case 3:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                break;
            case 4:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                break;
            case 5:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                break;
            case 6:
                diceWhite.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                break;
        }

        startingDiceValue = random.nextInt(1,7);
        diceBlue = createDice(diceBlue, 1000, 400, lp);
        switch (startingDiceValue){
            case 1:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                break;
            case 2:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                break;
            case 3:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                break;
            case 4:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                break;
            case 5:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                break;
            case 6:
                diceBlue.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                break;
        }

        startingDiceValue = random.nextInt(1,7);
        diceYellow = createDice(diceYellow, 1050, 450, lp);
        switch (startingDiceValue){
            case 1:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                break;
            case 2:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                break;
            case 3:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                break;
            case 4:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                break;
            case 5:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                break;
            case 6:
                diceYellow.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                break;
        }

        startingDiceValue = random.nextInt(1,7);
        diceGreen = createDice(diceGreen, 1100, 400, lp);
        switch (startingDiceValue){
            case 1:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                break;
            case 2:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                break;
            case 3:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                break;
            case 4:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                break;
            case 5:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                break;
            case 6:
                diceGreen.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                break;
        }

        startingDiceValue = random.nextInt(1,7);
        diceOrange = createDice(diceOrange, 950, 450, lp);
        switch (startingDiceValue){
            case 1:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                break;
            case 2:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                break;
            case 3:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                break;
            case 4:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                break;
            case 5:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                break;
            case 6:
                diceOrange.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                break;
        }

        startingDiceValue = random.nextInt(1,7);
        dicePurple = createDice(dicePurple, 1150, 450, lp);
        switch (startingDiceValue){
            case 1:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                break;
            case 2:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                break;
            case 3:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                break;
            case 4:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                break;
            case 5:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                break;
            case 6:
                dicePurple.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                break;
        }

    }
    public void testing(){
    }
}

