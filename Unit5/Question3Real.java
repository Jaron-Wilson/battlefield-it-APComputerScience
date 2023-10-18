import java.util.Scanner;
import java.util.Random;

public class Question3Real {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.println("Your turn - select a number for your choice:");
        System.out.println("1 for Rock, 2 for Paper, 3 for Scissors.");
        int user = kb.nextInt();

        int computer = getRandomChoice(); // Get the computer's random choice

        // Determine the result of the game
        String result = determineResult(user, computer);

        System.out.println("Result: " + result);
    }

    // Method to generate a random choice for the computer (1 for Rock, 2 for Paper, 3 for Scissors)
    public static int getRandomChoice() {
        Random rand = new Random();
        return rand.nextInt(3) + 1; // Generates a random number between 1 and 3
    }

    // Method to determine the result of the game based on user and computer choices
    public static String determineResult(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        } else if ((userChoice == 1 && computerChoice == 3) || 
                   (userChoice == 2 && computerChoice == 1) || 
                   (userChoice == 3 && computerChoice == 2)) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

