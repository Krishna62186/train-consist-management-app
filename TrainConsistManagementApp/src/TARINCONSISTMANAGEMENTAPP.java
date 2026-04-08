
import java.util.*;
import java.util.stream.*;

class PassengerBogie {
    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
}

public class PerformanceComparisonApp {

    public static void main(String[] args) {

        // Create large dataset of bogies
        List<PassengerBogie> bogies = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            int capacity = (i % 100) + 1; // capacities from 1 to 100
            bogies.add(new PassengerBogie("General", capacity));
        }

        // -------------------------------
        // LOOP-BASED FILTERING
        // -------------------------------
        long loopStart = System.nanoTime();

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie bogie : bogies) {
            if (bogie.getCapacity() > 60) {
                loopResult.add(bogie);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // STREAM-BASED FILTERING
        // -------------------------------
        long streamStart = System.nanoTime();

        List<PassengerBogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // -------------------------------
        // OUTPUT RESULTS
        // -------------------------------
        System.out.println("Loop Result Count   : " + loopResult.size());
        System.out.println("Stream Result Count : " + streamResult.size());

        System.out.println("Loop Execution Time   (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        // Verify correctness
        if (loopResult.size() == streamResult.size()) {
            System.out.println("✔ Results Match");
        } else {
            System.out.println("❌ Results Do Not Match");
        }
    }
}