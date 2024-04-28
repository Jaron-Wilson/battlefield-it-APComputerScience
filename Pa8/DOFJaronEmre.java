import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/** **********************************************************
 * <p>
 * Programming Assignment: Degrees of Kevin Bacon
 * </p>
 * FILENAME: DOFJaronEmre.java
 * <br>
 * Date: 4/26/2024
 * <p>
 * Author: Jaron and emre
 * </p>
 * <p>
 * Description: This program implements a simplified version of the "Six Degrees of Kevin Bacon" game.
 *  * It allows users to search for a movie based on an actor's name, calculate the Bacon Number of an actor,
 *  * add new entries to the list, and delete entries from the list.
 * <p>
 * Honor Code: Its jaron & emre, and we have not used other people or sources in help with this project.
 * **********************************************************
 */

public class DOFJaronEmre {
    private static final String FILENAME = "list.txt"; //You must use file input/output taught in class to handle files
    private static final ArrayList<String> actors = new ArrayList<>(); //You must use array lists to store actors, movies, and year information
    private static final ArrayList<String> movies = new ArrayList<>(); //You must use array lists to store actors, movies, and year information
    private static final ArrayList<Integer> years = new ArrayList<>(); //You must use array lists to store actors, movies, and year information

    public static void main(String[] args) throws Exception {
        readDataFromFile();
        Scanner scanner = new Scanner(System.in);
        char choice;
        do {
            displayMenu();
            updateDataFile();
            choice = scanner.next().charAt(0);
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case '1':
                    System.out.println("Enter Actor:");
                    String targetActorName = scanner.nextLine();
                    System.out.println(searchMovie(targetActorName)); // TODO: 90% credit Searching
                    break;
                case '2':
                    calculateBaconNumber(scanner); // TODO: 100% Credit baconNumber
                    break;
                case '3':
                    addEntry(scanner); // works
                    break;
                case '4':
                    deleteEntry(scanner);
                    break;
                case 'Q':
                case 'q':
                case '5':
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'Q' && choice != 'q' && choice != '5');
        scanner.close();
        updateDataFile();
    }
    private static void displayMenu() {
        System.out.println("Select Options (Enter Q to Quit):");
        System.out.println("1. Search movie");
        System.out.println("2. Bacon Degrees of Freedom");
        System.out.println("3. Add Entry");
        System.out.println("4. Delete Entry");
        System.out.println("5. Quit");
    } // Menu Of Options
    private static String searchMovie(String targetActorName) {
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).equalsIgnoreCase(targetActorName) && !movies.isEmpty()) {
                    return actors.get(i) + " acted in the movie " + movies.get(i) + " in the year " + years.get(i);
                }
            }
        return "\nTry Again";
    }// Gets the actors movies and returns in string format
    private static void calculateBaconNumber(Scanner scanner) {
        System.out.println("Enter Actor:");
        String actorName = scanner.nextLine();

        // Store the names of actors and movies where the target actor appeared
        ArrayList<String> connectedActors = new ArrayList<>();
        ArrayList<String> connectedMovies = new ArrayList<>();
        ArrayList<Integer> connectedYears = new ArrayList<>();

        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).equalsIgnoreCase(actorName)) {
                String targetMovie = movies.get(i);
                for (int j = 0; j < movies.size(); j++) {
                    if (movies.get(j).equalsIgnoreCase(targetMovie) && i != j) {
                        connectedActors.add(actors.get(j));
                        connectedMovies.add(movies.get(j));
                        connectedYears.add(years.get(j));
                    }
                }
            }
        }

        // Print the results
        for (int i = 0; i < connectedActors.size(); i++) {
            System.out.println(actorName + " acted with " + connectedActors.get(i) +
                    " in the movie " + connectedMovies.get(i) + " in the year " + connectedYears.get(i));
        }

        System.out.println(actorName + " has Bacon Number = " + getBaconNumber(actorName));
    }

    private static int getBaconNumber(String actorName) {
        if (actors.contains(actorName)) {
            return 1; // Actor has appeared with Kevin Bacon
        } else {
            for (int i = 0; i < actors.size(); i++) {
                if (actors.get(i).equalsIgnoreCase("Kevin Bacon") && isConnectedToKevin(actorName, i)) {
                    return 2; // Actor has appeared with an actor who has appeared with Kevin Bacon
                }
            }
        }
        return -1; // Actor is not connected to Kevin Bacon within 2 degrees
    }
    private static boolean isConnectedToKevin(String actorName, int index) {
        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).equals(actorName) && movies.get(i).equals(movies.get(index)) && !years.get(i).equals(years.get(index))) {
                return true; // Actor appeared in the same movie with Kevin Bacon
            }
        }
        return false;
    }
    private static void addEntry(Scanner scanner) throws Exception {
        try (FileWriter file = new FileWriter(FILENAME, true)) {
            System.out.println("Enter Actor:");
            String actor = scanner.nextLine();
            System.out.println("Enter Movie:");
            String movie = scanner.nextLine();
            System.out.println("Enter Year:");
            int year = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            actors.add(actor);
            movies.add(movie);
            years.add(year);

            file.write("\n" +actor + " " + movie + " " + year);
            System.out.println("Entry added successfully.");
            updateDataFile();
        }
    } // Adds correctly
    private static void deleteEntry(Scanner scanner) throws IOException {
        System.out.println("Enter Actor to delete:");
        String actorToDelete = scanner.nextLine();

        File inputFile = new File(FILENAME);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.startsWith(actorToDelete)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
        }

        // Delete the original file
        if (!inputFile.delete()) {
            System.err.println("Could not delete file");
            return;
        }

        // Rename the temporary file to the original file name
        if (!tempFile.renameTo(inputFile)) {
            System.err.println("Could not rename file");
        } else {
            System.out.println("Entry deleted successfully.");
            updateDataFile();
        }
    } // Removes Correctly
    private static void readDataFromFile() { // TODO: WORKS AND ADDS TO ARRAY LIST
        try (Scanner fileScanner = new Scanner(new File(FILENAME))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // line from the FILENAME AS we take in 1 line at a time.
                // \\d{4} <- A number with 4 digits | $ <- This matches the end of the line.
                String[] parts = line.split(" (?=\\d{4}$)", 2); // Split at the last space before the year

                years.add(Integer.parseInt(parts[1])); // add to years array add it to end of array

                // Splits the year from Actors and movie
                String[] actorAndMovies = parts[0].split("\\s+", 3); // should take first 2 Strings in the part
                String actorsList = actorAndMovies[0] + " " + actorAndMovies[1];
                String movie = actorAndMovies[2];

                actors.add(actorsList);
                movies.add(movie);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
    private static void updateDataFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < actors.size(); i++) {
                writer.println(actors.get(i) + " " + movies.get(i) + " " + years.get(i));
            }
        } catch (IOException e) {
            System.err.println("Error updating data file: " + e.getMessage());
        }
    }
}
