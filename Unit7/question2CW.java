import java.util.Scanner;

public class question2CW {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameAndYear = scanner.nextLine().toLowerCase().replace(",", "");

            String[] splitSpace = nameAndYear.split(" ");
        
            // for (int j = 0; j < splitSpace.length; j++) {
            //     System.out.println(splitSpace[j]);
            // }

            // Take subString(1)
                String fI = splitSpace[0].substring(0,1);
                System.out.print("ID: " + fI);
            // Take Sub(3)
                String lastIs = splitSpace[1].substring(0,3);
                System.out.print(lastIs);
            // last 2 of year 
            String lastYr = splitSpace[2].substring(2,4);
                System.out.print(lastYr);

            



    }
}
