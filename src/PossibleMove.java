import java.io.Serializable;
import java.util.Objects;

public class PossibleMove implements Serializable {
    private final Board board;
    private final DiceCombination diceCombination;
    private final int index;

    public PossibleMove(Board board,DiceCombination diceCombination, int index){
        this.board=board;
        this.diceCombination=diceCombination;
        this.index=index;
    }
    public PossibleMove(Board board, Dice dice, int index){
        this(board,new DiceCombination(dice),index);
    }
    public Board getBoard() {
        return board;
    }

    public DiceCombination getDiceCombination() {
        return diceCombination;
    }
    public int getIndex() {
        return index;
    }

    public TileSpecialAction doMove() throws ImpossibleFill {
        Board activeBoard = getBoard();
        return activeBoard.fillTile(getDiceCombination(), getIndex());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PossibleMove that = (PossibleMove) o;
        return getIndex() == that.getIndex() && Objects.equals(getBoard(), that.getBoard()) && Objects.equals(getDiceCombination(), that.getDiceCombination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBoard(), getDiceCombination(), getIndex());
    }
}
