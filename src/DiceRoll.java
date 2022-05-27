import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    private List<Dice> dices;
    private int dicesRetrievedCount;

    DiceRoll(List<Dice> dices){
        this.dices=dices;
    }
    public static DiceRoll rollDice(){
        List<Dice> dices = new ArrayList<>();
        for (Color color :Color.values()){
            dices=new ArrayList<>();
            dices.add(Dice.getRandomDice(color));
        }
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
