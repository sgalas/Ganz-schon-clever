import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Tile implements Serializable {
    private List<DiceCombination> allowedDiceList;
    private Dice filledWith;
    private final TileSpecialAction tileSpecialAction;
    public Tile(List<DiceCombination> allowedDiceList, TileSpecialAction tileSpecialAction){
        this.allowedDiceList= Objects.requireNonNullElseGet(allowedDiceList, LinkedList::new);
        this.tileSpecialAction = tileSpecialAction;
    }

    /**
     * Zwraca listę wszyskich kombinacji kości możliwych do umieszczenia w polu
     * @return
     */
    public List<DiceCombination> getAllowedDiceCombinationList() {
        return allowedDiceList;
    }

    /**
     * Zwraca speclajną akce do wykonania na tym polu
     * @return specjalna akcja
     */
    public TileSpecialAction getSpecialAction(){
        return tileSpecialAction;
    }

    /**
     * Zaktualizwanie listy możliwych kości
     * @param dices możliwe kości
     */
    public void updateAllowedDiceList(List<DiceCombination> dices){
        allowedDiceList=Objects.requireNonNullElseGet(dices, LinkedList::new);
    }

    /**
     * Wpisywanie kości w pole
     * @param dice kość do wpisania w pole
     * @return Specjalna akcja do wykonania po wpisaniu w pole
     */
    public TileSpecialAction fillWithDice(Dice dice){
        filledWith=dice;
        return getSpecialAction();
    }

    /**
     * Zwraca przechowywaną kość
     * @return kość wpisana w pole
     */
    public Dice getFilledWith() {
        return filledWith;
    }

    /**
     * Sprawdza czy pole jest puste
     * @return Prawda jeżeli jest puste
     */
    public boolean isEmpty(){
        return getFilledWith()==null;
    }
}
