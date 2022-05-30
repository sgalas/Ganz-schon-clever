import java.util.ArrayList;

public abstract class Game {
    private ArrayList<Player> playerList;
    private int activePlayer;
    private int turn;
    public void nextTurn(){
        activePlayerTurn(playerList.get(activePlayer));
        for (int i=0;i<playerList.size();i++){
            if(i!=activePlayer){
                passivePlayerTurn(playerList.get(i));
            }
        }
        ++turn;
        activePlayer=(activePlayer+1)%(playerList.size()-1);
    }
    protected abstract void activePlayerTurn(Player player);
    protected abstract void passivePlayerTurn(Player player);

    private void doMove(PossibleMove possibleMove) throws ImpossibleFill {
        Board activeBoard = possibleMove.getBoard();
        activeBoard.fillTile(possibleMove.getDice(), possibleMove.getIndex());
    }

}
