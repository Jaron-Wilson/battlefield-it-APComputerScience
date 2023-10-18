import java.util.Scanner;

public class questionOne {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
       
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        System.out.println("Enter positive numbers (enter a negative number to stop):");

        int input = scnr.nextInt();

        while (input >= 0) {
            if (input < min) {
                min = input;
            }
            if (input > max) {
                max = input;
            }

            sum += input;
            count++;

            input = scnr.nextInt();
        }

        if (count > 0) {
            double average = (double) sum / count;
            int range = max - min;

            System.out.println("Average: " + average);
            System.out.println("Range: " + range);
        } else {
            System.out.println("No positive numbers entered.");
        }
    }
}