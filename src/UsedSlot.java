import java.util.List;

public class UsedSlot {
    private List<Dice> usedSlot;

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
