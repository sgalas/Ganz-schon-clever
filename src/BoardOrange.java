import java.util.ArrayList;
import java.util.List;

public class BoardOrange implements Board{
    private ArrayList<Tile> tiles;
    @Override
    public TileSpecialAction fillTile(Dice dice, int index) {
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
