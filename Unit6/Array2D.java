import java.util.Random;
public class Array2D {
    public static void main(String[] args) {
        int a = 4, b = 5; // Define the number of rows (a) and columns (b)
        int[][] arr = createArray(a, b);
        printArray(arr);
        largestRow(arr);
    }

    // Method 1: create a 2D array with randomly initialized integer numbers of 0-20
    public static int[][] createArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        Random rand = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = rand.nextInt(21); // Generates random numbers from 0 to 20
            }
        }
        return array;
    }

    // Method 2: print 2D array
    public static void printArray(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    // Method 3: find out which row has the largest sum and print out the row # and the largest sum
    public static void largestRow(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;
        int rowIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < arr[i].length; j++) {
                rowSum += arr[i][j];
            }
            if (rowSum > maxSum) {
                maxSum = rowSum;
                rowIndex = i;
            }
        }

        System.out.println("Row with the largest sum is row " + rowIndex + " with a sum of " + maxSum);
    }
}