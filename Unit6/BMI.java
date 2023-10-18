import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);

        // Get the number of people for which you want to calculate BMI
        System.out.print("Enter the number of people: ");
        int num = key.nextInt();

        // Declare int arrays for height, weight, and BMI
        int[] height = new int[num];
        int[] weight = new int[num];
        double[] bmi = new double[num];

        // Input height and weight values
        for (int i = 0; i < num; i++) {
            System.out.print("Enter height (in cm) for person " + (i + 1) + ": ");
            height[i] = key.nextInt();
            System.out.print("Enter weight (in kg) for person " + (i + 1) + ": ");
            weight[i] = key.nextInt();
        }

        // Calculate BMI values
        for (int i = 0; i < num; i++) {
            double heightInMeters = height[i] / 100.0; // Convert height to meters
            double bmiValue = weight[i] / (heightInMeters * heightInMeters);
            bmi[i] = bmiValue;
        }

        // Print BMI values using the printArray method
        printArray(bmi);
    }

    // Method to print an array using an enhanced for loop
    public static void printArray(double[] arr) {
        System.out.print("BMI values: ");
        for (double value : arr) {
            System.out.print(value + " ");
        }
    }
}