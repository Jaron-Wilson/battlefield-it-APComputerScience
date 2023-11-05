import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * Author: Jaron Wilson
 * Date: 11/3/23
 *
 * Programming Assigment 3 - TTT
 * Due 11/5/2021
 *
 * Program Description:
 * <images>
 * Honor Code: I Jaron Wilson Did not cheat on this Programing assignment, I have linked the resources used in this project, linked below!
 * LINKED RESOURCES: https://www.geeksforgeeks.org/minimax-algorithm-in-game-theory-set-1-introduction/#
 */
public class TTTSmith {
    public boolean isYourTurn = true;

    private final Scanner scanner;

    public static final String X = "X", O = "O";

    public TTTSmith()
    {
        this.scanner = new Scanner(System.in);
    }

    /**
     * The main method controls the game.
     * You will declare an array for the game and make use of the methods that you have written to produce behavior of the Tic-Tac-Toe game.
     */
    public static void main(String[] args) {

        TTTSmith ttt = new TTTSmith();  // Create an instance of the TTTSmith class

        String[][] grid = ttt.initBoard(3, 3);  // Initialize the game board

        ttt.gameBoard(grid);  // Display the initial game board

        /*
          do - loop
          I do this while (true)
          else STOP!
         */
        do {
            ttt.yourTurn(grid);
            if (ttt.checkWinner(grid)){
                ttt.gameBoard(grid);
                break;
            }
            ttt.machineEasyTurn(grid);
            ttt.gameBoard(grid);
        }while (!ttt.checkWinner(grid));

    }

    /**
     * This method handles moves made by the user.
     * It displays the game board and asks the user to enter a move.
     * If the move is invalid, it prompts the user to enter a valid move again.
     * A valid move refers to one of the empty cells in the board.
     * @param grid
     */
    public void yourTurn(String[][] grid) {
        System.out.println("Please enter the coordinates of your location (x):");
        String xY = scanner.nextLine();

        if (xY.contains(",")) {
            String[] parts = xY.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);

            if ((x < 3) && (y < 3)) {
                if (grid[x][y].equals(" ")) {
                    grid[x][y] = X;
                    isYourTurn = false;
                } else {
                    System.out.println("That spot is full!");
                    yourTurn(grid);
                }
            } else {
                System.out.println("That spot is OUT OF Bounds!");
                yourTurn(grid);
            }
        } else {
            System.out.println("Invalid input format");
            yourTurn(grid);
        }
    }

    /**
     * This method handles moves by the computer. You can implement a simple logic where you just search for an empty position
     * in the array and mark it for the computer player. You can get really creative and design the method so that it makes a well thought out move.
     * The logic is entirely up to you. Finally, you should display the computer's move.
     */
    public void machineTurn(String[][] grid) {
        int[] bestMove = new int[]{-1, -1};
        int bestScore = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(" ")) {
                    grid[i][j] = O;
                    int score = minimax(grid, 0, false);
                    grid[i][j] = " ";

                    if (score > bestScore) {
                        bestScore = score;
                        bestMove[0] = i;
                        bestMove[1] = j;
                    }
                }
            }
        }

        grid[bestMove[0]][bestMove[1]] = O;
        isYourTurn = true;
    }

    private int minimax(String[][] grid, int depth, boolean isMaximizing) {
        int result = evaluate(grid);

        if (result == 10) {
            return result;
        }

        if (result == -10) {
            return result;
        }

        if (!isMovesLeft(grid)) {
            return 0;
        }

        if (isMaximizing) {
            int best = Integer.MIN_VALUE;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j].equals(" ")) {
                        grid[i][j] = O;
                        best = Math.max(best, minimax(grid, depth + 1, !isMaximizing));
                        grid[i][j] = " ";
                    }
                }
            }

            return best;
        } else {
            int best = Integer.MAX_VALUE;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j].equals(" ")) {
                        grid[i][j] = X;
                        best = Math.min(best, minimax(grid, depth + 1, !isMaximizing));
                        grid[i][j] = " ";
                    }
                }
            }

            return best;
        }
    }

    private boolean isMovesLeft(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private int evaluate(String[][] grid) {
        // Check rows, columns, and diagonals for winning conditions
        for (int row = 0; row < 3; row++) {
            if (grid[row][0].equals(O) && grid[row][1].equals(O) && grid[row][2].equals(O)) {
                return 10;  // Computer wins
            }
            if (grid[row][0].equals(X) && grid[row][1].equals(X) && grid[row][2].equals(X)) {
                return -10;  // Human wins
            }
        }

        for (int col = 0; col < 3; col++) {
            if (grid[0][col].equals(O) && grid[1][col].equals(O) && grid[2][col].equals(O)) {
                return 10;  // Computer wins
            }
            if (grid[0][col].equals(X) && grid[1][col].equals(X) && grid[2][col].equals(X)) {
                return -10;  // Human wins
            }
        }

        if (grid[0][0].equals(O) && grid[1][1].equals(O) && grid[2][2].equals(O)) {
            return 10;  // Computer wins diagonally
        }
        if (grid[0][0].equals(X) && grid[1][1].equals(X) && grid[2][2].equals(X)) {
            return -10;  // Human wins diagonally
        }

        if (grid[0][2].equals(O) && grid[1][1].equals(O) && grid[2][0].equals(O)) {
            return 10;  // Computer wins diagonally
        }
        if (grid[0][2].equals(X) && grid[1][1].equals(X) && grid[2][0].equals(X)) {
            return -10;  // Human wins diagonally
        }

        return 0;  // No winner yet
    }

    public void machineEasyTurn(String[][] grid) {
        // Randomly select an empty position
        Random random = new Random();
        int row;
        int col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!grid[row][col].equals(" "));

        // Mark the selected position with the computer's symbol
        grid[row][col] = O;
        isYourTurn = true;
    }

    /**
     * This method examines the array to see if either player has won. A player has won if they have marked a row, column, or diagonal with their symbol.
     * The function returns different values based on results of a winner, loser, or no winner.
     */
    public boolean checkWinner(String[][] grid) {
        // Check rows
        for (String[] row : grid) {
            if (checkRow(row)) {
                System.out.println(!isYourTurn ? "You won!" : "You lost!");
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < grid[0].length; col++) {
            String[] column = new String[grid.length];
            for (int row = 0; row < grid.length; row++) {
                column[row] = grid[row][col];
            }

            if (checkRow(column)) {
                System.out.println(!isYourTurn ? "You won!" : "You lost!");
                return true;
            }
        }

        // Check diagonals
        String[] diagonal1 = new String[grid.length];
        String[] diagonal2 = new String[grid.length];

        for (int i = 0; i < grid.length; i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][grid.length - 1 - i];
        }

        if (checkRow(diagonal1) || checkRow(diagonal2)) {
            System.out.println(!isYourTurn ? "You won!" : "You lost!");
            return true;
        }

        return false; // No winner found
    }

    private static boolean checkRow(String[] row) {
        String symbol = row[0];
        if (" ".equals(symbol)) {
            return false;
        }
        for (String cell : row) {
            if (!cell.equals(symbol)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This method prints the game board.
     * @param grid
     */
    private void gameBoard(String[][] grid) {
        for (String[] strings : grid) {
            for (String string : strings) {
                System.out.print("|" + string);
            }
            System.out.println("|");
        }
    }

    /**
     * This function initializes the game board. There are 9 cells represented by a 1 or 2-dimensional array.
     * @param width
     * @param height
     * @return grid
     */
    public String[][] initBoard(int width, int height) {
        System.out.println("Let's begin!");
        String[][] grid = new String[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = " ";
            }
        }
        return grid;
    }
}
