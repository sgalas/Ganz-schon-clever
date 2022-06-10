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

    /**
     * Zwraca kobinacje kości potrzebną do wykonania ruchu
     * @return kobinacja kości potrzebną do wykonania ruchu
     */
    public DiceCombination getDiceCombination() {
        return diceCombination;
    }

    /**
     * Zwraca numer ineksu pola do którego kość zostanie wsadzona
     * @return numer ineksu pola do którego kość zostanie wsadzona
     */
    public int getIndex() {
        return index;
    }

    /**
     * Wykonuje ruch na planszy
     * @return specjalna akcja powiązana z polem na któym wykonywana jest akcja
     * @throws ImpossibleFillException wyjątek z powodu niemożliwej operacji
     */
    public TileSpecialAction doMove() throws ImpossibleFillException {
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
