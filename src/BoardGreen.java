import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardGreen implements Board, Serializable {
    private final ArrayList<Tile> tiles;
    private final List<DiceCombination> dices;

    public BoardGreen() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new DiceCombination(new Dice(DiceColor.GREEN,i)));
            dices.add(new DiceCombination(new Dice(DiceColor.WHITE,i)));
        }
        tiles.add(0, new Tile(dices,null));
        tiles.add(1, new Tile(null,null));
        tiles.add(2, new Tile(null,null));
        tiles.add(3, new Tile(null,TileSpecialAction.ADDADDITIONALDICE));
        tiles.add(4, new Tile(null,null));
        tiles.add(5, new Tile(null,TileSpecialAction.ADDRANDOMBLUE));
        tiles.add(6, new Tile(null,TileSpecialAction.ADDFOX));
        tiles.add(7, new Tile(null,null));
        tiles.add(8, new Tile(null,TileSpecialAction.ADDPURPLE6));
        tiles.add(9, new Tile(null,TileSpecialAction.ADDROLL));
        tiles.add(10, new Tile(null,null));
    }

    @Override
    public TileSpecialAction fillTile(DiceCombination dice, int index) throws ImpossibleFillException {
        if( !(tiles.get(index).getAllowedDiceCombinationList().contains(dice)))
            throw new ImpossibleFillException("Nie można umieścić tej kostki w planszy zielonej!");

        List<DiceCombination> condition;
        condition =new LinkedList<>(dices);
        for (DiceCombination diceCombo: dices){
            Dice dice1=diceCombo.getPrimaryDice();
            if((index == 0 || index == 5) && dice1.getValue() == 1) {
                condition.remove(diceCombo);
            } else if((index == 1 || index == 6) && (dice1.getValue() == 1 || dice1.getValue() == 2)){
                condition.remove(diceCombo);
            } else if((index == 2 || index == 7) && (dice1.getValue() == 1 || dice1.getValue() == 2 || dice1.getValue() == 3)){
                condition.remove(diceCombo);
            } else if((index == 3 || index == 8) && (dice1.getValue() == 1 || dice1.getValue() == 2 || dice1.getValue() == 3 || dice1.getValue() == 4)){
                condition.remove(diceCombo);
            } else if(index == 4){
                condition.addAll(dices);
            } else if(index == 9 && dice1.getValue() == 6){
                condition.removeAll(dices);
                condition.add(diceCombo);
            }
       }
        tiles.get(index).updateAllowedDiceList(null);
        tiles.get(index + 1).updateAllowedDiceList(condition);
        return tiles.get(index).fillWithDice(dice.getPrimaryDice());
    }

    @Override
    public int getPoints() {
        int points = 0;
        int counter = 0;

        for (int i = 0; i < tiles.size() + 1; i++){
            if(tiles.get(i).getAllowedDiceCombinationList() == null){
                counter = counter + 1;
            }
        }
        if (counter == 0){
            return points;
        }
        if (counter == 1){
            points = 1;
        }
        if (counter == 2){
            points = 3;
        }
        if (counter == 3){
            points = 6;
        }
        if (counter == 4){
            points = 10;
        }
        if (counter == 5){
            points = 15;
        }
        if (counter == 6){
            points = 21;
        }
        if (counter == 7){
            points = 28;
        }
        if (counter == 8){
            points = 36;
        }
        if (counter == 9){
            points = 45;
        }
        if (counter == 10){
            points = 55;
        }
        if (counter == 11){
           points = 66;
        }
        return points;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        LinkedList<PossibleMove> moves = new LinkedList<>();
        for(int i = 0; i < tiles.size(); i++) {
            for(DiceCombination dice: dices)
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice))) {
                    moves.add(new PossibleMove(this, dice, i));
                }
        }

        return moves;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(DiceCombination dice) {
        LinkedList<PossibleMove> moveWithDice = new LinkedList<>();

        if(dices.contains(dice)){
            for(int i = 0; i < tiles.size(); i++) {
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice))){
                    moveWithDice.add(new PossibleMove(this, dice, i));
                    return moveWithDice;
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Tile> getTiles() {
        return tiles;
    }
}
