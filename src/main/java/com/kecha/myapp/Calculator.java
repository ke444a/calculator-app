package com.kecha.myapp;

import java.math.*;

public class Calculator {
    private enum Operation {
        NEUTRAL,
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE
    }

    private Operation operation;
    private CalculatorGUI gui;
    private StringBuilder text;
    private double firstNumber, secondNumber;


    Calculator(CalculatorGUI gui) {
        this.gui = gui;
        this.text = new StringBuilder("");
        this.operation = Operation.NEUTRAL;
    }

    public void changeNumber(int num) {
        text.append(num);
        gui.setTextContent(text.toString());
    }

    public void changeSign() {
        double changedNumber = firstNumber;
        try {
            changedNumber = -Double.parseDouble(gui.getTextContent());
        } catch(NumberFormatException ex) {
            ex.printStackTrace();
        } finally {
            firstNumber = changedNumber;
            updateNumber(changedNumber);
        }
    }

    public void delete() {
        text.deleteCharAt(text.length()-1);
        updateTextField(text.toString());
    }

    public void separateByPoint() {
        text.append('.');
        updateTextField(text.toString());
    }

    public void clean() {
        text.delete(0, text.length());
        updateTextField("");
        operation = operation.NEUTRAL;
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
        updateNumber(calculate());
    }

    public double calculate() {
        secondNumber = Double.parseDouble(text.toString());
        double result = secondNumber;

        switch (operation) {
            case NEUTRAL:
                break;

            case ADD:
                result = firstNumber + secondNumber;
                break;

            case SUBTRACT:
                result = firstNumber - secondNumber;
                break;

            case MULTIPLY:
                result = firstNumber * secondNumber;
                break;

            case DIVIDE:
                result = firstNumber / secondNumber;
                break;
        }
        firstNumber = result;
        return result;
    }

    public void updateOperation(String operationName, Operation operationStatus) {
        try {
            System.out.println(text.toString());
            firstNumber = Double.parseDouble(text.toString());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } finally {
            updateTextField(operationName);
            text.delete(0, text.length());
            operation = operationStatus;
        }
    }

    public void updateNumber(double number) {
        String newText = "";
        if (number == Float.POSITIVE_INFINITY || number == Float.NEGATIVE_INFINITY) {
            newText = "Division by zero is impossible";
        } else if (number % 1 == 0) {
            newText = String.valueOf(Math.round(number));
        } else {
            newText = String.valueOf(roundFloatNumber(number, 7));
        }

        //text.replace(0, text.length(), newText);
        updateTextField(newText);
        //text.delete(0, text.length());
        text.replace(0, text.length(), String.valueOf(number));
    }

    public void updateTextField(String newContent) {
        gui.setTextContent(newContent);
    }

    private double roundFloatNumber(double number, int decimalPlaces) {
        BigDecimal bigDecVal = new BigDecimal(Double.toString(number));
        return bigDecVal.setScale(decimalPlaces, RoundingMode.HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }
}
