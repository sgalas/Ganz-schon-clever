import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.util.Random;

public class GameClient extends Game {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private Player currentPlayer;
    private ClientGUI clientGUI;
    public GameClient(String hostname,int port,String nick) throws FailedToConnectException {
        connect(hostname,port);
        currentPlayer=Player.createNewPlayer(retrieveID(),nick);
        clientGUI=new ClientGUI(currentPlayer);
    }
    private void getID(){
    }
    private void connect(String hostname,int port) throws FailedToConnectException {
        try {
            clientSocket = new Socket(hostname, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e)
        {
            System.out.println("Nie można się połączyć!");
            throw new FailedToConnectException();
        }
    }
    private int retrieveID(){//retrieve id from server
        return 0;
    }
    @Override
    protected void activePlayerTurn(Player player) throws IOException {
        String odpowiedz;
        List<Dice> kosci=new ArrayList<>();
        while((odpowiedz=in.readLine())!=null) {
            String buffor[]=odpowiedz.split(",");
            kosci.add(new Dice( Color.values()[ Integer.valueOf(buffor[0]) ], Integer.valueOf(buffor[1]) ));
        }
        currentPlayer.setDiceRoll(new DiceRoll(kosci));
        //get tray and used from gui
        Tray tray=new Tray();
        UsedSlot used =new UsedSlot();
        StringBuilder builder=new StringBuilder();
        for(Dice tr:tray.getDices())
        {
            builder.append(Integer.toString( tr.getColor().ordinal() )+","+Integer.toString(tr.getValue()) );
        }
        out.write(builder.toString());
        builder=new StringBuilder();
        for(Dice us:used.getDices())
        {
            builder.append("Z,"+Integer.toString( us.getColor().ordinal() )+","+Integer.toString(us.getValue()) );
        }
        out.write(builder.toString());
    }

    @Override
    protected void passivePlayerTurn(Player player) {

        //somehow get Tray and UsedSlot from server
        Tray trayrecv=new Tray();
        UsedSlot usedSlotrecv=new UsedSlot();
        currentPlayer.setTray(trayrecv);
        currentPlayer.setUsedSlot(usedSlotrecv);
        boolean moveIsFine;
        do{
            try {
                moveIsFine=true;
                setPlayerState(PlayerState.PLAYER_STATE);
                updateGUI();
                waitOnGUI();
                PossibleMove selectedMove=getMove();
                TileSpecialAction tileSpecialAction = performMove(selectedMove);
                doSpecialAction(tileSpecialAction);

            } catch (ImpossibleFill e) {
                e.printStackTrace();//replace with showing error in gui
                moveIsFine=false;
            }
        } while (!moveIsFine);//repeat until valid move
        //if fine add sending it to server
    }

    public void createGUI(){
        ClientGUI clientGUI = new ClientGUI(currentPlayer);
    }

    public DiceRoll getDiceRoll(){
        return null;
    }

    public Tray getTray(){
        return currentPlayer.getTray();
    }
    public UsedSlot getUsed(){
        return currentPlayer.getUsedSlot();
    }

    public int getFoxCount(){
        return currentPlayer.getFoxCount();
    }
    public int getAdditionalDiceCount(){
        return currentPlayer.getAdditionalDiceCount();
    }
    public int getRerollCount(){
        return currentPlayer.getRerollCount();
    }
    public void useAdditionalDice(){

    }
    public void useReroll(){

    }
    private void updateGUI(){
        clientGUI.updateAll();
    }
    private void setPlayerState(PlayerState playerState){
        currentPlayer.setPlayerState(playerState);
    }
    private void waitOnGUI(){
        while (currentPlayer.getPlayerState()!=PlayerState.FINISHED_TURN){

        }
    }
    private PossibleMove getMove() {
        PossibleMove possibleMove=currentPlayer.getMoveQueue().poll();
        return possibleMove;
    }
    public void doSpecialAction(TileSpecialAction tileSpecialAction) throws ImpossibleFill {
        PossibleMove possibleMove;
        TileSpecialAction nextTileSpecialAction;
        switch (tileSpecialAction){
            case ADDFOX:
                currentPlayer.addFox();
                updateGUI();
                break;
            case ADDADDITIONALDICE:
                currentPlayer.addAdditionalDice();
                updateGUI();
                break;
            case ADDROLL:
                currentPlayer.addReroll();
                updateGUI();
                break;
            case ADDORANGE4:
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(Color.ORANGE,4))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDORANGE5:
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(Color.ORANGE,5))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDORANGE6:
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(Color.ORANGE,6))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDRANDOMGREEN:
                List<PossibleMove> list= currentPlayer.getBoardGreen().possibleMoves();
                possibleMove =list.get(new Random().nextInt(0,list.size()));
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDPURPLE6:
                possibleMove= currentPlayer.getBoardPurple().possibleMovesWithDice(new DiceCombination(new Dice(Color.PURPLE,6))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDRANDOMBLUE:
                setPlayerState(PlayerState.SELECTBLUE);
                updateGUI();
                waitOnGUI();
                break;
            case ADDRANDOMYELLOW:
                setPlayerState(PlayerState.SELECTYELLOW);
                updateGUI();
                waitOnGUI();
                break;
        }
    }
    private TileSpecialAction performMove(PossibleMove possibleMove) throws ImpossibleFill {
        DiceCombination dice=possibleMove.getDiceCombination();
        TileSpecialAction tileSpecialAction= possibleMove.doMove();
        currentPlayer.getDiceRoll().removeDice(dice.getPrimaryDice());
        currentPlayer.getUsedSlot().putDice(dice.getPrimaryDice());
        for(Dice dice1: getDiceRoll().getDices()){
            if(dice1.getValue()<dice.getPrimaryDice().getValue()){
                currentPlayer.getTray().putDice(dice1);
                currentPlayer.getDiceRoll().removeDice(dice1);
            }
        }
        return tileSpecialAction;
    }
}
