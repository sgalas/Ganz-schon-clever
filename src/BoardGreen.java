import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoardGreen implements Board{
    private ArrayList<Tile> tiles;
    private final List<Dice> dices;

    public BoardGreen() {
        tiles = new ArrayList<>();
        dices = new LinkedList<>();

        for(int i = 1; i < 7; i++){
            dices.add(new Dice(Color.GREEN,i));
            dices.add(new Dice(Color.WHITE,i));
        }
        tiles.add(0, new Tile(dices,null));
        tiles.add(1, new Tile(dices,null));
        tiles.add(2, new Tile(dices,null));
        tiles.add(3, new Tile(dices,TileSpecialAction.ADDADDITIONALDICE));
        tiles.add(4, new Tile(dices,null));
        tiles.add(5, new Tile(dices,TileSpecialAction.ADDRANDOM));
        tiles.add(6, new Tile(dices,TileSpecialAction.ADDFOX));
        tiles.add(7, new Tile(dices,null));
        tiles.add(8, new Tile(dices,TileSpecialAction.ADDCONST));
        tiles.add(9, new Tile(dices,TileSpecialAction.ADDROLL));
        tiles.add(10, new Tile(dices,null));
    }

    @Override
    public TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy zielonej!");
        return tiles.get(index).fillWithDice(dice);
    }

    @Override
    public int getPoints() {
        return 0;
    }

    @Override
    public List<PossibleMove> possibleMoves() {
        return null;
    }

    @Override
    public List<PossibleMove> possibleMovesWithDice(Dice dice) {
        return null;
    }
}
