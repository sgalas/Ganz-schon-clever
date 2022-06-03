import java.util.Objects;
import java.util.Random;

public class Dice {
    private final Color color;
    private final int value;
    public Dice(Color color,int value){
        this.color=color;
        this.value=value;
    }
    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public static Dice getRandomDice(Color color){
        Random random=new Random();
        Dice dice=new Dice(color,random.nextInt(1,7));
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
