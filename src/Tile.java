import java.util.List;

public class Tile {
    private List<Dice> allowedDiceList;
    private Dice filledWith;
    private int specialAction;
    public List<Dice> getAllowedDiceList() {
        return allowedDiceList;
    }
    public int getSpecialAction(){
        return specialAction;
    }
}
