# JavaFX Simple Calculator

A standard desktop calculator utility built with modern **Java (17+)** and **JavaFX 21**. It features a clean object-oriented design spanning multiple separated classes to correctly handle UI implementation, business logic, and modern Java runtime module restrictions.

## Features
* Standard arithmetic operations: Addition (`+`), Subtraction (`-`), Multiplication (`*`), and Division (`/`)
* Decimal number support and automatic formatting 
* Real-time error handling (e.g., division by zero)
* Simple, clean Desktop graphical user interface (GUI)

## Project Structure
* `src/Calculator.java`: Holds the core mathematical operations and logic handling.
* `src/CalculatorApp.java`: Translates the layout and manages all JavaFX GUI dependencies (`TextField` display and `GridPane` numeric keypad). Extends `javafx.application.Application`.
* `src/Main.java`: A standalone launcher wrapper designed to circumvent Java 11+ runtime "Missing JavaFX components" strict module checks.
* `pom.xml`: A standard Maven build configuration file linking standard Java libraries to the required `org.openjfx` deployment dependencies.

## Prerequisites
* **Java Development Kit (JDK) 11** or higher
* **Maven** (optional, recommended for CLI execution)

## How to Run

### Via IntelliJ IDEA (or any IDE)
1. Ensure your IDE recognizes the project as a Maven project (Right-click `pom.xml` -> **"Add as Maven Project"**).
2. Open `src/Main.java`.
3. Click the green **Run** arrow next to the `public static void main(String[] args)` method.

### Via Command Line (Maven)
Execute the native JavaFX wrap target directly through the configured terminal:
```bash
mvn clean compile javafx:run
```
