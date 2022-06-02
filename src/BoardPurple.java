import java.util.ArrayList;
import java.util.List;

public class BoardPurple implements Board{
    private ArrayList<Tile> tiles;
    @Override
    public TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill {
        if( !(tiles.get(index).getAllowedDiceList().contains(dice)))
            throw new ImpossibleFill("Nie można umieścić tej kostki w planszy fioletowej!");
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
