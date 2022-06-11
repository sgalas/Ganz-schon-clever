import java.io.IOException;

public class KlienTest {
    public static void main(String args[]) throws FailedToConnectException, IOException {
        GameClient kli = new GameClient("localhost", 5454, "jan");
        for(int round=0;round<4;round++ ) {
            for (int tour = 0; tour < 4; tour++) {
                int status = kli.checkStatus();
                if (status == 1) {
                    kli.activePlayerTurn();
                } else {
                    kli.passivePlayerTurn();
                }
            }
        }
    }
}


