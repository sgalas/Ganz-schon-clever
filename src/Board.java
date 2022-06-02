import java.util.List;

public interface Board {
    TileSpecialAction fillTile(Dice dice, int index) throws ImpossibleFill;

    int getPoints();

    List<PossibleMove> possibleMoves();
    List<PossibleMove> possibleMovesWithDice(Dice dice);
}
