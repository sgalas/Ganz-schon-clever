import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardPurple implements Board, Serializable {
    private final ArrayList<Tile> tiles;
    private final List<DiceCombination> dices;

    public BoardPurple() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new DiceCombination(new Dice(DiceColor.PURPLE,i)));
            dices.add(new DiceCombination(new Dice(DiceColor.WHITE,i)));
        }
        tiles.add(0, new Tile(dices,null));
        tiles.add(1, new Tile(null,null));
        tiles.add(2, new Tile(null,TileSpecialAction.ADDROLL));
        tiles.add(3, new Tile(null,TileSpecialAction.ADDRANDOMBLUE));
        tiles.add(4, new Tile(null,TileSpecialAction.ADDROLL));
        tiles.add(5, new Tile(null,TileSpecialAction.ADDRANDOMYELLOW));
        tiles.add(6, new Tile(null,TileSpecialAction.ADDFOX));
        tiles.add(7, new Tile(null,TileSpecialAction.ADDADDITIONALDICE));
        tiles.add(8, new Tile(null,TileSpecialAction.ADDRANDOMGREEN));
        tiles.add(9, new Tile(null,TileSpecialAction.ADDORANGE6));
        tiles.add(10, new Tile(null,TileSpecialAction.ADDADDITIONALDICE));
    }

    @Override
    public TileSpecialAction fillTile(DiceCombination dice, int index) throws ImpossibleFillException {
        if( !(tiles.get(index).getAllowedDiceCombinationList().contains(dice)))
            throw new ImpossibleFillException("Nie można umieścić tej kostki w planszy fioletowej!");

        List<DiceCombination> filled;
        filled = dices;
        for(DiceCombination dice1: dices){
            if(dice.getPrimaryDice().getValue() >= dice1.getPrimaryDice().getValue()){
                filled.remove(dice1);
            }
            if(dice.getPrimaryDice().getValue() == 6){
                filled.add(dice1);
            }
        }
        tiles.get(index + 1).updateAllowedDiceList(filled);
        return tiles.get(index).fillWithDice(dice.getPrimaryDice());
    }

    @Override
    public int getPoints() {
        int points = 0;
        for(int i = 0; i < tiles.size() + 1; i++) {
            int temp = tiles.get(i).getFilledWith().getValue();
            points = points + temp;
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
