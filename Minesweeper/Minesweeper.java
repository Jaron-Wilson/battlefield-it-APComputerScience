import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static int rows;
    private static int cols;
    private final int numMines;
    private char[][] board;
    private static char[][] visible;
    private boolean gameOver;

    public Minesweeper(int rows, int cols, int numMines) {
        Minesweeper.rows = rows;
        Minesweeper.cols = cols;
        this.numMines = numMines;
        this.board = new char[rows][cols];
        Minesweeper.visible = new char[rows][cols];
        this.gameOver = false;
        initializeBoard();
    }

    private void initializeBoard() {
        // Initialize the board with empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = ' ';
                visible[i][j] = '#';
            }
        }

        // Place mines randomly
        Random random = new Random();
        int minesPlaced = 0;
        while (minesPlaced < numMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            if (board[row][col] != 'M') {
                board[row][col] = 'M';
                minesPlaced++;
            }
        }
    }

    

    private void revealCell(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || visible[row][col] != '#') {
            return;
        }

        if (board[row][col] == 'M') {
            // Game over if mine is revealed
            gameOver = true;
            return;
        }

        // Count surrounding mines
        int count = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < rows && j >= 0 && j < cols && board[i][j] == 'M') {
                    count++;
                }
            }
        }

        visible[row][col] = (char) (count + '0');

        if (count == 0) {
            // If the cell is empty, recursively reveal adjacent cells
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    revealCell(i, j);
                }
            }
        }
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            Cell.printBoard();
            System.out.print("Enter row and column (e.g., 3 4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            revealCell(row, col);

            if (!gameOver) {
                checkWin();
            }
        }

        // Game over, reveal all mines
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'M') {
                    visible[i][j] = 'M';
                    gameOver = true;
                }
            }
        }

        
        if (gameOver) {
            Cell.printBoard();
            System.out.println("Game Over!");            
        }
        scanner.close();
    }

    private void checkWin() {
        // Check if all non-mine cells are revealed
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != 'M' && visible[i][j] == '#') {
                    gameOver = false;
                    return;
                }
            }
        }
        // All non-mine cells revealed, player wins
        gameOver = true;
        if (gameOver) {
            Cell.printBoard();
            System.out.println("Congratulations! You Win!");
            
        }
    }

    public int getNumMines() {
        return numMines;
    }

    public static int getRows(){
        return rows;
    }

    /**
     * @return the cols
     */
    public static int getCols() {
        return cols;
    }

    /**
     * @return the board
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * @return the visible
     */
    public static char[][] getVisible() {
        return visible;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    
    
    
}