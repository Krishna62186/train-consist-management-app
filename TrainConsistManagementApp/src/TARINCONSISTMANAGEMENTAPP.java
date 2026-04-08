import java.util.*;
import java.util.stream.*;

class GoodsBogie {
    private String type;   // Cylindrical, Open, Box, etc.
    private String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }
}

public class TrainSafetyApp {

    public static void main(String[] args) {

        // Sample list of goods bogies
        List<GoodsBogie> bogies = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal"),
                new GoodsBogie("Box", "Grain")
        );

        // Stream-based safety validation
        boolean isSafe = bogies.stream()
                .allMatch(bogie ->
                        // Rule: Cylindrical → only Petroleum allowed
                        !bogie.getType().equalsIgnoreCase("Cylindrical")
                                || bogie.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Output result
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("Train is NOT SAFE!");
        }
    }
}
