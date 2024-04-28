import java.io.*;
import java.util.*;

public class DOFSmith {

    private static final String FILENAME = "list.txt";
    private static final List<String> actors = new ArrayList<>();
    private static final List<String> movies = new ArrayList<>();
    private static final List<String> years = new ArrayList<>();

    public static void main(String[] args) {
        loadFile();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Calculate an actor's Bacon Number");
            System.out.println("2. Add an entry to the list");
            System.out.println("3. Delete an entry from the list");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    calculateBaconNumber(scanner);
                    break;
                case 2:
                    addEntry(scanner);
                    break;
                case 3:
                    deleteEntry(scanner);
                    break;
                case 4:
                    writeLinesToFile();
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                System.out.println(line);
                if (parts.length >= 3) {
                    System.out.println("Part 1: " + parts[0] +" " + parts[1]);
                    actors.add(parts[0] +" " + parts[1]);

                    System.out.println("Part 2: " + parts[2]);
                    movies.add(parts[2]);
                    System.out.println("Part 3: "+parts[3]);
                    years.add(parts[3]);
                } else {
                    System.out.println("Invalid data format in file: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    private static void writeLinesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < actors.size(); i++) {
                bw.write(actors.get(i) + " " + movies.get(i) + " " + years.get(i));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateBaconNumber(Scanner scanner) {
        System.out.print("Enter actor's full name: ");
        String actor = scanner.nextLine();
        if (!actors.contains(actor)) {
            System.out.println(actor + " not found in the list.");
            return;
        }

        int index = actors.indexOf(actor);
        String movie = movies.get(index);

        if (movieContainsKevinBacon(movie)) {
            System.out.println(actor + "'s Bacon Number is 1.");
        } else {
            for (int i = 0; i < actors.size(); i++) {
                if (movies.get(i).equals(movie) && movieContainsKevinBacon(movies.get(i))) {
                    System.out.println(actor + "'s Bacon Number is 2.");
                    return;
                }
            }
            System.out.println(actor + " is not connected to Kevin Bacon within 2 degrees.");
        }
    }

    private static boolean movieContainsKevinBacon(String movie) {
        return actors.contains("Kevin Bacon") && movies.contains(movie) && actors.get(movies.indexOf(movie)).equals("Kevin Bacon");
    }

    private static void addEntry(Scanner scanner) {
        System.out.print("Enter actor's full name: ");
        String actor = scanner.nextLine();
        System.out.print("Enter movie name: ");
        String movie = scanner.nextLine();
        System.out.print("Enter year: ");
        String year = scanner.nextLine();

        actors.add(actor);
        movies.add(movie);
        years.add(year);

        System.out.println("Entry added successfully.");
    }

    private static void deleteEntry(Scanner scanner) {
        System.out.print("Enter actor's full name to delete: ");
        String actor = scanner.nextLine();
        if (!actors.contains(actor)) {
            System.out.println(actor + " not found in the list.");
            return;
        }

        int index = actors.indexOf(actor);
        actors.remove(index);
        movies.remove(index);
        years.remove(index);

        System.out.println("Entry deleted successfully.");
    }
}
