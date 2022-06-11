import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.net.*;
import java.util.Random;

public class GameClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private final Player currentPlayer;
    private final ClientGUI clientGUI;
    public GameClient(String hostname,int port,String nick) throws FailedToConnectException {
        connect(hostname,port);
        //add logic to either start new game or retrieve game state from server
        currentPlayer=Player.createNewPlayer(retrieveID(),nick);
        clientGUI=new ClientGUI(currentPlayer);
        try {
            oos=new ObjectOutputStream(clientSocket.getOutputStream());
            ois=new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    public int checkStatus() throws IOException {
        String odpowiedz=in.readLine();
        if(odpowiedz.contains("A")) {
            return 1;
        }
        else
            return 0;

    }
    private int retrieveID(){//retrieve id from server
        return 0;
    }

    protected void activePlayerTurn() throws IOException {
        String odpowiedz;
        List<Dice> kosci = new ArrayList<>();
        /*while((odpowiedz=in.readLine())!=null) {
            System.out.println(odpowiedz);
            String buffor[]=odpowiedz.split(",");
            kosci.add(new Dice( Color.values()[ Integer.valueOf(buffor[0]) ], Integer.valueOf(buffor[1]) ));
        }*/
        try {
            DiceRoll rol = (DiceRoll) ois.readObject();
            System.out.println("chociaz");
            currentPlayer.setDiceRoll(rol);
            System.out.println(currentPlayer.getDiceRoll());

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //TUTAJ MOJE LOSOWANIE TRZEBA ZASTAPIC ZWROCONYMI KOSCMI Z GUI
        UsedSlot used = new UsedSlot();
        Tray tray = new Tray();
        StringBuilder builder = new StringBuilder();
        boolean hasmoves=currentPlayer.getPossibleMovesForDices(getDiceRoll().getDices()).size()>0;
        for(int i=0;i<3||hasmoves;i++){
            boolean moveIsFine;
            do{
                try {
                    setPlayerState(PlayerState.ACTIVE_TURN);
                    updateGUI();
                    waitOnGUI();
                    PossibleMove selectedMove=getMove();
                    TileSpecialAction tileSpecialAction = performMove(selectedMove);
                    doSpecialAction(tileSpecialAction);
                    getDiceRoll().rollDices();//replace with getting data from server
                    moveIsFine=true;
                    hasmoves=currentPlayer.getPossibleMovesForDices(getDiceRoll().getDices()).size()>0;
                } catch (ImpossibleFillException e) {
                    e.printStackTrace();//replace with showing error in gui
                    moveIsFine=false;
                }
            } while (!moveIsFine);//repeat until valid move
        }

       /* for(Dice tr:tray.getDices())
        {
            builder.append(Integer.toString( tr.getColor().ordinal() )+","+Integer.toString(tr.getValue()) );
            System.out.print(builder.toString());
        }*/
        oos.writeObject(getTray());
        System.out.println(tray);
        oos.writeObject(getUsed());
        System.out.println(used);
    }

    protected void passivePlayerTurn() {
        //somehow get Tray and UsedSlot from server
        try {
            Tray trayrecv = (Tray)ois.readObject() ;
            UsedSlot usedSlotrecv=(UsedSlot)ois.readObject();
            //Tray i used Slot dla gui
            currentPlayer.setTray(trayrecv);
            currentPlayer.setUsedSlot(usedSlotrecv);
            out.write("dupa");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean moveIsFine;
        do{
            try {
                setPlayerState(PlayerState.PASSIVE_TURN);
                updateGUI();
                waitOnGUI();
                PossibleMove selectedMove=getMove();
                TileSpecialAction tileSpecialAction = performMove(selectedMove);
                doSpecialAction(tileSpecialAction);
                getDiceRoll().rollDices();//replace with getting data from server
                moveIsFine=true;

            } catch (ImpossibleFillException e) {
                e.printStackTrace();//replace with showing error in gui
                moveIsFine=false;
            }
        } while (!moveIsFine);//repeat until valid move
        //add sending it to server
    }


    private DiceRoll getDiceRoll(){
        return currentPlayer.getDiceRoll();
    }

    private Tray getTray(){
        return currentPlayer.getTray();
    }
    private UsedSlot getUsed(){
        return currentPlayer.getUsedSlot();
    }
    private void updateGUI(){
        clientGUI.updateAll();
    }
    private void setPlayerState(PlayerState playerState){
        currentPlayer.setPlayerState(playerState);
    }
    private void waitOnGUI() {
        try {
            do {
                Thread.sleep(100);
            } while (currentPlayer.getPlayerState()!=PlayerState.FINISHED_TURN);
        } catch (InterruptedException e) {

        }
    }
    private PossibleMove getMove() {
        PossibleMove possibleMove=currentPlayer.getMoveQueue().poll();
        return possibleMove;
    }
    private void doSpecialAction(TileSpecialAction tileSpecialAction) throws ImpossibleFillException {
        PossibleMove possibleMove;
        TileSpecialAction nextTileSpecialAction;
        if(tileSpecialAction==null){
            return;
        }
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
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(DiceColor.ORANGE,4))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDORANGE5:
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(DiceColor.ORANGE,5))).get(0);
                nextTileSpecialAction =possibleMove.doMove();
                updateGUI();
                doSpecialAction(nextTileSpecialAction);
                break;
            case ADDORANGE6:
                possibleMove= currentPlayer.getBoardOrange().possibleMovesWithDice(new DiceCombination(new Dice(DiceColor.ORANGE,6))).get(0);
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
                possibleMove= currentPlayer.getBoardPurple().possibleMovesWithDice(new DiceCombination(new Dice(DiceColor.PURPLE,6))).get(0);
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
    private TileSpecialAction performMove(PossibleMove possibleMove) throws ImpossibleFillException {
        DiceCombination dice=possibleMove.getDiceCombination();
        TileSpecialAction tileSpecialAction= possibleMove.doMove();
        getDiceRoll().removeDice(dice.getPrimaryDice());
        getUsed().putDice(dice.getPrimaryDice());
        List<Dice> newDiceRoll= new LinkedList<>( getDiceRoll().getDices());
        for(Dice dice1: newDiceRoll){
            if(dice1.getValue()<dice.getPrimaryDice().getValue()){
                getTray().putDice(dice1);
                getDiceRoll().removeDice(dice1);
            }
        }

        return tileSpecialAction;
    }
    private void nextRound() throws IOException {
        boolean isActivePlayer=true;//get from server
        if(isActivePlayer){
            activePlayerTurn();
        } else {
            passivePlayerTurn();
        }
        giveBonuses();
        currentPlayer.incrementRound();
    }
    private void giveBonuses(){
        switch (currentPlayer.getRound()){
            case 1:
            case 3:
                currentPlayer.addReroll();
                break;
            case 2:
                currentPlayer.addAdditionalDice();
                break;
            case 4:
            case 5:
            case 6:
            default:
                break;
        }
    }
    public void run(){

    }
}
