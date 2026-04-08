import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchBogieApp {

    public static void main(String[] args) {
        // Sample unsorted bogie IDs
        String[] bogieIDs = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        System.out.println("Available Bogie IDs (unsorted): " + Arrays.toString(bogieIDs));

        // Sort the array first (binary search precondition)
        Arrays.sort(bogieIDs);
        System.out.println("Sorted Bogie IDs: " + Arrays.toString(bogieIDs));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter bogie ID to search:");
        String searchKey = scanner.nextLine();

        int resultIndex = binarySearch(bogieIDs, searchKey);

        if (resultIndex != -1) {
            System.out.println("Bogie ID " + searchKey + " found at position " + resultIndex + ".");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found in the train consist.");
        }

        scanner.close();
    }

    /**
     * Binary search for a sorted array of String bogie IDs.
     * Returns index if found, -1 if not found.
     */
    public static int binarySearch(String[] sortedArray, String key) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = key.compareTo(sortedArray[mid]);

            if (comparison == 0) {
                return mid;  // Found
            } else if (comparison < 0) {
                high = mid - 1;  // Search left half
            } else {
                low = mid + 1;   // Search right half
            }
        }

        return -1;  // Not found
    }
}