import java.util.Scanner;
public class Largest1{
   public static void main(String[] args){
	Scanner input = new Scanner(System.in);
 
	System.out.println("enter 3 integers:  ");
	int a, b, c;
	int max =0;
	a = input.nextInt();
	b = input.nextInt();
	c = input.nextInt();
	
	max = Integer.MIN_VALUE;
 	if (a>max)
	   max = a;
	if(b > max)
	   max = b;
	if(c > max)
	   max = c;


	System.out.printf(" The largest is %d \n Sum of the three numbers is : %d\n The product is %d\n The Average is %d",max, a+b+c, a*b*c, (a+b+c) /3);
    }
}
	