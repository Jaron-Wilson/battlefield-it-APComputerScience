import java.util.Calendar;
import java.util.Scanner;

public class HomeWork {
  public static void main(String[] args) {

  // int price = 12;
  // int cost = 10;
    //System.out.printf("The price for the calculation is: %d",price-cost);
    // System.out.printf("this is a test for each of the %s,%%", "Default %");




  //  Calendar c = Calendar.getInstance();
  // //  c.add(Calendar.DATE, -10);
  //  System.out.printf("Today date is: %s/%s/%s\n\n%s\n\n", c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE), c.get(Calendar.YEAR), c.getTime());








  // Scanner key = new Scanner(System.in);


  // System.out.println("Please Imput A Farenhight Number");
  // int f = key.nextInt();
  // double c = (double) 5/9 * (f-32);
  // System.out.printf(" %d F  = %.3f C",f, c);


  Scanner scnr = new Scanner(System.in);
  // int grade = scnr.nextInt();
  // System.out.println(grade >60 ? "passed" : "failed");

  int age = scnr.nextInt();

  int num = age>6? 100:200;

  boolean dl = age>= 16? true:false;
  System.out.println(dl + " " + num);

  }
}