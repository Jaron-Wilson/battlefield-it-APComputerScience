import java.util.ArrayList;
import java.util.Formatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/************************************************************
 *
 * Programming Assignment: Degrees of Kevin Bacon
 *
 * FILENAME: DOFJaron.java
 *
 *
 * Author: Just Jaron Today
 *
 * Description: Search for a person in the file and if they match make the counter +1
 *
 * Honor Code: Its jaron, and I have not used other people or sources in help with this project.
 *
 * *********************************************************/


public class DOFJaron{
   private static ArrayList<String> actors = new ArrayList<>();
   private static ArrayList<String> movieTitles = new ArrayList<>();
   private static ArrayList<Integer> movieYear = new ArrayList<>();
   private static Scanner scanner = new Scanner(System.in);
   private static Scanner inputList;




    public static int DOFJaron(){  // version B
    // Bacon Score
    return 0;
    }

public static void main(String[] args) throws Exception{
    inputList = new Scanner(new File("src/list.txt"));
    

    System.out.println("Select Options (Enter Q to Quit):\n1. Bacon Degrees of Freedom\n2. Add Entry\n3. Delete Entry");
    //while (inputList.hasNextLine()) {/**Print the line to the console*/System.out.println(inputList.nextLine());}
    if (scanner.nextLine().equalsIgnoreCase("q")) {
        System.out.println("YESSS");
    }else if (scanner.nextInt() <= 3) {
        System.out.println("YERRR");
    }else {
        System.out.println("Select a correct option");
    }


    scanner.close();
    inputList.close();
}

}