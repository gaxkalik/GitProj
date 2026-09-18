public class Main {
    public static void main(String[] args) {
        // A simple wrapper that does not extend Application
        // This prevents the Java launcher from aggressively verifying JavaFX modules on the module path.
        CalculatorApp.main(args);
        System.out.println("hel");
    }
}
