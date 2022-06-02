import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.net.*;
public class GameClient extends Game {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private DiceRoll rzut;
    private Player currentPlayer;
    private void getID(){
    }
    public void connect(){
        try {
            clientSocket = new Socket("127.0.0.1", 5454);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        catch(IOException e)
        {
            System.out.println("Nie można się połączyć!");
            System.exit(1);
        }
    }
    @Override
    protected void activePlayerTurn(Player player) throws IOException {
        String odpowiedz;
        List<Dice> kosci=new ArrayList<>();
        while((odpowiedz=in.readLine())!=null) {
            String buffor[]=odpowiedz.split(",");
            kosci.add(new Dice( Color.values()[ Integer.valueOf(buffor[0]) ], Integer.valueOf(buffor[1]) ));
        }
        rzut=new DiceRoll(kosci);
        //get tray and used from gui
        Tray tray=new Tray();
        UsedSlot used =new UsedSlot();
        for(Dice tr:tray.getDices())
        {
            out.write(Integer.toString( tr.getColor().ordinal() )+","+Integer.toString(tr.getValue()) );
        }
        for(Dice us:used.getDices())
        {
            out.write("Z,"+Integer.toString( us.getColor().ordinal() )+","+Integer.toString(us.getValue()) );
        }

    }

    @Override
    protected void passivePlayerTurn(Player player) {

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
