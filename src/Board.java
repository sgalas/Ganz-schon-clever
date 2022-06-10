import java.util.ArrayList;
import java.util.List;

public interface Board {
    TileSpecialAction fillTile(DiceCombination dices, int index) throws ImpossibleFill;

    int getPoints();

    List<PossibleMove> possibleMoves();
    List<PossibleMove> possibleMovesWithDice(DiceCombination dice);
    ArrayList<Tile> getTiles();
}
