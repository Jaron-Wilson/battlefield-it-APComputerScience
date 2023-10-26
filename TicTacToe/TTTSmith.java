package Projects.TicTacToe;

import java.util.Scanner;
import java.util.regex.Pattern;

public class TTTSmith {
    public static boolean isYourTurn = true;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grid[][] = new String[3][3];
        
        initBoard(grid, scanner);
        
    }

    public static void yourTurn(String grid[][], Scanner scanner) {
        String xY = scanner.nextLine();
        if (xY.contains(",")) {
            // Split it.
            String[] parts = xY.split(Pattern.quote(","));
            System.out.println(parts[0]);
            String xCord = parts[0];
            if(xCord == "1") {
                gameBoard(grid, 1,0);

            }
        }else {
            System.out.println("Please Give me a cordanate like: 1,2");
        }
    }



    private static void gameBoard(String[][] grid, int i, int j) {
        grid[i][j] = "x";
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                System.out.print("|" + grid[i][j]);
                
        }
        System.out.println("|");
    }

    public static void initBoard(String grid[][], Scanner scanner) {
        System.out.println("Let's begin!");
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                System.out.print("|" + grid[i][j]);
                
        }
        System.out.println("|");
    }
    if(getIsYourTurn()) {
    System.out.println("Please enter coordinate of your location (x):");
        yourTurn(grid, scanner);
    }
    }


    public static boolean getIsYourTurn() {
        return isYourTurn;
    }
}
