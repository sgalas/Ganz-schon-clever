import java.util.Objects;

public class PossibleMove {
    private final Board board;
    private final Dice dice;
    private final int index;

    public PossibleMove(Board board, Dice dice, int index){
        this.board=board;
        this.dice=dice;
        this.index=index;
    }
    public Board getBoard() {
        return board;
    }

    public Dice getDice() {
        return dice;
    }

    public int getIndex() {
        return index;
    }

    public TileSpecialAction doMove() throws ImpossibleFill {
        Board activeBoard = getBoard();
        return activeBoard.fillTile(getDice(), getIndex());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PossibleMove that = (PossibleMove) o;
        return getIndex() == that.getIndex() && Objects.equals(getBoard(), that.getBoard()) && Objects.equals(getDice(), that.getDice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBoard(), getDice(), getIndex());
    }
}
