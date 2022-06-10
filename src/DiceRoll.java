import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DiceRoll implements Serializable {
    private List<Dice> dices;

    public DiceRoll(List<Dice> dices){
        this.dices=dices;
    }

    /**
     * Zwraca obiekt DiceRoll wypełniony losowymi koścmi każdego koloru
     * @return obiekt DiceRoll wypełniony losowymi koścmi każdego koloru
     */
    public static DiceRoll rollDice(){
        List<Dice> dices = new ArrayList<>();
        for (DiceColor diceColor : DiceColor.values()){
            dices.add(Dice.getRandomDice(diceColor));
        }
        return new DiceRoll(dices);
    }

    /**
     * Zwraca listę kośći
     * @return lista kości
     */
    public List<Dice> getDices() {
        return dices;
    }

    /**
     * Zwraca liczbę kości
     * @return liczba kości
     */
    public int getDiceCount(){
        return dices.size();
    }

    /**
     * Losuje kości
     */
    public void rollDices(){
        ArrayList<Dice> newDices=new ArrayList<>();
        for (Dice dice:dices){
            newDices.add(Dice.getRandomDice(dice.getColor()));
        }
        dices=newDices;
    }

    /**
     * Usuwa wybraną kość
     * @param dice kość do usunięcia
     */
    public void removeDice(Dice dice){
        dices.remove(dice);
    }

}
