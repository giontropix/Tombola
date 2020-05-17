import java.util.ArrayList;
import java.util.Collections;

public class GenericBoard {
    private CasualNumbersFolder casualNumbers = new CasualNumbersFolder();
    ArrayList<Integer> list = new ArrayList();
    public Object[][] grid;
    String name;
    public enum Mark {X, O};
    private Mark mark;

    public GenericBoard(String name, final int row, final int column) {
        this.name = name;
        this.grid = new Object[row][column];
    }

    public void setValue(final int x, final int y, final Object value) {
        try {
            this.grid[x][y] = value;
        } catch (final Exception ex) {
            System.out.println(ex);
        }
    }

    public Object getValue(final int x, final int y) {
        try {
            return this.grid[x][y];
        } catch (final Exception ex) {
            System.out.println(ex);
            return null;
        }
    }

    public ArrayList matchGrid(int extractedNumber) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(extractedNumber == (int)grid[i][j]) {
                    this.list.add(extractedNumber);
                    setValue(i, j, 0);
                }
            }
        }
        return list;
    }

    public boolean checkAmbo() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length - 1; j++) {
                if (getValue(i, j) == getValue(i, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkTerna() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length - 2; j++) {
                if (getValue(i, j) == getValue(i, j + 1) && getValue(i, j + 1) == getValue(i, j + 2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkQuaterna() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length - 3; j++) {
                if (getValue(i, j) == getValue(i, j + 1) && getValue(i, j + 1) == getValue(i, j + 2)
                    && getValue(i, j + 2) == getValue(i, j + 3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCinquina() {
        for (int i = 0; i < grid.length; i++) {
            if( (getValue(i, 0).equals(getValue(i, 1))) && (getValue(i, 1).equals(getValue(i, 2)))
                    && (getValue(i, 2).equals(getValue(i, 3))) && (getValue(i, 3).equals(getValue(i, 4))))
                return true;
        }
        return false;
    }

    public boolean checkTombola() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (!getValue(i, j).equals(0))
                    return false;
            }
        }
        return true;
    }

    public void checkWin() {
        boolean ambo = false;
        boolean terna = false;
        boolean quaterna = false;
        boolean cinquina = false;
        if(ambo == false && checkAmbo()) {
            System.out.println("Il giocatore " + name + " ha fatto AMBO!!!\n");
            ambo = true;
        }
        if(terna == false && checkTerna()) {
            System.out.println("Il giocatore " + name + " ha fatto TERNA!!!\n");
            terna = true;
        }
        if(quaterna == false && checkQuaterna()) {
            System.out.println("Il giocatore " + name + " ha fatto TERNA!!!\n");
            quaterna = true;
        }
        if(cinquina == false && checkCinquina()) {
            System.out.println("Il giocatore " + name + " ha fatto CINQUINA!!!\n");
            cinquina = true;
        }
        if(checkTombola())
            System.out.println("Il giocatore " + name + " ha fatto TOMBOLA!!!\n");
    }

    public String toString() {
        String result = "";
        for (int x = 0; x < this.grid.length; x++) {
            result += "[";
            for(int y = 0; y < this.grid[x].length; y++) {
                final String space = (int)getValue(x, y) < 10 ? " " : "";
                result += "[" + space + getValue(x, y) + "]";
            }
            result += "]\n";
        }
        return result;
    }
}
