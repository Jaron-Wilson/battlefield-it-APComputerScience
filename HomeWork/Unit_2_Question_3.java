import java.util.Scanner;

public class Unit_2_Question_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        System.out.print("Enter five digit integer: ");
        int number = scanner.nextInt();
        System.out.printf("Digits in %d are ", number);
        
        
        
        
        
        
//         int first_digit = number / 10000;
//         int second_digit = (number % 10000) / 1000 ;
//         int third_digit = (number % 1000) / 100;
//         int fourth_digit = (number % 100) / 10;
//         int fifth_digit = (number % 10);
        // System.out.printf("%d   %d   %d   %d   %d", first_digit, second_digit, third_digit, fourth_digit, fifth_digit);    

        System.out.printf("%d   %d   %d   %d   %d",number / 10000, (number % 10000) / 1000, (number % 1000) / 100,(number % 100) / 10,(number % 10));
        
       





    }
}

