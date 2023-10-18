import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        double result = 0;
        
        switch (operator) {
            case '+':
                 result = add(num1, num2);
                break;
            case '-':
                result = sub(num1, num2);
                break;
            case '*':
                result = mult(num1, num2);
                break;
            case '/':
                if (num2 != 0) {
                    result = devi(num1, num2);
                } else {
                    System.out.println("Error: Cannot divide by zero.");
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                return;
        }
        
        System.out.println("Result: " + result);
        
        }


   public static double add (int a, int b){
      return a+b;
   }

   public static double sub (int a, int b){
      return a-b;
   }

   public static double mult (int a, int b){
      return a*b;
   }
   public static double devi (int a, int b){
      return a/b;
   }

}
