import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {
        
        System.out.print("Enter a number: ");
        calc();
    }
    
    public static void calc() {
        Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
        
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
        }
}