import java.util.Scanner;

public class question1CW {

public static void main(String[] args) {
    Scanner scannr = new Scanner(System.in);

    String input = scannr.nextLine().toUpperCase();

    for (int i = 0; i < input.length(); i++) {
        System.out.println(input.charAt(i));
    }
}

}