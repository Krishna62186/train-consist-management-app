import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Bogie class (same as UC7)
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

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // =========================
        // UC8: Stream Filtering
        // =========================

        // Create bogie list (reuse UC7 idea)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));

        // Display original list
        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // Filter bogies with capacity > 60
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Display filtered result
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        // Verify original list unchanged
        System.out.println("\nOriginal List After Filtering (Unchanged):");
        bogies.forEach(System.out::println);

        // Program continues...
    }
}