import java.util.*;

// ------------------------
// Custom Exception Class
// ------------------------
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ------------------------
// Passenger Bogie Class
// ------------------------
class PassengerBogie {

    private String type;
    private int capacity;

    // Constructor with validation
    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

// ------------------------
// Main Application
// ------------------------
public class TrainExceptionApp {

    public static void main(String[] args) {

        try {
            // Creating valid bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + b1.getType() + " with capacity " + b1.getCapacity());

            // Attempting invalid bogie (zero capacity)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Created: " + b2.getType() + " with capacity " + b2.getCapacity());

            // Attempting invalid bogie (negative capacity)
            PassengerBogie b3 = new PassengerBogie("First Class", -10);
            System.out.println("Created: " + b3.getType() + " with capacity " + b3.getCapacity());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}