import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tray implements Serializable {
    private final List<Dice> tray;
    public Tray(List<Dice> tray){
        this.tray = Objects.requireNonNullElseGet(tray, ArrayList::new);
    }
    public Tray(){
        this(null);
    }

    /**
     * Umieszcza kość w Tacy
     * @param dice
     */
    public void putDice(Dice dice){
        tray.add(dice);
    }

    /**
     * Zwraca listę kości w tacy
     * @return Lista kości w tacy
     */
    public List<Dice> getDices(){
        return tray;
    }
}
