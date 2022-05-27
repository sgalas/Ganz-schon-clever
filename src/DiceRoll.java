import java.util.ArrayList;

public class DiceRoll {
    private ArrayList<Dice> dices;
    private int dicesRetrievedCount;
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

    public ArrayList<Dice> getDices() {
        return dices;
    }
    public int getDiceCount(){
        return dices.size();
    }
    public int getDicesRetrievedCount(){
        return dicesRetrievedCount;
    }
}
