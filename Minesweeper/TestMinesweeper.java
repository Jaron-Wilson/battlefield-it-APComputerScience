public class TestMinesweeper {
    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper(10, 10, 10);
        System.out.println(minesweeper.getNumMines() + " have been placed around randomly.");
        minesweeper.playGame();
    }
}
