import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DiceCombination {
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
    public static DiceCombination createTwoDiceCombo(Dice primaryDice, Dice secondaryDice) {
        List<Dice> dices=new LinkedList<>();
        dices.add(secondaryDice);
        return new DiceCombination(primaryDice,dices);
    }

    public Dice getPrimaryDice() {
        return primaryDice;
    }

    public List<Dice> getDices() {
        return dices;
    }

    boolean hasAdditionalDices(){
        return dices.size()>0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceCombination that = (DiceCombination) o;
        return Objects.equals(getPrimaryDice(), that.getPrimaryDice()) && Objects.equals(getDices(), that.getDices());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimaryDice(), getDices());
    }
}
