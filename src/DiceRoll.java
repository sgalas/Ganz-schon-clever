import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    private List<Dice> dices;
    private int dicesRetrievedCount;

    public DiceRoll(List<Dice> dices){
        this.dices=dices;
    }

    public static DiceRoll rollDice(){
        int counter = 0;
        int blueind = 0;
        int whiteind = 0;
        List<Dice> dices = new ArrayList<>();
        for (DiceColor diceColor : DiceColor.values()){
            dices.add(Dice.getRandomDice(diceColor));
            if(diceColor == DiceColor.BLUE){
                blueind = counter;
            }
            if(diceColor == DiceColor.WHITE){
                whiteind = counter;
            }
            counter++;
        }
        dices.add(new Dice(DiceColor.BLUE, dices.get(blueind).getValue() + dices.get(whiteind).getValue()));
        dices.remove(dices.get(blueind));
        return new DiceRoll(dices);
    }

    public List<Dice> getDices() {
        return dices;
    }
    public int getDiceCount(){
        return dices.size();
    }
    public int getDicesRetrievedCount(){
        return dicesRetrievedCount;
    }
    public void rollDices(){
        ArrayList<Dice> newDices=new ArrayList<>();
        for (Dice dice:dices){
            newDices.add(Dice.getRandomDice(dice.getColor()));
        }
        dices=newDices;
    }
    public void removeDice(Dice dice){
        dices.remove(dice);
        --dicesRetrievedCount;
    }

}
