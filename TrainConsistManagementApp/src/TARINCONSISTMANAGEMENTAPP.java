// ------------------------
// Custom Runtime Exception
// ------------------------
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ------------------------
// GoodsBogie Class
// ------------------------
class GoodsBogie {

    private String shape; // e.g., Rectangular, Cylindrical
    private String cargo; // cargo assigned

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public String getCargo() {
        return cargo;
    }

    // Method to assign cargo with safety validation
    public void assignCargo(String cargo) {
        try {
            // Safety rule: Rectangular bogie cannot carry Petroleum
            if (shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo: Petroleum cannot be assigned to Rectangular bogie");
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println("Cargo assigned successfully: " + cargo + " to " + shape + " bogie");

        } catch (CargoSafetyException e) {
            // Handle unsafe assignment
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Cleanup / logging
            System.out.println("Cargo assignment attempt completed for " + shape + " bogie.\n");
        }
    }
}

// ------------------------
// Main Application
// ------------------------
public class SafeCargoAssignmentApp {

    public static void main(String[] args) {

        // Create bogies
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        // Safe cargo assignment
        cylindricalBogie.assignCargo("Petroleum");

        // Unsafe cargo assignment
        rectangularBogie.assignCargo("Petroleum");

        // Assign safe cargo to rectangular bogie
        rectangularBogie.assignCargo("Coal");

        // Program continues safely
        System.out.println("All cargo assignments processed. System running normally.");
    }
}