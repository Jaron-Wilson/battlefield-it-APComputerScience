import java.util.Scanner;

public class questionThree {

    public static void main(String[] args) {


	    Scanner input = new Scanner(System.in);
	    System.out.println("enter 3 sides: ");
//  	    int numOne = input.nextInt();
// 	    int numTwo = input.nextInt();
// 	    int numThree = input.nextInt();
// 
//         if(numOne+numTwo>numThree && numOne+numThree > numTwo && numTwo+numThree>numOne){
// 	       System.out.printf("%d, %d, %d: can form a triangle.", numOne, numTwo, numThree);
//         }else {
//  	       System.out.println("They can't form a right triangle");
//         }

        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        
        //a2+b2=c2 
        if ((a * a + b * b == c * c) || (a * a + c * c == b * b) || (b * b + c * c == a * a)) {
            System.out.println("They can form a right triangle.");
        } else {
            System.out.println("They can't form a right triangle.");
        }


    }
}