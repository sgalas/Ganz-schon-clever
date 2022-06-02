import java.util.List;

public class Tile {
    private List<Dice> allowedDiceList;
    private Dice filledWith;
    private final SpecialAction specialAction;
    public Tile(List<Dice> allowedDiceList,SpecialAction specialAction ){
        this.allowedDiceList=allowedDiceList;
        this.specialAction=specialAction;
    }
    public List<Dice> getAllowedDiceList() {
        return allowedDiceList;
    }
    public SpecialAction getSpecialAction(){
        return specialAction;
    }
    public void updateAllowedDiceList(List<Dice> dices){
        allowedDiceList=dices;
    }
    public void fillWithDice(Dice dice){
        filledWith=dice;
    }

    public Dice getFilledWith() {
        return filledWith;
    }
}
