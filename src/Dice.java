import java.util.Objects;
import java.util.Random;

public class Dice {
    private final DiceColor diceColor;
    private final int value;
    public Dice(DiceColor diceColor, int value){
        this.diceColor = diceColor;
        this.value=value;
    }
    public int getValue() {
        return value;
    }
    public DiceColor getColor() {
        return diceColor;
    }
    public static Dice getRandomDice(DiceColor diceColor){
        return getRandomDice(diceColor,1,7);
    }
    public static Dice getRandomDice(DiceColor diceColor, int origin, int bound){
        Random random=new Random();
        Dice dice=new Dice(diceColor,random.nextInt(origin,bound));
        return dice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dice dice = (Dice) o;
        return getValue() == dice.getValue() && getColor() == dice.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getColor(), getValue());
    }
}
