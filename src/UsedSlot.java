import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsedSlot implements Serializable {
    private final List<Dice> usedSlot;
    UsedSlot(List<Dice> usedSlot){
        this.usedSlot = Objects.requireNonNullElseGet(usedSlot, ArrayList::new);
    }
    public UsedSlot(){
        this(null);
    }

    /**
     * Umieszcza kośći w Used Slot
     * @param dice kość do umieszczenia w Used Slot
     */
    public void putDice(Dice dice){
        usedSlot.add(dice);
    }

    /**
     * Zwraca listę zużytych kości
     * @return listę zużytych kości
     */
    public List<Dice> getDices(){
        return usedSlot;
    }
}
