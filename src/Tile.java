import java.util.List;

public class Tile {
    private List<Dice> allowedDiceList;
    private Dice filledWith;
    private final TileSpecialAction tileSpecialAction;
    public Tile(List<Dice> allowedDiceList, TileSpecialAction tileSpecialAction){
        this.allowedDiceList=allowedDiceList;
        this.tileSpecialAction = tileSpecialAction;
    }
    public List<Dice> getAllowedDiceList() {
        return allowedDiceList;
    }
    public TileSpecialAction getSpecialAction(){
        return tileSpecialAction;
    }
    public void updateAllowedDiceList(List<Dice> dices){
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
