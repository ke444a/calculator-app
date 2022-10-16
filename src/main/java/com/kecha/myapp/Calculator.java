package com.kecha.myapp;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {
    /* Class responsible for logic of the program */

    private enum Operation {
        /* Assign categorical values to the type of operation */
        NEUTRAL,    // default operation type (no operation is chosen)
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    private Operation operation;
    private CalculatorGUI gui;
    private double number1, number2;


    Calculator(CalculatorGUI gui) {
        this.gui = gui;
        this.operation = Operation.NEUTRAL;
    }

    public void add() {
        updateOperation("+", Operation.ADD);
    }

    public void subtract() {
        updateOperation("-", Operation.SUBTRACT);
    }

    public void multiply() {
        updateOperation("*", Operation.MULTIPLY);
    }

    public void divide() {
        updateOperation("/", Operation.DIVIDE);
    }

    public void equal() {
        /* Calculate result based on inputted numbers and operation type */
        gui.setTextContent(processResult(calculate()));

        try {
            number1 = Double.parseDouble(gui.getTextContent());
        } catch (NumberFormatException ex) {
            // If error in calculations has occurred
            number1 = 0.0;
        }
    }

    public void changeNumber(int num) {
        /* Process the press of any button with numbers
        The length limit is 15 numbers
        */
        String currentLine = gui.getTextContent();
        if (operation == operation.NEUTRAL && currentLine.length() < 15) {
            // Entering the first number (no operation has been chosen)
            gui.setTextContent(gui.getTextContent().concat(String.valueOf(num)));
        } else if (operation != operation.NEUTRAL &&
                currentLine.substring(currentLine.lastIndexOf(" ")+1).length() < 15) {
            // Entering the second number (operation has been chosen)
            gui.setTextContent(gui.getTextContent().concat(String.valueOf(num)));
        }
    }

    public void changeSign() {
        String newNumber = "";
        try {
            number1 = -Double.parseDouble(gui.getTextContent());
            newNumber = processResult(number1);
        } catch (NumberFormatException ex) {
            // If no number is entered but button for changing sign has been pressed
            newNumber = "";
        } finally {
            gui.setTextContent(newNumber);
        }
    }

    public void delete() {
        String newNumber = "";
        try {
            newNumber = gui.getTextContent().substring(0, gui.getTextContent().length() - 1);
        } catch (StringIndexOutOfBoundsException ex) {
            // If string is already empty
            newNumber = "";
        } finally {
            gui.setTextContent(newNumber);
        }
    }

    public void separateByPoint() {
        String currentLine = gui.getTextContent();
        if (operation != Operation.NEUTRAL) {
            // Add decimal point to first number (no operation has been chosen)
            currentLine = currentLine.substring(currentLine.lastIndexOf(" ")+1);
        }

        if (!currentLine.contains(".") && currentLine.length()!=0) {
            // Add decimal point to second number (operation has been chosen)
            gui.setTextContent(gui.getTextContent().concat("."));
        }
    }

    public void clean() {
        /* Process cleaning only one whole number (either second or first) */
        String currentLine =  gui.getTextContent();
        if (operation != Operation.NEUTRAL) {
            gui.setTextContent(currentLine.substring(0, currentLine.lastIndexOf(" ")+1));
        } else {
            gui.setTextContent("");
        }
    }

    public void cleanAll() {
        gui.setTextContent("");
        operation = operation.NEUTRAL;
        number1 = 0.0;
        number2 = 0.0;
    }

    private double calculate() {
        String currentLine = gui.getTextContent();
        double calculationResult = number1;

        try {
            number2 = Double.parseDouble(currentLine.substring(currentLine.lastIndexOf(" ") + 1));
            switch (operation) {
                case NEUTRAL:
                    break;
                case ADD:
                    calculationResult = number1 + number2;
                    break;

                case SUBTRACT:
                    calculationResult = number1 - number2;
                    break;

                case MULTIPLY:
                    calculationResult = number1 * number2;
                    break;

                case DIVIDE:
                    calculationResult = number1 / number2;
                    break;
            }
        } catch (NumberFormatException ex) {
            // If second number is not entered but button '=' has been pressed
            calculationResult = number1;
        } finally {
            operation = Operation.NEUTRAL;
        }
        return calculationResult;
    }

    private String processResult(double number) {
        String newText = "";
        if (number == Float.POSITIVE_INFINITY || number == Float.NEGATIVE_INFINITY) {
            newText = "Error: Division by zero is impossible";
        } else {
            newText = String.valueOf(roundNumber(number, 10));
        }

        if (number % 1 == 0 && !newText.contains("E")) {
            // Delete space after decimal point if number is actually integer
            newText = newText.substring(0, newText.indexOf('.'));
        }
        return newText;
    }

    private void updateOperation(String operationName, Operation operationStatus) {
        boolean isError = false;

        // Parse first number only once in case operation has been overridden
        if (operation == Operation.NEUTRAL) {
            try {
                number1 = Double.parseDouble(gui.getTextContent());
            } catch (NumberFormatException ex) {
                // If no number is entered but operation button has been pressed
                isError = true;
            }
        }

        if (!isError) {
            String currentLine = gui.getTextContent();
            if (operation != Operation.NEUTRAL) {
                // Operation has been overridden (replace old operation with new one)
                gui.setTextContent(currentLine.replaceAll(" [\\*\\/\\-\\+] ", " " + operationName + " "));
            } else {
                gui.setTextContent(currentLine.concat(" " + operationName + " "));
            }
            operation = operationStatus;
        }
    }

    private double roundNumber(double number, int decimalPlaces) {
        BigDecimal bigDecVal = new BigDecimal(Double.toString(number));
        return bigDecVal.setScale(decimalPlaces, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
