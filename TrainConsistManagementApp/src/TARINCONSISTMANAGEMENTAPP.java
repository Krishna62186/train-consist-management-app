import java.util.HashMap;
import java.util.Map;

public class TrainApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // =========================
        // UC6: Bogie → Capacity Mapping
        // =========================

        // Create HashMap
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Add bogie capacities
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        // Display all entries
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogie = entry.getKey();
            int capacity = entry.getValue();

            System.out.println("Bogie: " + bogie + " | Capacity: " + capacity);
        }

        // Example: Fast lookup
        System.out.println("\nCapacity of Sleeper: " + bogieCapacityMap.get("Sleeper"));

        // Program continues...
    }
}