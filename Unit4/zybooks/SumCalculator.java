package zybooks;
import java.util.Scanner;

public class SumCalculator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int valueIn;

		valueIn = scnr.nextInt();

      /* Your code goes here */
      while(valueIn <= 25) {
         if(valueIn >= 25) break;
         valueIn = valueIn + 5;
         System.out.println(valueIn);
      }
   }
}