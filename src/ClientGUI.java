import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientGUI {

    //Zmienna przechowujaca gracza - w celu wykonywania operacji - przekazywana na etapie tworzenia
    private Player player;
    private List<Dice> reusedDice = new ArrayList<>();
    private List<Dice> usedDice = new ArrayList<>();
    private List<Dice> trayDice = new ArrayList<>();
    private boolean canReuse;

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

    private void addTileAction(JButton button, String color, int index) {
        button.addActionListener(e -> {
            if (selectedDice == null) {
                showEmptyError();
            }
            else {
                if (player.getPlayerState().equals(PlayerState.ACTIVE_TURN)) {
                    if ((trayDice.contains(selectedDice) || usedDice.contains(selectedDice) || reusedDice.contains(selectedDice)) && !canReuse) {
                        showBadDiceError();
                        selectedDice = null;
                        return;
                    }
                }
                if(player.getPossibleMovesForDices(trayDice).size() > 0 && usedDice.contains(selectedDice)){
                    showBadDiceError();
                    selectedDice = null;
                    return;
                }
                        if (canReuse) {
                            reusedDice.add(selectedDice);
                            canReuse = false;
                        }
                        PossibleMove possibleMove = null;
                        switch (color) {
                            case "green" -> possibleMove = new PossibleMove(player.getBoardGreen(), selectedDice, index);
                            case "yellow" -> possibleMove = new PossibleMove(player.getBoardYellow(), selectedDice, index);
                            case "orange" -> possibleMove = new PossibleMove(player.getBoardOrange(), selectedDice, index);
                            case "purple" -> possibleMove = new PossibleMove(player.getBoardPurple(), selectedDice, index);
                            case "blue" -> {
                                if (!(selectedDice.getColor().equals(DiceColor.BLUE) || selectedDice.getColor().equals(DiceColor.WHITE))) {
                                    showFillError();
                                    selectedDice = null;
                                    return;
                                }
                                if (selectedDice.getColor().equals(DiceColor.BLUE))
                                    possibleMove = new PossibleMove(player.getBoardBlue(), DiceCombination.createTwoDiceCombo(selectedDice, player.getDice(DiceColor.WHITE)), index);
                                else
                                    possibleMove = new PossibleMove(player.getBoardBlue(), DiceCombination.createTwoDiceCombo(selectedDice, player.getDice(DiceColor.BLUE)), index);

                            }
                        }
                        try {
                            player.executeMove(possibleMove);
                            switch (color) {
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
                                case "blue" -> button.setIcon(new ImageIcon("src/Images/X_Button.png"));

                            }
                        } catch (InvalidMoveException exception) {
                            showFillError();
                        } catch (NotReadyException exception) {
                            notYourTurnError();
                        }
                        selectedDice = null;

                }

        });
    }

    //Inicjalizacja wszystkich przycisków - konieczna w tym miejscu z powodu odnoszenia się do nich z różnych metod
        JFrame f = new JFrame(); // Ramka "zerowa" - podstawa gui
        JLayeredPane lp = new JLayeredPane(); // Jedyny element JFrame, zawierający wszystkie przyciski
        JButton y00; //Przycisk żółty - kolumna 0 rząd 0
        JButton y01; // Przycisk żółty - kolumna 0 rząd 1
        JButton y02;
        JButton y10;
        JButton y20;
        JButton y30 = new JButton();
        JButton y03 = new JButton();
        JButton y11;
        JButton y12 = new JButton();
        JButton y13;
        JButton y21 = new JButton();
        JButton y22;
        JButton y23;
        JButton y31;
        JButton y32;
        JButton y33;
        JButton b01;
        JButton b02;
        JButton b03;
        JButton b10;
        JButton b11;
        JButton b12;
        JButton b13;
        JButton b20;
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
        JButton o1;
        JButton o2;
        JButton o3;
        JButton o4;
        JButton o5;
        JButton o6;
        JButton o7;
        JButton o8;
        JButton o9;
        JButton o10;
        JButton o11;

        JButton p1;
        JButton p2;
        JButton p3;
        JButton p4;
        JButton p5;
        JButton p6;
        JButton p7;
        JButton p8;
        JButton p9;
        JButton p10;
        JButton p11;

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
        reroll.addActionListener(e -> {
            if(player.getRerollCount() > 0)
                player.useReroll();
        });
        additional.addActionListener(e -> {
            if(player.getAdditionalDiceCount() > 0)
                player.useAdditionalDice();
                canReuse = true;
        });
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

        addTileAction(b01, "blue", 0);
        addTileAction(b02, "blue", 1);
        addTileAction(b03, "blue", 2);
        addTileAction(b10, "blue", 3);
        addTileAction(b11, "blue", 4);
        addTileAction(b12, "blue", 5);
        addTileAction(b13, "blue", 6);
        addTileAction(b20, "blue", 7);
        addTileAction(b21, "blue", 8);
        addTileAction(b22, "blue", 9);
        addTileAction(b23, "blue", 10);



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

            addTileAction(p1, "purple", 0);
            addTileAction(p2, "purple", 1);
            addTileAction(p3, "purple", 2);
            addTileAction(p4, "purple", 3);
            addTileAction(p5, "purple", 4);
            addTileAction(p6, "purple", 5);
            addTileAction(p7, "purple", 6);
            addTileAction(p8, "purple", 7);
            addTileAction(p9, "purple", 8);
            addTileAction(p10, "purple", 9);
            addTileAction(p11, "purple", 10);

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

    public void resetReused(){
        reusedDice = null;
    }
    private void showFillError(){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nie można wypełnic tego pola wybraną kostką!", "Błąd",
                JOptionPane.WARNING_MESSAGE);
    }

    private void showBadDiceError(){
        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nie można użyć tej kostki!", "Błąd",
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
        updateActive();
        updateUsed();
        updateTray();
        updateActions();
    }

    public void updateActions(){
        rerollCount.setText(String.valueOf(player.getRerollCount()));
        additionalCount.setText(String.valueOf(player.getAdditionalDiceCount()));
        roundCount.setText(roundCount.getText() + player.getRound());
    }

    public void setDice(JButton dice, Dice d, int x, int y){
        dice.setBounds(x, y, 41, 41);
        ActionListener[] listeners = dice.getActionListeners();
        for (ActionListener l : listeners) {
            dice.removeActionListener(l);
        }
        dice.addActionListener(e -> selectedDice = d);
        switch (d.getColor()) {
            case GREEN -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Green.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Green.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Green.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Green.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Green.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Green.png"));
                }
            }
            case BLUE -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Blue.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Blue.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Blue.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Blue.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Blue.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Blue.png"));
                }
            }
            case ORANGE -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Orange.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Orange.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Orange.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Orange.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Orange.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Orange.png"));
                }
            }
            case YELLOW -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Yellow.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Yellow.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Yellow.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Yellow.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Yellow.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Yellow.png"));
                }
            }
            case PURPLE -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One_Purple.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two_Purple.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three_Purple.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four_Purple.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five_Purple.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six_Purple.png"));
                }
            }
            case WHITE -> {
                switch (d.getValue()) {
                    case 1 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_One.png"));
                    case 2 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Two.png"));
                    case 3 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Three.png"));
                    case 4 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Four.png"));
                    case 5 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Five.png"));
                    case 6 -> dice.setIcon(new ImageIcon("src/Images/Dices/Dice_Six.png"));
                }
            }
        }
        diceSel++;
    }



    public void updateTray(){
        List<Dice> trayList;
        trayList = player.getTrayDiceList();
        trayDice = trayList;
        for(Dice d: trayList){
            switch (diceSel){
                case 0 -> setDice(diceOne, d, 950, 550);
                case 1 -> setDice(diceTwo, d, 1000, 550);
                case 2 -> setDice(diceThree, d, 1050, 550);
                case 3 -> setDice(diceFour, d, 940, 600);
                case 4 -> setDice(diceFive, d, 990, 600);
                case 5 -> setDice(diceSix, d, 1040, 600);
            }
        }

    }

    public void updateUsed(){

        List<Dice> usedUserDice;
        usedUserDice = player.getUsedSlot().getDices();
        usedDice = usedUserDice;
        int howManyDice = 0;
        for(Dice d: usedUserDice){
            switch (diceSel) {
                case 0 -> {
                    setDice(diceOne, d, 1205, 530);
                    howManyDice++;

                }
                case 1 -> {
                    if (howManyDice == 0)
                        setDice(diceTwo, d, 1205, 530);
                    else
                        setDice(diceTwo, d, 1205, 605);
                    howManyDice++;
                }
                case 2 -> {
                    if (howManyDice == 0)
                        setDice(diceThree, d, 1205, 530);
                    else {
                        if (howManyDice == 1)
                            setDice(diceThree, d, 1205, 605);
                        else
                            setDice(diceThree, d, 1205, 680);
                    }
                    howManyDice++;
                }
                case 3 -> {
                    if (howManyDice == 0)
                        setDice(diceFour, d, 1205, 530);
                    else {
                        if (howManyDice == 1)
                            setDice(diceFour, d, 1205, 605);
                        else
                            setDice(diceFour, d, 1205, 680);
                    }
                    howManyDice++;
                }
                case 4 -> {
                    if (howManyDice == 0)
                        setDice(diceFive, d, 1205, 530);
                    else {
                        if (howManyDice == 1)
                            setDice(diceFive, d, 1205, 605);
                        else
                            setDice(diceFive, d, 1205, 680);
                    }
                    howManyDice++;
                }
                case 5 -> {
                    if (howManyDice == 0)
                        setDice(diceSix, d, 1205, 530);
                    else {
                        if (howManyDice == 1)
                            setDice(diceSix, d, 1205, 605);
                        else
                            setDice(diceSix, d, 1205, 680);
                    }
                    howManyDice++;
                }

            }
        }
    }

    public void updateActive() {
        List<Dice> rolledDice;
        rolledDice = player.getRolledDiceList();
        for(Dice d: rolledDice){
            switch (diceSel){
                case 0 -> setDice(diceOne, d, 900, 400);
                case 1 -> setDice(diceTwo, d, 950, 400);
                case 2 -> setDice(diceThree, d, 1000, 400);
                case 3 -> setDice(diceFour, d, 1050, 400);
                case 4 -> setDice(diceFive, d, 1100, 400);
                case 5 -> setDice(diceSix, d, 1150, 400);
            }
        }
    }

    public void repaintBoards(){
        int index = 0;
        for(Tile tile:player.getBoardYellow().getTiles()){
            if(!tile.isEmpty()){
                selectedDice = tile.getFilledWith();
                switch(index){
                    case 0 -> y00.doClick();
                    case 1 -> y10.doClick();
                    case 2 -> y20.doClick();
                    case 3 -> y01.doClick();
                    case 4 -> y11.doClick();
                    case 5 -> y31.doClick();
                    case 6 -> y02.doClick();
                    case 7 -> y22.doClick();
                    case 8 -> y32.doClick();
                    case 9 -> y13.doClick();
                    case 10 -> y23.doClick();
                    case 11 -> y33.doClick();
                }
            }
            index++;
        }
        for(Tile tile:player.getBoardBlue().getTiles()){
            if(!tile.isEmpty()){
                selectedDice = tile.getFilledWith();
                switch(index){
                    case 0 -> b01.doClick();
                    case 1 -> b02.doClick();
                    case 2 -> b03.doClick();
                    case 3 -> b10.doClick();
                    case 4 -> b11.doClick();
                    case 5 -> b12.doClick();
                    case 6 -> b13.doClick();
                    case 7 -> b20.doClick();
                    case 8 -> b21.doClick();
                    case 9 -> b22.doClick();
                    case 10 -> b23.doClick();
                }
            }
            index++;
        }
        index = 0;
        for (Tile tile:player.getBoardOrange().getTiles()){
            if(!tile.isEmpty()){
                selectedDice = tile.getFilledWith();
                switch(index){
                    case 0 -> o1.doClick();
                    case 1 -> o2.doClick();
                    case 2 -> o3.doClick();
                    case 3 -> o4.doClick();
                    case 4 -> o5.doClick();
                    case 5 -> o6.doClick();
                    case 6 -> o7.doClick();
                    case 7 -> o8.doClick();
                    case 8 -> o9.doClick();
                    case 9 -> o10.doClick();
                    case 10 -> o11.doClick();
                }
            }
            index++;
        }
        index = 0;
        for(Tile tile: player.getBoardPurple().getTiles()){
            if(!tile.isEmpty()){
                selectedDice = tile.getFilledWith();
                switch(index){
                    case 0 -> p1.doClick();
                    case 1 -> p2.doClick();
                    case 2 -> p3.doClick();
                    case 3 -> p4.doClick();
                    case 4 -> p5.doClick();
                    case 5 -> p6.doClick();
                    case 6 -> p7.doClick();
                    case 7 -> p8.doClick();
                    case 8 -> p9.doClick();
                    case 9 -> p10.doClick();
                    case 10 -> p11.doClick();
                }
            }
            index++;
        }
        index = 0;
        for(Tile tile: player.getBoardGreen().getTiles()){
            if(!tile.isEmpty()){
                selectedDice = tile.getFilledWith();
                switch(index){
                    case 0 -> g1.doClick();
                    case 1 -> g2.doClick();
                    case 2 -> g3.doClick();
                    case 3 -> g4.doClick();
                    case 4 -> g5.doClick();
                    case 5 -> g6.doClick();
                    case 6 -> g7.doClick();
                    case 7 -> g8.doClick();
                    case 8 -> g9.doClick();
                    case 9 -> g10.doClick();
                    case 10 -> g11.doClick();
                }
            }
            index++;
        }
    }

}


