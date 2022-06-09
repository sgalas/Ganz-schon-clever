import java.util.List;

public class Tile {
    private List<DiceCombination> allowedDiceList;
    private Dice filledWith;
    private final TileSpecialAction tileSpecialAction;
    public Tile(List<DiceCombination> allowedDiceList, TileSpecialAction tileSpecialAction){
        this.allowedDiceList=allowedDiceList;
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
