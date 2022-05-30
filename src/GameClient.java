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
