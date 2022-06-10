import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DiceCombination implements Serializable {
    private Dice primaryDice;
    private List<Dice> dices;

    public DiceCombination(Dice primaryDice, List<Dice> dices) {
        this.primaryDice = primaryDice;
        this.dices = dices;
    }
    public DiceCombination(Dice primaryDice) {
        this.primaryDice = primaryDice;
        this.dices = null;
    }

    /**
     * Funkcja zwracająca kombinacje dwóch kości
     * @param primaryDice kość główna która jest umieszczana w pole
     * @param secondaryDice kośc poboczna
     * @return Kombinacja dwóch kości
     */
    public static DiceCombination createTwoDiceCombo(Dice primaryDice, Dice secondaryDice) {
        List<Dice> dices=new LinkedList<>();
        dices.add(secondaryDice);
        return new DiceCombination(primaryDice,dices);
    }

    /**
     * Zwraca główną kość
     * @return główna kość
     */
    public Dice getPrimaryDice() {
        return primaryDice;
    }

    /**
     * Zwraca listę pobocznych kości
     * @return lista pobocznych kości
     */
    public List<Dice> getHelperDices() {
        return dices;
    }

    /**
     * Sprawdzenie czy ma poboczną kość
     * @return zwraca true jeżeli ma
     */
    boolean hasAdditionalDices(){
        return dices.size()>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceCombination that = (DiceCombination) o;
        return Objects.equals(getPrimaryDice(), that.getPrimaryDice()) && Objects.equals(getHelperDices(), that.getHelperDices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimaryDice(), getHelperDices());
    }
}
