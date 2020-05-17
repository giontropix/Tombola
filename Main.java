import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BingoBoard board = new BingoBoard("Tabellone", 9, 10);
        PlayerBoard player = new PlayerBoard("Cartella 1", 3, 5);
        CasualNumbersFolder casual = new CasualNumbersFolder();
        ArrayList listOfNumbers = new ArrayList();
        ArrayList playerNumber;
        int extractedNumber = 0;
        boolean ambo = false;
        boolean terna = false;
        boolean quaterna = false;
        boolean cinquina = false;
        System.out.println("\nBenvenuto nel gioco della tombola!!!\n");
        do {
            System.out.println(board.name);
            System.out.println(board.toString());
            System.out.println(player.name);
            System.out.println(player.toString());

            System.out.println("Premi s per estrarre un numero");
            Scanner scan = new Scanner(System.in);
            String answer = scan.nextLine();
            if (answer.equalsIgnoreCase("s"))
                extractedNumber = casual.extractNumbers();
                listOfNumbers.add(extractedNumber);
                if(casual.leftedNumbers() == 0) {
                    System.out.println("Numeri finiti");
                    return;
                }
            System.out.println("_______________________________________________________________________");

            playerNumber = player.matchGrid(extractedNumber);
            board.matchGrid(extractedNumber);
            player.matchGrid(extractedNumber);
            Collections.sort(playerNumber);
            System.out.println("\nNumero estratto: " + extractedNumber);
            System.out.println("Elenco numeri estratti" + listOfNumbers + "\nNumeri rimanenti: " + casual.leftedNumbers());
            System.out.println("Sono usciti " + playerNumber.size() + " sulla tua cartella: " + playerNumber + "\n");
            player.checkWin();
        }while(!player.checkTombola());
    }
}
