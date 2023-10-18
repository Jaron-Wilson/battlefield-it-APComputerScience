import java.util.Scanner;

public class questionTwoB {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String numbers = scnr.nextLine();


        if (numbers.length() != 5) {
            System.out.println("Please give me a 5 digit number!");
            System.out.println("invalid input");
        }else {
            if (numbers.charAt(0)==numbers.charAt(4) && numbers.charAt(1)==numbers.charAt(3)) {
                System.out.println("It is a palindrome");
            }else{
            System.out.println("It is NOT a palindrome");	
            }
        }


    }
}