import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

public class Dice implements Serializable {
    private final DiceColor diceColor;
    private final int value;
    public Dice(DiceColor diceColor, int value){
        this.diceColor = diceColor;
        this.value=value;
    }

    /**
     * Zwraca wartość kości
     * @return wartość kości
     */
    public int getValue() {
        return value;
    }

    /**
     * Zwraca kolor kości
     * @return kolor Kości
     */
    public DiceColor getColor() {
        return diceColor;
    }
    /**
     * Zwraca nową lowową kość od 1 do 6
     * @param diceColor kolor kości
     * @return nowa losowa kość o podanym kolorze i wartości od 1 do 6
     */
    public static Dice getRandomDice(DiceColor diceColor){
        return getRandomDice(diceColor,1,7);
    }

    /**
     * Zwraca nową lowową kość o wielkości zależą od argumentów
     * @param diceColor kolor kości
     * @param origin wartość minimalna włącznie
     * @param bound wartość maksymalna nie włącznie
     * @return nowa losowa kość o podanym kolorze i wartości
     */
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
