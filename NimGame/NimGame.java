import java.util.Random;
import java.util.Scanner;
/*
* Author: Jaron Wilson
* Date: 10-12-23
*
* Programming Assigment 3- Nim
* Due 
*
* Program Description:
*
* Honor Code:I Jaron Wilson Did not recieve any help from other people.
*
*/

public class NimGame {
    private int pileSize;
    private boolean computerFirst;
    private boolean smartMode;
    private boolean isComputerTurn;

    public NimGame() {
        initializeGame();
    }

    public void initializeGame() {
        // Initialize game parameters randomly
        Random rand = new Random();
        pileSize = rand.nextInt(91) + 10; // Generate random pile size between 10 and 100
        computerFirst = rand.nextBoolean(); // Determine if computer or human goes first
        smartMode = rand.nextBoolean(); // Determine if computer plays in smart mode
        isComputerTurn = computerFirst;
    }

    public int smartMoveMarbleNum(int num) {
        // Calculate computer's move in smart mode
        if (num == 15 || num == 31 || num == 63) {
            Random rand = new Random();
            return rand.nextInt(num / 2) + 1; // Random move between 1 and num/2
        } else {
            return findNextPowerOfTwoMinusOne(num);
        }
    }

    private int findNextPowerOfTwoMinusOne(int num) {
        // Find the next power of two minus one
        int powerOfTwo = 1;
        while (powerOfTwo - 1 < num) {
            powerOfTwo *= 2;
        }
        return (powerOfTwo - 1) > num ? num - (powerOfTwo / 2 - 1) : powerOfTwo / 2 - 1;
    }

    public int stupidMoveMarbleNum(int num) {
        // Calculate computer's move in stupid mode
        Random rand = new Random();
        return rand.nextInt(num / 2) + 1; // Random move between 1 and num/2
    }

    public boolean isComputerTurn() {
        return isComputerTurn;
    }

    public boolean isSmart() {
        return smartMode;
    }

    public static void main(String[] args) {
        NimGame game = new NimGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Nim Game!");
        System.out.println("You have " + game.pileSize + " elements to start");
        System.out.println("Coin toss result for computer mode: " + (game.isSmart() ? "smart mode" : "stupid mode"));

        while (game.pileSize > 1) {
            if (game.isComputerTurn()) {
                int move = game.isSmart() ? game.smartMoveMarbleNum(game.pileSize) : game.stupidMoveMarbleNum(game.pileSize);
                System.out.println("It's computer's turn");
                System.out.println("Computer takes " + move);
                game.pileSize -= move;
                System.out.println("Now there are " + game.pileSize + " left.");
            } else {
                int playerMove;
                do {
                    System.out.print("What's your move? ");
                    playerMove = scanner.nextInt();
                    if (playerMove < 1 || playerMove > game.pileSize / 2) {
                        System.out.println("Invalid move. You can only take between 1 and " + game.pileSize / 2 + " marbles.");
                    }
                } while (playerMove < 1 || playerMove > game.pileSize / 2);
                game.pileSize -= playerMove;
                System.out.println("Now there are " + game.pileSize + " left.");
            }
            
            game.isComputerTurn = !game.isComputerTurn(); // Switch turns
        }

        announceWinner(!game.isComputerTurn());
    }

    private static void announceWinner(boolean computerTurn) {
        if (computerTurn) {
            System.out.println("Computer won!");
        } else {
            System.out.println("You won!");
        }
    }
}
