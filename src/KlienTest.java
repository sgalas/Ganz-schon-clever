import java.io.IOException;

public class KlienTest {
    public KlienTest(String hostname, int port, String nick) throws FailedToConnectException, IOException {
        GameClient kli = new GameClient(hostname, port, nick);
        for (int round = 0; round < 4; round++) {
            for (int tour = 0; tour < 4; tour++) {
                int status = kli.checkStatus();
                if (status == 1) {
                    kli.activePlayerTurn();
                } else {
                    kli.passivePlayerTurn();
                }
                kli.giveBonuses();
            }
        }
    }


    public static void main(String[] args) {
        try {
            KlienTest a = new KlienTest(args[0], Integer.parseInt(args[1]), args[2]);
        } catch (FailedToConnectException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



