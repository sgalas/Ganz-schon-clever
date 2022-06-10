import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tile implements Serializable {
    private List<DiceCombination> allowedDiceList;
    private Dice filledWith;
    private final TileSpecialAction tileSpecialAction;
    public Tile(List<DiceCombination> allowedDiceList, TileSpecialAction tileSpecialAction){
        this.allowedDiceList= Objects.requireNonNullElseGet(allowedDiceList, LinkedList::new); ;
        this.tileSpecialAction = tileSpecialAction;
    }
    public List<DiceCombination> getAllowedDiceCombinationList() {
        return allowedDiceList;
    }
    public TileSpecialAction getSpecialAction(){
        return tileSpecialAction;
    }
    public void updateAllowedDiceList(List<DiceCombination> dices){
        allowedDiceList=dices;
    }
    public TileSpecialAction fillWithDice(Dice dice){
        filledWith=dice;
        return getSpecialAction();
    }

    public Dice getFilledWith() {
        return filledWith;
    }
    public boolean isEmpty(){
        return getFilledWith()==null;
    }
}
