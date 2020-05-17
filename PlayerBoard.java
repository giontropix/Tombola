import java.util.ArrayList;
import java.util.Collections;

public class PlayerBoard extends GenericBoard {

    public PlayerBoard(String name, int row, int column) {
        super(name, row, column);
        fillBoard(super.grid);
    }

    public ArrayList generateNumbers() {
        ArrayList<Integer> numbers = new ArrayList();
        for (int i = 1; i < 91; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public ArrayList shuffleNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list = generateNumbers();
        Collections.shuffle(list);
        return list;

    }

    public ArrayList take15CasualNumbers() {
        ArrayList fifteen = new ArrayList();
        ArrayList list;
        list = shuffleNumbers();
        for (int i = 0; i < 15; i++) {
            fifteen.add(list.get(i));
            list.remove(i);
        }
        Collections.sort(fifteen);
        return fifteen;
    }

    public void fillBoard(Object[][] test) {
        ArrayList list;
        list = take15CasualNumbers();
        int counter = 0;
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[i].length; j++) {
                super.setValue(i, j, list.get(counter));
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
