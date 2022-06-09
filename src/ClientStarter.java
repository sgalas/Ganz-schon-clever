import java.util.Scanner;

public class ClientStarter {

    public static void main(String[] args) {

        try(Scanner scanner=new Scanner(System.in)) {
            boolean startGame=true;
            while (startGame){
                System.out.println("Enter hostname:");
                String hostname=scanner.nextLine();
                String input;
                do {
                    System.out.println("Enter port:");
                }while(!scanner.hasNextInt()||(input = scanner.nextLine()).equals(""));
                int port=Integer.parseInt(input);
                System.out.println("Enter nick:");
                String nick=scanner.nextLine();
                GameClient gameClient=new GameClient(hostname,port,nick);
                System.out.println("Stop game?:");
                boolean correctOption=false;
                while(!correctOption) {
                    System.out.println("Quit game? Y/N:");
                    input = scanner.nextLine();
                    if(input.charAt(0)=='Y'||input.charAt(0)=='y'){
                        correctOption=true;
                        startGame=false;
                    } else if(input.charAt(0)=='N'||input.charAt(0)=='n'){
                        correctOption=true;
                        startGame=true;
                    }
                }

            }

        } catch (FailedToConnectException e) {
            e.printStackTrace();
        }

    }
}
