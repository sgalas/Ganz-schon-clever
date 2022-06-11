import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player implements Serializable {
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
    private Queue<PossibleMove> moveQueue;
    private PlayerState playerState;
    private int round;
    public Player(int id, String nick, int rerollCount, int additionalDiceCount, int foxCount, BoardGreen boardGreen, BoardPurple boardPurple, BoardOrange boardOrange, BoardBlue boardBlue, BoardYellow boardYellow, Queue<PossibleMove> moveQueue, PlayerState playerState,int round,UsedSlot usedSlot,DiceRoll diceRoll,Tray tray ) {
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
        this.moveQueue = moveQueue;
        this.playerState = playerState;
        this.round=round;
        this.usedSlot=usedSlot;
        this.tray=tray;
        this.diceRoll=diceRoll;
    }

    /**
     * Funkcja tworząca nowego gracza
     * @param id id gracza
     * @param nick nick gracza
     * @return funkcja zwraca nowo utworzonego gracza
     */
    public static Player createNewPlayer(int id, String nick) {
        BoardGreen boardGreen=new BoardGreen();
        BoardPurple boardPurple =new BoardPurple();
        BoardOrange boardOrange=new BoardOrange();
        BoardBlue boardBlue=new BoardBlue();
        BoardYellow boardYellow=new BoardYellow();
        Queue<PossibleMove> moveQueue=new LinkedList<>();
        PlayerState playerState=PlayerState.FINISHED_TURN;
        UsedSlot usedSlot=new UsedSlot();
        DiceRoll diceRoll=new DiceRoll();
        Tray tray=new Tray();
        Player player =new Player(id,nick,0,0,0,boardGreen, boardPurple,boardOrange,boardBlue,boardYellow,moveQueue,playerState,0,usedSlot,diceRoll,tray);
        return player;
    }

    /**
     * Funkcja zwraca wszystkie możliwe ruchy
     * @return lista wszystkich możliwych ruchów
     */
    public List<PossibleMove> getPossibleMoves() {
        List<PossibleMove> retList = boardGreen.possibleMoves();
        retList.addAll(boardPurple.possibleMoves());
        retList.addAll(boardOrange.possibleMoves());
        retList.addAll(boardBlue.possibleMoves());
        retList.addAll(boardYellow.possibleMoves());
        return retList;
    }

    /**
     * Funkcja zwraca wszystkie możliwe ruchy
     * @param dice lista wszystkich możliwych ruchów dla danej kostki
     * @return lista wszystkich możliwych ruchów dla danej kostki
     */
    public List<PossibleMove> getPossibleMovesForDice(DiceCombination dice) {
        List<PossibleMove> retList = boardGreen.possibleMovesWithDice(dice);
        retList.addAll(boardPurple.possibleMovesWithDice(dice));
        retList.addAll(boardOrange.possibleMovesWithDice(dice));
        retList.addAll(boardBlue.possibleMovesWithDice(dice));
        retList.addAll(boardYellow.possibleMovesWithDice(dice));
        return retList;
    }
    public List<PossibleMove> getPossibleMovesForDicesCombinations(List<DiceCombination>dices){
        List<PossibleMove> retList = new ArrayList<>();
        for (DiceCombination diceCombination:dices){
            retList.addAll(getPossibleMovesForDice(diceCombination));
        }
        return retList;
    }
    public List<PossibleMove> getPossibleMovesForDices(List<Dice>dices){
        List<PossibleMove> retList = getPossibleMoves();
        for (PossibleMove possibleMove:new ArrayList<>(retList)){
            DiceCombination diceCombination=possibleMove.getDiceCombination();
            if(!dices.contains(diceCombination.getPrimaryDice()))
            {
                retList.remove(possibleMove);
                continue;
            }
            if(diceCombination.getHelperDices()!=null){
                for (Dice dicehelper:diceCombination.getHelperDices()){
                    if(!dices.contains(dicehelper))
                    {
                        retList.remove(possibleMove);
                        break;
                    }
                }
            }
        }
        return retList;
    }

    /**
     * Zwraca numer rundy
     * @return numer rundy
     */
    public int getRound() {
        return round;
    }

    /**
     * Zwraca nick gracza
     * @return nick gracza
     */
    public String getNick() {
        return nick;
    }

    /**
     * Zwraca id gracza
     * @return id gracza
     */
    public int getId() {
        return id;
    }

    /**
     * Zwraca Liczbe lisków
     * @return liczba lisków
     */
    public int getFoxCount() {
        return foxCount;
    }

    /**
     * Zwraca Zieloną planszę
     * @return zielona plansza
     */
    public BoardGreen getBoardGreen() {
        return boardGreen;
    }

    /**
     * Zwraca filoetową planszę
     * @return filotowa plansza
     */
    public BoardPurple getBoardPurple() {
        return boardPurple;
    }

    /**
     * Zwraca pomarańczową planszę
     * @return pomarańczowa plansza
     */
    public BoardOrange getBoardOrange() {
        return boardOrange;
    }

    /**
     * Zwraca Niebieską planszę
     * @return niebieska plansza
     */
    public BoardBlue getBoardBlue() {
        return boardBlue;
    }

    /**
     * Zwraca żółtą plansze
     * @return żółta plansza
     */
    public BoardYellow getBoardYellow() {
        return boardYellow;
    }

    /**
     * Zwraca Zwraca obiekt UsedSlot który przechowuję i zarządza zurzytymi kośćmi
     * @return obiekt UsedSlot który przechowuję i zarządza zurzytymi kośćmi
     */
    public UsedSlot getUsedSlot() {
        return usedSlot;
    }

    /**
     * Zwraca Zwraca obiekt DiceRoll który przechowuję i zarządza nowo wylosowanymi kośćmi
     * @return obiekt DiceRoll który przechowuję i zarządza nowo wylosowanymi kośćmi
     */
    public DiceRoll getDiceRoll() {
        return diceRoll;
    }

    /**
     * Zwraca obiekt Tray czyli Tacę przechowującą kości które spadły na tace
     * @return obiekt Tray czyli Tacę przechowującą kości które spadły na tace
     */
    public Tray getTray() {
        return tray;
    }

    /**
     * Zwraca listę zużytych kości
     * @return lista zużytych kości
     */
    public List<Dice> getUsedDiceList() {
        return usedSlot.getDices();
    }
    /**
     * Zwraca listę kości na tacy
     * @return lista kości na tacy
     */
    public List<Dice> getTrayDiceList() {
        return tray.getDices();
    }
    /**
     * Zwraca listę nowo wylosowanych kości
     * @return lista nowo wylosowanych kości
     */
    public List<Dice> getRolledDiceList() {
        return diceRoll.getDices();
    }

    /**
     * Ustawienie zużytych kości na te w przekazane w UsedSlot jako argument
     * @param usedSlot obiekt UsedSlot przechowujący zużyte kości
     */
    public void setUsedSlot(UsedSlot usedSlot) {
        this.usedSlot = usedSlot;
    }

    /**
     * Ustawienie nowo wylosowanych kości na te przekazane w UsedSlot jako argument
     * @param diceRoll  obiekt UsedSlot przechowujący zużyte kości
     */
    public void setDiceRoll(DiceRoll diceRoll) {
        this.diceRoll = diceRoll;
    }

    /**
     * Ustawienie kości na tacy na te przekazane w Tray jako argument
     * @param tray taca z kośćmi
     */
    public void setTray(Tray tray) {
        this.tray = tray;
    }

    /**
     * Zwiększenie ilości lisków
     */
    public void addFox() {
        ++foxCount;
    }

    /**
     * Zwraca ilość dodatkowych ponownych rzutów kośćmi
     * @return ilość dodatkowych ponownych rzutów kośćmi
     */
    public int getRerollCount() {
        return rerollCount;
    }

    /**
     * Wykorzystuje ponowne losowanie kości
     */
    public void useReroll(){
        if(rerollCount>0){
            --rerollCount;
            diceRoll.rollDices();
        }
    }

    /**
     * Dodaje 1 dodatkowy ponowny rzut kośćmi
     */
    public void addReroll(){
        ++rerollCount;
    }

    /**
     * Zwraca liczbę możliwych wykonań otrzymania dodatkowej kości
     * @return liczba możliwych wykonań otrzymania dodatkowej kości
     */
    public int getAdditionalDiceCount(){
        return additionalDiceCount;
    }

    /**
     * Używa dodatkowej kości
     */
    public void useAdditionalDice(){
        --additionalDiceCount;
    }

    /**
     * Dodaje dodatkową możwliość ponownego użycia kości
     */
    public void addAdditionalDice(){
        ++additionalDiceCount;
    }

    /**
     * Dodaje ruch do listy ruchów do wykonania
     * @param possibleMove ruch do wykonania
     * @throws InvalidMoveException wyjątek wynikający z niepoprawnego ruchu
     * @throws NotReadyException wyjątek wynikający z niegotowości na kolejny ruch
     */
    public void executeMove(PossibleMove possibleMove) throws InvalidMoveException, NotReadyException {
        verifyMove(possibleMove);
        moveQueue.add(possibleMove);
        setPlayerState(PlayerState.FINISHED_TURN);
    }

    /**
     * Zwraca kolejkę ruchów do wykonania
     * @return kolejka ruchów do wykonania
     */
    public Queue<PossibleMove> getMoveQueue() {
        return moveQueue;
    }

    /**
     * Zwraca enumerator stanu gracza
     * @return enumerator stanu gracza
     */
    public PlayerState getPlayerState() {
        return playerState;
    }

    /**
     * Zwraca Stan gracza
     * @param playerState stan gracza
     */
    public void setPlayerState(PlayerState playerState) {
        this.playerState = playerState;
    }

    /**
     * Weryfikuje czy ruch jest poprawny i jeżeli nie jest to wyrzuca wyjątek
     * @param possibleMove możliwy ruch do wykonania
     * @throws InvalidMoveException wyjątek wynikający z tego, że ruch jest niemożliwy do wykonania
     * @throws NotReadyException wyjątek wynikający z tego, że nie jesteśmy gotowu na ruch
     */
    private void verifyMove(PossibleMove possibleMove) throws InvalidMoveException, NotReadyException {
        if(!getPossibleMoves().contains(possibleMove)){
            throw new InvalidMoveException();
        }
        if(moveQueue.size()>0||playerState.equals(PlayerState.FINISHED_TURN)){
            throw new NotReadyException();
        }
    }

    /**
     * Zwiększamy rundę o 1
     */
    public void incrementRound(){
        ++round;
    }

    /**
     * Obliczamy liczbę punktów
     * @return zwracamy liczbę punktów
     */
    public int calculatePoints(){
        int points=0;
        points+=boardBlue.getPoints();
        points+=boardGreen.getPoints();
        points+=boardOrange.getPoints();
        points+=boardYellow.getPoints();
        points+=boardPurple.getPoints();
        return points;
    }

    /**
     * Zwraca kość o danym kolorze jeżeli istnieje w tacy, zużyych lub nowych
     * @param diceColor kolor kości
     * @return znaleziona kość
     */
    public Dice getDice(DiceColor diceColor){
        for(Dice dice:diceRoll.getDices()){
            if(diceColor.equals(dice.getColor())){
                return dice;
            }
        }
        for(Dice dice:usedSlot.getDices()){
            if(diceColor.equals(dice.getColor())){
                return dice;
            }
        }
        for(Dice dice:tray.getDices()){
            if(diceColor.equals(dice.getColor())){
                return dice;
            }
        }
        return null;
    }
}