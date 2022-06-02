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
}
