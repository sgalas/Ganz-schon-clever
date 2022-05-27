import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tray {
    private final List<Dice> tray;
    public Tray(List<Dice> tray){
        this.tray = Objects.requireNonNullElseGet(tray, ArrayList::new);
    }
    public Tray(){
        this(null);
    }
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
