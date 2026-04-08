import java.util.Arrays;
import java.util.Scanner;

public class SearchWithValidationApp {

    public static void main(String[] args) {
        // Example bogie collection (can be empty to test exception)
        String[] bogieIDs = {}; // Try changing to {"BG101","BG205","BG309"} to test normal search

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bogie ID to search:");
        String searchKey = scanner.nextLine();

        try {
            boolean found = searchBogieWithValidation(bogieIDs, searchKey);
            if (found) {
                System.out.println("Bogie ID " + searchKey + " found in the train consist.");
            } else {
                System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }

    /**
     * Searches for a bogie ID with state validation.
     * Throws IllegalStateException if bogie collection is empty.
     */
    public static boolean searchBogieWithValidation(String[] bogies, String key) {
        // Fail-fast validation
        if (bogies == null || bogies.length == 0) {
            throw new IllegalStateException("Cannot search: No bogies exist in the train consist.");
        }

        // Linear search logic
        for (String bogieID : bogies) {
            if (bogieID.equals(key)) {
                return true;
            }
        }
        return false;
    }
}