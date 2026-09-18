import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        
        System.out.println("--- Simple Calculator ---");
        System.out.println("Supported operations: +, -, *, /");
        
        try {
            System.out.print("Enter first number: ");
            double num1 = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Enter operator (+, -, *, /): ");
            String op = scanner.nextLine().trim();
            
            System.out.print("Enter second number: ");
            double num2 = Double.parseDouble(scanner.nextLine());
            
            double result = calculator.calculate(num1, num2, op);
            System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, op, num2, result);
            
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format. Please enter numerical values.");
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
