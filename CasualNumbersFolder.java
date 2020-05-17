import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class CasualNumbersFolder {
    ArrayList casualNumbers = new ArrayList();
    int extractedNumber = 0;

    public CasualNumbersFolder() {
        fillNumbers();
    }

    public void shuffleNumbers(ArrayList test) {
        Collections.shuffle(test);
    }

    public ArrayList fillNumbers() {
        for (int i = 1; i <90 ; i++) {
            this.casualNumbers.add(i);
        }
        shuffleNumbers(this.casualNumbers);
        return this.casualNumbers;
    }

    public int extractNumbers() {

        int i = ThreadLocalRandom.current().nextInt(0, this.casualNumbers.size());
        this.extractedNumber = (int)this.casualNumbers.get(i);
        this.casualNumbers.remove(i);
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
