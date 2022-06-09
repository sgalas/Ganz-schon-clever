import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class ClientGUI {

    //Zmienna przechowujaca gracza - w celu wykonywania operacji - przekazywana na etapie tworzenia
    private Player player;

    /**
     * Metoda tworząca przycisk o odpowiednich parametrach, wypełniony odpowiednią wartością
     *
     * @param label  tekst do wyświetlenia w przycisku
     * @param x      współrzędna x przycisku
     * @param y      współrzędna y przycisku
     * @param lp     obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createFiled(String label, int x, int y, JLayeredPane lp) {
        JButton button = new JButton(label);
        button.setBackground(Color.white);
        button.setBounds(x, y, 41, 41);//x-axis, y-axis, width, height
        button.setForeground(Color.black);
        lp.add(button, JLayeredPane.POPUP_LAYER);//adding button in JFrame
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworząca przycisk z obrazem jako tłem
     *
     * @param button obiekt przycisku - pusty, domyślny
     * @param path   ścieżka do pliku obrazka
     * @param x      współrzędna x przycisku
     * @param y      współrzędna y przycisku
     * @param lp     obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createImaged(JButton button, String path, int x, int y, JLayeredPane lp) {
        button.setIcon(new ImageIcon(Objects.requireNonNull(this.getClass().getResource(path))));
        button.setBounds(x, y, 41, 41);
        button.setMargin(new Insets(0, 0, 0, 0));
        lp.add(button, JLayeredPane.POPUP_LAYER);
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworząca "pustą" kość - nie nadając jej wartości
     *
     * @param button pusty obiekt przycisku
     * @param lp     obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JButton createDice(JButton button, JLayeredPane lp) {
        button.setMargin(new Insets(0, 0, 0, 0));
        lp.add(button, JLayeredPane.POPUP_LAYER);
        button.setVisible(true);
        return button;
    }

    /**
     * Metoda tworzaca label z tekstem "<"
     *
     * @param more obiekt jlabel
     * @param x    koordynat x
     * @param lp   obiekt JLayeredPane do którego ma należeć przycisk
     * @return gotowy przycisk
     */
    JLabel createMore(JLabel more, int x, JLayeredPane lp) {
        more.setBounds(x, 660, 40, 40);
        more.setFont(new Font("Serif", Font.PLAIN, 40));
        more.setForeground(Color.white);
        more.setVisible(true);
        lp.add(more, JLayeredPane.DRAG_LAYER);

        return more;
    }

    JLabel createCount(JLabel count, int x, int y, JLayeredPane lp){
      count.setBounds(x,y, 41, 41);
      count.setFont(new Font("Serif", Font.PLAIN, 40));
      count.setForeground(Color.black);
      count.setVisible(true);
      lp.add(count, JLayeredPane.DRAG_LAYER);
      return count;
    }

    /**
     * Sparametryzowana funkcja pozwalająca na utworzenie odpowiednich akcji dla poszczególnych pól
     * @param button
     * @param color
     * @param index
     */
    private void addTileAction(JButton button, String color, int index){
        button.addActionListener(e -> {
            if (selectedDice == null) {
                showEmptyError();
            } else {
                PossibleMove possibleMove = null;
                switch (color){
                    case "green" ->  possibleMove = new PossibleMove(player.getBoardGreen(), selectedDice, index);
                    case "yellow" -> possibleMove = new PossibleMove(player.getBoardYellow(), selectedDice, index);
                    case "orange" -> possibleMove = new PossibleMove(player.getBoardOrange(), selectedDice, index);
                    case "purple" -> possibleMove = new PossibleMove(player.getBoardPurple(), selectedDice, index);
                }
                    try {
                        player.executeMove(possibleMove);
                        switch (color){
                            case "green" -> {
                                switch (selectedDice.getValue()) {
                                    case 1 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                    case 2 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                    case 3 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                    case 4 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                    case 5 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                    case 6 -> button.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                            case "yellow" -> button.setIcon(new ImageIcon("src/Images/X_Button.png"));
                            case "orange" -> {
                                switch (selectedDice.getValue()) {
                                    case 1 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                    case 2 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                    case 3 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                    case 4 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                    case 5 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                    case 6 -> o1.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                            case "purple" -> {
                                switch (selectedDice.getValue()) {
                                    case 1 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                    case 2 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                    case 3 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                    case 4 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                    case 5 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                    case 6 -> p1.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }

                        }
                    } catch (InvalidMoveException exception) {
                        showFillError();
                    }
                    catch (NotReadyException exception){
                        notYourTurnError();
                    }
                    selectedDice = null;
                }
        });
    }

    //Inicjalizacja wszystkich przycisków - konieczna w tym miejscu z powodu odnoszenia się do nich z różnych metod
        JFrame f = new JFrame(); // Ramka "zerowa" - podstawa gui
        JLayeredPane lp = new JLayeredPane(); // Jedyny element JFrame, zawierający wszystkie przyciski
        JButton y00 = new JButton(); //Przycisk żółty - kolumna 0 rząd 0
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

        JButton diceOne = new JButton();
        JButton diceTwo = new JButton();
        JButton diceThree = new JButton();
        JButton diceFour = new JButton();
        JButton diceFive = new JButton();
        JButton diceSix = new JButton();

        JButton additional = new JButton();
        JButton reroll = new JButton();
        JLabel additionalCount = new JLabel();
        JLabel rerollCount = new JLabel();
        JLabel roundCount = new JLabel();


    private int diceSel = 0; //Zmienna uzywana do ustalenia ilosci kosci juz ustawionych
    private Dice selectedDice; //Do przechowywania wybranej kosci

    public ClientGUI(Player player) {

        this.player = player;
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1310, 850)); //Ustawienie wielkości okna

        additional = createImaged(additional, "Images/additional.png", 900,260, lp);
        additionalCount = createCount(additionalCount, 910, 300, lp);
        reroll = createImaged(reroll, "Images/reroll.png", 960,260, lp);
        rerollCount = createCount(rerollCount, 970, 300, lp);
        reroll.addActionListener(e -> player.useReroll());
        additional.addActionListener(e -> player.useAdditionalDice());
        roundCount.setText("Obecna runda: ");
        roundCount = createCount(roundCount,910, 100, lp);
        roundCount.setBounds(910, 100, 100, 100);
        roundCount.setFont(new Font("Serif", Font.PLAIN, 15));

        {
            y00 = createFiled("3", 110, 115, lp);
            y01 = createFiled("2", 110, 165, lp);
            y02 = createFiled("1", 110, 215, lp);
            y10 = createFiled("6", 175, 115, lp);
            y20 = createFiled("5", 240, 115, lp);
            y11 = createFiled("1", 175, 165, lp);
            y13 = createFiled("3", 175, 265, lp);
            y22 = createFiled("2", 240, 215, lp);
            y23 = createFiled("4", 240, 265, lp);
            y31 = createFiled("5", 305, 165, lp);
            y32 = createFiled("5", 305, 215, lp);
            y33 = createFiled("6", 305, 265, lp);

            addTileAction(y00, "yellow", 0);
            addTileAction(y10, "yellow", 1);
            addTileAction(y20, "yellow", 2);
            addTileAction(y01, "yellow", 3);
            addTileAction(y11, "yellow", 4);
            addTileAction(y31, "yellow", 5);
            addTileAction(y02, "yellow", 6);
            addTileAction(y22, "yellow", 7);
            addTileAction(y32, "yellow", 8);
            addTileAction(y13, "yellow", 9);
            addTileAction(y23, "yellow", 10);
            addTileAction(y33, "yellow", 11);
        }//inicjalizacja zoltych pol

        y30 = createImaged(y30, "Images/X_Button.png", 305, 115, lp);
        y03 = createImaged(y03, "Images/X_Button.png", 110, 265, lp);
        y12 = createImaged(y12, "Images/X_Button.png", 175, 215, lp);
        y21 = createImaged(y21, "Images/X_Button.png", 240, 165, lp);

        b01 = createFiled("2", 600, 160, lp);
        b02 = createFiled("3", 670, 160, lp);
        b03 = createFiled("4", 740, 160, lp);
        b10 = createFiled("5", 530, 210, lp);
        b11 = createFiled("6", 600, 210, lp);
        b12 = createFiled("7", 670, 210, lp);
        b13 = createFiled("8", 740, 210, lp);
        b20 = createFiled("9", 530, 260, lp);
        b21 = createImaged(b21, "Images/10_Button.png", 600, 260, lp);
        b22 = createImaged(b22, "Images/11_Button.png", 670, 260, lp);
        b23 = createImaged(b23, "Images/12_Button.png", 740, 260, lp);



        {
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

            addTileAction(g1, "green", 0);
            addTileAction(g2, "green", 1);
            addTileAction(g3, "green", 2);
            addTileAction(g4, "green", 3);
            addTileAction(g5, "green", 4);
            addTileAction(g6, "green", 5);
            addTileAction(g7, "green", 6);
            addTileAction(g8, "green", 7);
            addTileAction(g9, "green", 8);
            addTileAction(g10, "green", 9);
            addTileAction(g11, "green", 10);

        }//Inicjalizacja pol zielonych

        {
            o1 = createFiled("", 105, 535, lp);
            o2 = createFiled("", 173, 535, lp);
            o3 = createFiled("", 241, 535, lp);
            o4 = createFiled("", 309, 535, lp);
            o5 = createFiled("", 377, 535, lp);
            o6 = createFiled("", 445, 535, lp);
            o7 = createFiled("", 513, 535, lp);
            o8 = createFiled("", 581, 535, lp);
            o9 = createFiled("", 649, 535, lp);
            o10 = createFiled("", 717, 535, lp);
            o11 = createFiled("", 785, 535, lp);

            addTileAction(o1, "orange", 0);
            addTileAction(o2, "orange", 1);
            addTileAction(o3, "orange", 2);
            addTileAction(o4, "orange", 3);
            addTileAction(o5, "orange", 4);
            addTileAction(o6, "orange", 5);
            addTileAction(o7, "orange", 6);
            addTileAction(o8, "orange", 7);
            addTileAction(o9, "orange", 8);
            addTileAction(o10, "orange", 9);
            addTileAction(o11, "orange", 10);



        }//Inicjalizacja pol pomaranczowych

        {
            p1 = createFiled("", 105, 660, lp);
            p2 = createFiled("", 173, 660, lp);
            p3 = createFiled("", 241, 660, lp);
            p4 = createFiled("", 309, 660, lp);
            p5 = createFiled("", 377, 660, lp);
            p6 = createFiled("", 445, 660, lp);
            p7 = createFiled("", 513, 660, lp);
            p8 = createFiled("", 581, 660, lp);
            p9 = createFiled("", 649, 660, lp);
            p10 = createFiled("", 717, 660, lp);
            p11 = createFiled("", 785, 660, lp);

            addTileAction(p1, "orange", 0);
            addTileAction(p2, "orange", 1);
            addTileAction(p3, "orange", 2);
            addTileAction(p4, "orange", 3);
            addTileAction(p5, "orange", 4);
            addTileAction(p6, "orange", 5);
            addTileAction(p7, "orange", 6);
            addTileAction(p8, "orange", 7);
            addTileAction(p9, "orange", 8);
            addTileAction(p10, "orange", 9);
            addTileAction(p11, "orange", 10);

        }//Inicjalizacja pol fioletowych

        more1 = createMore(more1, 145, lp);
        more2 = createMore(more2, 213, lp);
        more3 = createMore(more3, 281, lp);
        more4 = createMore(more4, 349, lp);
        more5 = createMore(more5, 417, lp);
        more6 = createMore(more6, 485, lp);
        more7 = createMore(more7, 553, lp);
        more8 = createMore(more8, 621, lp);
        more9 = createMore(more9, 689, lp);
        more10 = createMore(more10, 757, lp);


        JLabel background = new JLabel(new ImageIcon("src/Images/BoardBackground.png"));
        background.setBounds(0, 0, 1292, 835);
        background.setVisible(true);
        lp.add(background, JLayeredPane.DEFAULT_LAYER);

        f.add(lp);
        lp.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setVisible(true);//making the frame visible
        diceOne = createDice(diceOne, lp);
        diceTwo = createDice(diceTwo, lp);
        diceThree = createDice(diceThree, lp);
        diceFour = createDice(diceFour, lp);
        diceFive = createDice(diceFive, lp);
        diceSix = createDice(diceSix, lp);
        updateAll();
    }

    private void showFillError(){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nie można wypełnic tego pola wybraną kostką!", "Błąd",
                JOptionPane.WARNING_MESSAGE);
    }

    private void notYourTurnError(){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nie możesz wykonać tego ruchu poza swoją turą!", "Błąd",
                JOptionPane.WARNING_MESSAGE);
    }

    private void showEmptyError(){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nie wybrano kostki!", "Błąd",
                JOptionPane.WARNING_MESSAGE);
    }

    public void updateAll(){
        diceSel = 0;
        updateTray();
        updateUsed();
        updateActive();
        updateActions();
    }

    public void updateActions(){
        rerollCount.setText(String.valueOf(player.getRerollCount()));
        additionalCount.setText(String.valueOf(player.getAdditionalDiceCount()));
        roundCount.setText(roundCount.getText() + player.getRound());
    }
    public void updateTray(){
        List<Dice> trayList;
        trayList = player.getTrayDiceList();
        for(Dice d: trayList){
            switch (diceSel) {
                case 0 -> {
                    diceOne.setBounds(950, 550, 41, 41);
                    diceOne.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }
                    diceSel++;
                    break;
                }
                case 1 -> {
                    diceTwo.setBounds(1000, 550, 41, 41);
                    diceTwo.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 2 -> {
                    diceThree.setBounds(1050, 550, 41, 41);
                    diceThree.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 3 -> {
                    diceFour.setBounds(940, 600, 41, 41);
                    diceFour.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 4 -> {
                    diceFive.setBounds(990, 600, 41, 41);
                    diceFive.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 5 -> {
                    diceSix.setBounds(1040, 600, 41, 41);
                    diceSix.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
            }
        }

    }
    public void updateUsed(){
        List<Dice> usedDice;
        usedDice = player.getUsedSlot().getDices();
        int howmanyDice = 0;
        for(Dice d: usedDice){
            switch (diceSel){
                case 0: {
                    diceOne.setBounds(1205,530,41,41);
                    howmanyDice++;
                    diceOne.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }
                    diceSel++;
                    break;
                }
                case 1: {
                    if(howmanyDice == 0)
                        diceTwo.setBounds(1205,530,41,41);
                    else
                        diceTwo.setBounds(1205,605,41,41);
                    howmanyDice++;
                    diceTwo.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 2: {
                    if(howmanyDice == 0)
                        diceThree.setBounds(1205,530,41,41);
                    else{
                        if(howmanyDice == 1)
                            diceThree.setBounds(1205,605,41,41);
                        else
                            diceThree.setBounds(1205,680,41,41);
                    }
                    howmanyDice++;
                    diceThree.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }
                    diceSel++;
                    break;
                }
                case 3: {
                    if(howmanyDice == 0)
                        diceFour.setBounds(1205,530,41,41);
                    else{
                        if(howmanyDice == 1)
                            diceFour.setBounds(1205,605,41,41);
                        else
                            diceFour.setBounds(1205,680,41,41);
                    }
                    howmanyDice++;
                    diceFour.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 4: {
                    if(howmanyDice == 0)
                        diceFive.setBounds(1205,530,41,41);
                    else{
                        if(howmanyDice == 1)
                            diceFive.setBounds(1205,605,41,41);
                        else
                            diceFive.setBounds(1205,680,41,41);
                    }
                    howmanyDice++;
                    diceFive.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 5: {
                    if(howmanyDice == 0)
                        diceSix.setBounds(1205,530,41,41);
                    else{
                        if(howmanyDice == 1)
                            diceSix.setBounds(1205,605,41,41);
                        else
                            diceSix.setBounds(1205,680,41,41);
                    }
                    howmanyDice++;
                    diceSix.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
            }
        }
    }

    public void updateActive() {
        List<Dice> rolledDice;
        rolledDice = player.getRolledDiceList();
        for (Dice d : rolledDice) {
            switch (diceSel) {
                case 0: {
                    diceOne.setBounds(900,400, 41,41);
                    diceOne.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceOne.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }
                    diceSel++;
                    break;
                }
                case 1: {
                    diceTwo.setBounds(950,400,41,41);
                    diceTwo.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceTwo.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }
                    diceSel++;
                    break;
                }
                case 2: {
                    diceThree.setBounds(1000,400,41,41);
                    diceThree.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceThree.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 3: {
                    diceFour.setBounds(1050,400,41,41);
                    diceFour.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFour.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 4: {
                    diceFive.setBounds(1100,400,41,41);
                    diceFive.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceFive.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
                case 5: {
                    diceSix.setBounds(1150,400,41,41);
                    diceSix.addActionListener(e -> selectedDice = d);
                    switch (d.getColor()) {
                        case GREEN -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                                }
                            }
                        }
                        case BLUE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                                }
                            }
                        }
                        case ORANGE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                                }
                            }
                        }
                        case YELLOW -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                                }
                            }
                        }
                        case PURPLE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                                }
                            }
                        }
                        case WHITE -> {
                            switch (d.getValue()) {
                                case 1 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                                }
                                case 2 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                                }
                                case 3 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                                }
                                case 4 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                                }
                                case 5 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                                }
                                case 6 -> {
                                    diceSix.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                                }
                            }
                        }
                    }

                    diceSel++;
                    break;
                }
            }
        }
    }

}


