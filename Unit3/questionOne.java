import java.util.Scanner;

public class questionOne {

    public static void main(String[] args) {
        int numOne;

        Scanner scnr = new Scanner(System.in);

        numOne = scnr.nextInt();
        

        // if(numOne % 2 == 0){
//             System.out.println("Even");
//         }else {
//             System.out.println("Odd");
//         }
         System.out.println(numOne % 2 ==0 ?"Even":"Odd");

    }
}