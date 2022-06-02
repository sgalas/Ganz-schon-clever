import java.util.ArrayList;

public abstract class Game {
    private ArrayList<Player> playerList;
    private int activePlayer;
    private int turn;
    public Game(){

    }
    public void nextTurn(){
        activePlayerTurn(playerList.get(activePlayer));
        for (int i=0;i<playerList.size();i++){
            if(i!=activePlayer){
                passivePlayerTurn(playerList.get(i));
            }
        }
        giveBonuses();
        ++turn;
        activePlayer=(activePlayer+1)%(playerList.size()-1);
    }
    private void giveBonuses(){
        for (Player player:playerList){
            switch (turn){
                case 1:
                case 3:
                    player.addReroll();
                    break;
                case 2:
                    player.addAdditionalDice();
                    break;
                case 4:
                case 5:
                case 6:
                default:
                    break;
            }
        }

    }
    protected abstract void activePlayerTurn(Player player);
    protected abstract void passivePlayerTurn(Player player);

}
