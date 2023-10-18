import java.util.Scanner;

public class questionOneB {
    public static void main(String[] args) {
        int limit = 12000;
        int largestN = 0;

        for (int n = 1; n < limit; n++) {
            if (Math.pow(n, 3) < limit) {
                largestN = n;
            } else {
                break; // Exit the loop when the condition is no longer met
            }
        }

        System.out.println("The largest integer n such that n^3 is less than 12,000 is: " + largestN);
    }
}



