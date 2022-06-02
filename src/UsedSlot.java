import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsedSlot {
    private final List<Dice> usedSlot;
    UsedSlot(List<Dice> usedSlot){
        this.usedSlot = Objects.requireNonNullElseGet(usedSlot, ArrayList::new);
    }
    public UsedSlot(){
        this(null);
    }
    public void putDice(Dice dice){
        usedSlot.add(dice);
    }
    public void reset(){
        usedSlot.clear();
    }
    public List<Dice> getDices(){
        return usedSlot;
    }
}
