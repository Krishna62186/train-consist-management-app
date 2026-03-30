import java.util.ArrayList;
import java.util.List;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " → Capacity: " + capacity;
    }
}

public class TrainAppUC10 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create a list of bogies (Passenger bogies)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72)); // duplicate type, valid for counting

        // Display all bogies
        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // Calculate total seating capacity using Stream + map + reduce
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)        // extract capacity
                .reduce(0, Integer::sum);    // sum all capacities

        // Display total seating capacity
        System.out.println("\nTotal Seating Capacity of Train: " + totalSeats);

        // Original list remains unchanged
        System.out.println("\nOriginal List After Aggregation (Unchanged):");
        bogies.forEach(System.out::println);
    }
}