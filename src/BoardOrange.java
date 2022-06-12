import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardOrange implements Board, Serializable {
    private final ArrayList<Tile> tiles;
    private final List<DiceCombination> dices;

    public BoardOrange() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new DiceCombination(new Dice(DiceColor.ORANGE,i)));
            dices.add(new DiceCombination(new Dice(DiceColor.WHITE,i)));
        }

        tiles.add(0, new Tile(dices,null));
        tiles.add(1, new Tile(null,null));
        tiles.add(2, new Tile(null,TileSpecialAction.ADDROLL));
        tiles.add(3, new Tile(null,null));
        tiles.add(4, new Tile(null,TileSpecialAction.ADDRANDOMYELLOW));
        tiles.add(5, new Tile(null,TileSpecialAction.ADDADDITIONALDICE));
        tiles.add(6, new Tile(null,null));
        tiles.add(7, new Tile(null,TileSpecialAction.ADDFOX));
        tiles.add(8, new Tile(null,null));
        tiles.add(9, new Tile(null,TileSpecialAction.ADDPURPLE6));
        tiles.add(10, new Tile(null,null));
    }


    @Override
    public TileSpecialAction fillTile(DiceCombination dice, int index) throws ImpossibleFillException {

        if( !(tiles.get(index).getAllowedDiceCombinationList().contains(dice))){
            throw new ImpossibleFillException("Nie można umieścić tej kostki w planszy pomarańczowej!");
        }
        tiles.get(index).updateAllowedDiceList(null);
        tiles.get(index + 1).updateAllowedDiceList(dices);
        return tiles.get(index).fillWithDice(dice.getPrimaryDice());
    }

    @Override
    public int getPoints() {
        int points = 0;
        for(int i = 0; i < tiles.size(); i++) {
            Dice dice=tiles.get(i).getFilledWith();
            if(dice!=null){
                int temp = dice.getValue();
                if (i == 3) {
                    temp = temp * 2;
                } else if (i == 6) {
                    temp = temp * 2;
                } else if (i == 8) {
                    temp = temp * 2;
                } else if (i == 10) {
                    temp = temp * 3;
                }
                points = points + temp;
            }

        }
        return points;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        LinkedList<PossibleMove> moves = new LinkedList<>();
        for(int i = 0; i < tiles.size(); i++) {
            for(DiceCombination singleDiceCombo: dices){
                if((tiles.get(i).getAllowedDiceCombinationList().contains(singleDiceCombo))) {
                    moves.add(new PossibleMove(this, singleDiceCombo.getPrimaryDice(), i));
                }
            }
        }

        return moves;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(DiceCombination dice) {
        LinkedList<PossibleMove> moveWithDice = new LinkedList<>();

        if(dices.contains(dice)){
            for(int i = 0; i < tiles.size(); i++) {
                if((tiles.get(i).getAllowedDiceCombinationList().contains(dice))) {
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
