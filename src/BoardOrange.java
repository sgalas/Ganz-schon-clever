import java.util.ArrayList;
import java.util.List;

public class BoardOrange implements Board{
    private ArrayList<Tile> tiles;
    @Override
    public int fillTile(Dice dice, int index) {
        return 0;
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
