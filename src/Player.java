import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Player {
    private final int id;
    private String nick;
    private int rerollCount;
    private int additionalDiceCount;
    private int foxCount;
    private final BoardGreen boardGreen;
    private final BoardPurple boardPurple;
    private final BoardOrange boardOrange;
    private final BoardBlue boardBlue;
    private final BoardYellow boardYellow;
    private UsedSlot usedSlot;
    private DiceRoll diceRoll;
    private Tray tray;

    public Player(int id, String nick, int rerollCount, int additionalDiceCount, int foxCount, BoardGreen boardGreen, BoardPurple boardPurple, BoardOrange boardOrange, BoardBlue boardBlue, BoardYellow boardYellow) {
        this.id = id;
        this.nick = nick;
        this.rerollCount = rerollCount;
        this.additionalDiceCount = additionalDiceCount;
        this.foxCount = foxCount;
        this.boardGreen = boardGreen;
        this.boardPurple = boardPurple;
        this.boardOrange = boardOrange;
        this.boardBlue = boardBlue;
        this.boardYellow = boardYellow;
    }
    public static Player createNewPlayer(int id, String nick) {
        BoardGreen boardGreen=new BoardGreen();
        BoardPurple boardPurple =new BoardPurple();
        BoardOrange boardOrange=new BoardOrange();
        BoardBlue boardBlue=new BoardBlue();
        BoardYellow boardYellow=new BoardYellow();
        Player player =new Player(id,nick,0,0,0,boardGreen, boardPurple,boardOrange,boardBlue,boardYellow);
        return player;
    }

    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> retList = boardGreen.possibleMoves();
        retList.addAll(boardPurple.possibleMoves());
        retList.addAll(boardOrange.possibleMoves());
        retList.addAll(boardBlue.possibleMoves());
        retList.addAll(boardYellow.possibleMoves());
        return retList;
    }

    public List<PossibleMove> getPossibleMovesForDice(Dice dice) {
        List<PossibleMove> retList = boardGreen.possibleMovesWithDice(dice);
        retList.addAll(boardPurple.possibleMovesWithDice(dice));
        retList.addAll(boardOrange.possibleMovesWithDice(dice));
        retList.addAll(boardBlue.possibleMovesWithDice(dice));
        retList.addAll(boardYellow.possibleMovesWithDice(dice));
        return retList;
    }
    public List<PossibleMove> getPossibleMovesForDices(List<Dice> dices) {
        List<PossibleMove> retList=new LinkedList<>();
        for(Dice dice:dices){
            retList.addAll(getPossibleMovesForDice(dice));
        }
        return retList;
    }

    public String getNick() {
        return nick;
    }

    public int getId() {
        return id;
    }

    public int getFoxCount() {
        return foxCount;
    }

    public BoardGreen getBoardGreen() {
        return boardGreen;
    }

    public BoardPurple getBoardPurple() {
        return boardPurple;
    }

    public BoardOrange getBoardOrange() {
        return boardOrange;
    }

    public BoardBlue getBoardBlue() {
        return boardBlue;
    }

    public BoardYellow getBoardYellow() {
        return boardYellow;
    }

    public UsedSlot getUsedSlot() {
        return usedSlot;
    }

    public DiceRoll getDiceRoll() {
        return diceRoll;
    }

    public Tray getTray() {
        return tray;
    }

    public void setUsedSlot(UsedSlot usedSlot) {
        this.usedSlot = usedSlot;
    }

    public void setDiceRoll(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }

    public void addFox() {
        ++foxCount;
    }

    public int getRerollCount() {
        return rerollCount;
    }
    public void useReroll(){
        --rerollCount;
    }
    public void addReroll(){
        ++rerollCount;
    }
    public int getAdditionalDiceCount(){
        return additionalDiceCount;
    }
    public void useAdditionalDice(){
        --additionalDiceCount;
    }
    public void addAdditionalDice(){
        ++additionalDiceCount;
    }
}