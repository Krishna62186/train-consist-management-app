import java.util.Scanner;

public class LinearSearchBogieApp {

    public static void main(String[] args) {

        // Sample unsorted array of bogie IDs
        String[] bogieIDs = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Bogie IDs: ");
        for (String id : bogieIDs) {
            System.out.print(id + " ");
        }
        System.out.println("\nEnter bogie ID to search:");
        String searchKey = scanner.nextLine();

        boolean found = false;

        // Linear search logic
        for (int i = 0; i < bogieIDs.length; i++) {
            if (bogieIDs[i].equals(searchKey)) {
                found = true;
                System.out.println("Bogie ID " + searchKey + " found at position " + i + ".");
                break;  // Early termination
            }
        }

        if (!found) {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }

        scanner.close();
    }
}