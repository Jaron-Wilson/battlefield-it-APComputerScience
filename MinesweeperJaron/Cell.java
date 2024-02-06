public class Cell {



    
    public static void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < Minesweeper.getRows(); i++) {
            System.out.print(i + " ");
            for (int j = 0; j < Minesweeper.getCols(); j++) {
                System.out.print(Minesweeper.getVisible()[i][j] + " ");
            }
            System.out.println();
        }
    }
}