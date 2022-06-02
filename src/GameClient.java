import java.util.List;

public class GameClient extends Game {
    private Player currentPlayer;
    private Tray tray=new Tray();
    private UsedSlot usedSlot=new UsedSlot();
    private void getID(){
    }
    public void connect(){
    }
    @Override
    protected void activePlayerTurn(Player player){
        if(currentPlayer!=player){

        }
    }

    @Override
    protected void passivePlayerTurn(Player player) {
        if(currentPlayer!=player){

        }
        //somehow get Tray and UsedSlot from server
        Tray trayrecv=new Tray();
        UsedSlot usedSlotrecv=new UsedSlot();
        tray=trayrecv;
        usedSlot=usedSlotrecv;
        List<PossibleMove> possibleMoves= currentPlayer.getPossibleMovesForDices(tray.getDices());
        if(possibleMoves.size()==0){
            possibleMoves=currentPlayer.getPossibleMovesForDices(usedSlot.getDices());
        }
        boolean moveIsFine=true;
        do{
            try {
                PossibleMove selectedMove=possibleMoves.get(0);//replace with gui chosing moves here
                selectedMove.doMove();
            } catch (ImpossibleFill e) {
                e.printStackTrace();//replace with showing error in gui
            }
        } while (!moveIsFine);
        //if fine add sending it to server
    }

    public void createGUI(){
        ClientGUI clientGUI = new ClientGUI(currentPlayer);
    }

    public DiceRoll getDiceRoll(){
        return null;
    }

    public Tray getTray(){
        return tray;
    }
    public UsedSlot getUsed(){
        return usedSlot;
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
}
