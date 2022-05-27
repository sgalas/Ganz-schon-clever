import java.util.ArrayList;

public class Game {
    private ArrayList<Player> playerList;
    private int activePlayer;
    private int turn;
    public void update(){
    }
    private void activePlayerTurn(){

    }
    private void passivePlayerTurn(){

    }
    private void doMove(PossibleMove possibleMove) throws ImpossibleFill {
        Board activeBoard = possibleMove.getBoard();
        activeBoard.fillTile(possibleMove.getDice(), possibleMove.getIndex());
    }
}
