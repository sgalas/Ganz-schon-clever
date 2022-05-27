import java.util.ArrayList;
import java.util.List;

public class UsedSlot {
    private List<Dice> usedSlot;
    UsedSlot(List<Dice> usedSlot){
        if(usedSlot!=null){
            this.usedSlot=usedSlot;
        } else {
            usedSlot=new ArrayList<>();
        }
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
    public List<Dice> getUsed(){
        return usedSlot;
    }
}
