import java.util.Scanner;

public class questionTwo {

    public static void main(String[] args) {
        int numOne;
        int numTwo;

        Scanner scnr = new Scanner(System.in);



        System.out.print("Please enter two integers: \n");
                numOne = scnr.nextInt();
        numTwo = scnr.nextInt();

         if(numOne == numTwo) {
            System.out.print("These numbers are equal\n");
        } else if(numOne > numTwo) {
            System.out.printf("%d is larger\n", numOne);
        }else {
            System.out.printf("%d is larger\n", numTwo);
        }
    }
}