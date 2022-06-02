import java.util.List;

public class GameClient extends Game {
    private Player currentPlayer;
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
        currentPlayer.setTray(trayrecv);
        currentPlayer.setUsedSlot(usedSlotrecv);
        List<PossibleMove> possibleMoves= currentPlayer.getPossibleMovesForDices(getTray().getDices());
        if(possibleMoves.size()==0){
            possibleMoves=currentPlayer.getPossibleMovesForDices(getUsed().getDices());
        }
        boolean moveIsFine;
        do{
            try {
                moveIsFine=true;
                PossibleMove selectedMove=possibleMoves.get(0);//replace with gui chosing moves here
                selectedMove.doMove();
            } catch (ImpossibleFill e) {
                e.printStackTrace();//replace with showing error in gui
                moveIsFine=false;
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
}
