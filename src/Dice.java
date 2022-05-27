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
        Dice dice=new Dice(color,random.nextInt()%6+1);
        return dice;
    }
}
