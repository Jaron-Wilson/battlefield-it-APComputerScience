public class questionTwoB {
    public static void main(String[] args) {
        int rows = 12; // Adjust the number of rows as needed
        
        // First triangle
        System.out.println("First Triangle:");
        for (int row = 1; row <= rows; row++) {
            for (int asterisk = 1; asterisk <= row; asterisk++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }

        // Second triangle
        System.out.println("\nSecond Triangle:");
        for (int row = rows; row >= 1; row--) {
            for (int asterisk = 1; asterisk <= row; asterisk++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }

        // Third triangle
        System.out.println("\nThird Triangle:");
        for (int row = 1; row <= rows; row++) {
            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }
            for (int asterisk = 1; asterisk <= row; asterisk++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }

        // Fourth triangle
        System.out.println("\nFourth Triangle:");
        for (int row = rows; row >= 1; row--) {
            for (int space = 1; space <= rows - row; space++) {
                System.out.print(" ");
            }
            for (int asterisk = 1; asterisk <= row; asterisk++) {
                System.out.print("*");
            }
            System.out.println(); // Move to the next line
        }
    }
}



