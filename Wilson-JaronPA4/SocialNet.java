



/*
* Author: Jaron Wilson 
* Date: 11/14/23
*
* Programming Assigment PA4
* Due 11/27/23
*
* Program Description:
*
* Honor Code: I did not use any outside help without permission from you.
*
*/
import java.util.*;

public class SocialNet {
    private static Scanner scnr = new Scanner(System.in);
    private static int numFriends;
    private static String[] names;

    public static void main(String args[]) {
        System.out.println("What is the total number of friends in the network:");

        while (!scnr.hasNextInt()) {
            System.out.println(scnr.next() + "is an incorrect input! Please enter an integer.");
        }

        numFriends = scnr.nextInt();

        while (numFriends < 1) {
            System.out.println("You need to have at least one friend in the network. Please enter again:");
            while (!scnr.hasNextInt()) {
                System.out.println(scnr.next() + " is an incorrect input! Please enter an integer:");
            }
            numFriends = scnr.nextInt();
        }

        String[][] netArr = new String[numFriends][numFriends];
        names = new String[numFriends];

        for (int i = 0; i < numFriends; ++i) {
            System.out.println("Enter name:");
            names[i] = scnr.next();
        }

        for (int i = 0; i < numFriends; ++i) {
            for (int j = 0; j < numFriends; ++j) {
                if (i != j) {
                    int lexDifference = Math.abs(names[i].compareTo(names[j]));
                    netArr[i][j] = (lexDifference <= 12) ? "1" : "0";
                } else {
                    netArr[i][j] = "0";
                }
            }
        }

        System.out.print("\t");
        for (String name : names) {
            System.out.print(name + "  ");
        }
        System.out.println();

        for (int i = 0; i < numFriends; ++i) {
            System.out.print(names[i] + "\t");
            for (int j = 0; j < numFriends; ++j) {
                System.out.print(netArr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Total Friends Count:");
        for (int i = 0; i < numFriends; ++i) {
            int totalFriends = 0;
            for (int j = 0; j < numFriends; ++j) {
                totalFriends += Integer.parseInt(netArr[i][j]);
            }
            System.out.println(names[i] + "\t" + totalFriends);
        }
    }
}