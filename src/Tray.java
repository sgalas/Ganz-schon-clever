import java.util.Iterator;
import java.util.List;

public class Tray {
    private List<Dice> tray;

    public void putDice(Dice dice){
        tray.add(dice);
    }
    public void reset(){
        tray.clear();
    }
    public List<Dice> getTray(){
        return tray;
    }
}
