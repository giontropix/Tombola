public class BingoBoard extends GenericBoard {
    public BingoBoard(String name, int row, int column) {
        super(name, row, column);
        fillBigBoard(super.grid);
    }

    public Object[][] fillBigBoard(Object[][] grid) {
        int counter = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                super.setValue(i, j, counter);
                counter++;
            }
        }
        return grid;
    }
}
