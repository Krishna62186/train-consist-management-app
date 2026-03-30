import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Bogie class (same as UC7/UC8)
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
        // UC9: Group Bogies by Type
        // =========================

        // Create a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 72)); // duplicate type to test grouping

        // Display original list
        System.out.println("\nAll Bogies:");
        bogies.forEach(System.out::println);

        // Group bogies by name/type using groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped bogies
        System.out.println("\nGrouped Bogies by Type:");
        groupedBogies.forEach((type, list) -> {
            System.out.println(type + ":");
            list.forEach(b -> System.out.println("  " + b));
        });

        // Verify original list unchanged
        System.out.println("\nOriginal List After Grouping (Unchanged):");
        bogies.forEach(System.out::println);

        // Program continues...
    }
}