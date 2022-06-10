import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SowaPlayground {




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
        used.add(new Dice(DiceColor.WHITE, 5));
        used.add(new Dice(DiceColor.YELLOW, 1));
        a.setUsedSlot(new UsedSlot(used));
        Tray tray = new Tray();
        tray.putDice(new Dice(DiceColor.PURPLE, 1));
        tray.putDice(new Dice(DiceColor.GREEN, 4));
        a.setTray(tray);
        a.setPlayerState(PlayerState.ACTIVE_TURN);
        ClientGUI abc = new ClientGUI(a);





    }

}
