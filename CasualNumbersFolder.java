import java.util.ArrayList;
import java.util.Collections;

public class CasualNumbersFolder {
    ArrayList casualNumbers = new ArrayList();
    int extractedNumber = 0;

    public CasualNumbersFolder() {
        fillNumbers();
    }

    public ArrayList fillNumbers() {
        for (int i = 1; i <90 ; i++) {
            this.casualNumbers.add(i);
        }
        Collections.shuffle(casualNumbers);
        return this.casualNumbers;
    }

    public int extractNumbers() {
        this.extractedNumber = (int)casualNumbers.remove(casualNumbers.size() - 1);
        return extractedNumber;
    }

    public int leftedNumbers() {
        return this.casualNumbers.size();
    }

    @Override
    public String toString() {
        return  "Numeri casuali = " + casualNumbers +
                "\nTot. numeri = " + casualNumbers.size();
    }
}
