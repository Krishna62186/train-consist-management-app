import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistValidationApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter Train ID: ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = scanner.nextLine();

        // Regex Patterns
        String trainIdRegex = "TRN-\\d{4}";
        String cargoCodeRegex = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainIdRegex);
        Pattern cargoPattern = Pattern.compile(cargoCodeRegex);

        // Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validation using matches()
        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        // Output results
        if (isTrainValid) {
            System.out.println("Train ID is VALID.");
        } else {
            System.out.println("Train ID is INVALID.");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is VALID.");
        } else {
            System.out.println("Cargo Code is INVALID.");
        }

        scanner.close();
    }
}