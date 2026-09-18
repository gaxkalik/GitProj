import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculatorApp extends Application {
    
    private TextField display;
    private Calculator calculator = new Calculator();
    private String operator = "";
    private double firstOperand = 0;
    private boolean startNewInput = true;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Calculator");

        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 20px;");
        display.setPrefHeight(50);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));

        String[][] buttons = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"C", "0", "=", "+"}
        };

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String text = buttons[i][j];
                Button button = new Button(text);
                button.setPrefSize(50, 50);
                button.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                button.setOnAction(e -> handleButtonPress(text));
                grid.add(button, j, i);
            }
        }

        VBox vbox = new VBox(10, display, grid);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vbox, 250, 320);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleButtonPress(String value) {
        if (value.matches("[0-9]")) {
            if (startNewInput || display.getText().equals("Error")) {
                display.setText(value);
                startNewInput = false;
            } else {
                display.setText(display.getText() + value);
            }
        } else if (value.equals("C")) {
            display.setText("");
            firstOperand = 0;
            operator = "";
            startNewInput = true;
        } else if (value.matches("[+\\-*/]")) {
            if (!display.getText().isEmpty() && !display.getText().equals("Error")) {
                firstOperand = Double.parseDouble(display.getText());
                operator = value;
                startNewInput = true;
            }
        } else if (value.equals("=")) {
            if (!operator.isEmpty() && !display.getText().isEmpty() && !display.getText().equals("Error")) {
                double secondOperand = Double.parseDouble(display.getText());
                try {
                    double result = calculator.calculate(firstOperand, secondOperand, operator);
                    if (result == (long) result) {
                        display.setText(String.format("%d", (long) result));
                    } else {
                        display.setText(String.valueOf(result));
                    }
                } catch (Exception e) {
                    display.setText("Error");
                }
                operator = "";
                startNewInput = true;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
