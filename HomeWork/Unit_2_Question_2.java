import java.util.Scanner;

public class Unit_2_Question_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int numOne = scanner.nextInt();
        int numTwo = scanner.nextInt();
        int numThree = scanner.nextInt();

        double av = (double) (numOne+numTwo+numThree)/3;


        System.out.printf("sum=%d, product=%d, average=%.2f.", numOne+numTwo+numThree, numOne*numTwo*numThree, av);




    }
}
