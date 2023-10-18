package zybooks;

import java.util.Scanner;

public class ResultCalculator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int userNum;
      int result;
   
      result = 0;
      userNum = scnr.nextInt();
   
      /* Your code goes here */
      if (userNum < 0) {
        result = (userNum / -2);
      }else if(userNum % 5 == 0) {
        result = 1;
      }
      if(result == 0) {
        System.out.println("lose");
      }else if(result == 1) {
        System.out.println("win");
      }
      else   
      System.out.println("Result is " + result);
   }
}