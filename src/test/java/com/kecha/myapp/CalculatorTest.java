package com.kecha.myapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private CalculatorGUI gui = new CalculatorGUI();
    private Calculator calculator = new Calculator(gui);

    @Test
    public void checkAddTwoPositiveIntegers() {
        calculator.changeNumber(239);
        calculator.add();
        calculator.changeNumber(1000);
        calculator.equal();
        assertEquals(1000+239, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkAddPositiveNegativeIntegers() {
        calculator.changeNumber(239);
        calculator.add();
        calculator.changeNumber(-1000);
        calculator.equal();
        assertEquals(239-1000, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkAddTwoNegativeIntegers() {
        calculator.changeNumber(-239);
        calculator.add();
        calculator.changeNumber(-1000);
        calculator.equal();
        assertEquals(-239-1000, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkSubtractTwoPositiveIntegers() {
        calculator.changeNumber(1509);
        calculator.subtract();
        calculator.changeNumber(721);
        calculator.equal();
        assertEquals(1509-721, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkSubtractPositiveNegativeIntegers() {
        calculator.changeNumber(1509);
        calculator.subtract();
        calculator.changeNumber(-721);
        calculator.equal();
        assertEquals(1509+721, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkSubtractTwoNegativeIntegers() {
        calculator.changeNumber(-1509);
        calculator.subtract();
        calculator.changeNumber(-721);
        calculator.equal();
        assertEquals(-1509+721, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkMultiplyTwoPositiveIntegers() {
        calculator.changeNumber(61);
        calculator.multiply();
        calculator.changeNumber(99);
        calculator.equal();
        assertEquals(61*99, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkMultiplyPositiveNegativeIntegers() {
        calculator.changeNumber(61);
        calculator.multiply();
        calculator.changeNumber(-99);
        calculator.equal();
        assertEquals(-61*99, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkMultiplyTwoNegativeIntegers() {
        calculator.changeNumber(-61);
        calculator.multiply();
        calculator.changeNumber(-99);
        calculator.equal();
        assertEquals(61*99, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkDivideTwoPositiveIntegers() {
        calculator.changeNumber(920);
        calculator.divide();
        calculator.changeNumber(32);
        calculator.equal();
        assertEquals(920.0/32, Double.parseDouble(gui.getTextContent()));
    }

    @Test
    public void checkDividePositiveNegativeIntegers() {
        calculator.changeNumber(920);
        calculator.divide();
        calculator.changeNumber(-32);
        calculator.equal();
        assertEquals(-920.0/32, Double.parseDouble(gui.getTextContent()));
    }

    @Test
    public void checkDivideTwoNegativeIntegers() {
        calculator.changeNumber(-920);
        calculator.divide();
        calculator.changeNumber(-32);
        calculator.equal();
        assertEquals(920.0/32, Double.parseDouble(gui.getTextContent()));
    }

    @Test
    public void checkSeparateByPoint() {
        calculator.changeNumber(140);
        calculator.separateByPoint();
        calculator.changeNumber(5);
        assertEquals(140.5, Double.parseDouble(gui.getTextContent()));
    }

    @Test
    public void checkDelete() {
        calculator.changeNumber(12304);
        calculator.delete();
        calculator.delete();
        assertEquals(123, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkCleanAll() {
        calculator.changeNumber(1290);
        calculator.add();
        calculator.cleanAll();
        calculator.changeNumber(870);
        calculator.divide();
        calculator.changeNumber(12);
        calculator.equal();
        assertEquals(870.0/12, Double.parseDouble(gui.getTextContent()));
    }

    @Test
    public void checkChangeSignFromPositiveToNegative() {
        calculator.changeNumber(765);
        calculator.changeSign();
        assertEquals(-765, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkChangeSignFromNegativeToPositive() {
        calculator.changeNumber(-125);
        calculator.changeSign();
        assertEquals(125, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkDivisionByZero() {
        calculator.changeNumber(120);
        calculator.divide();
        calculator.changeNumber(0);
        calculator.equal();
        assertEquals("Error: Division by zero is impossible", gui.getTextContent());
    }

    @Test
    public void checkDivisionOfZeroByNumber() {
        calculator.changeNumber(0);
        calculator.divide();
        calculator.changeNumber(23);
        calculator.equal();
        assertEquals(0, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkOverridingOperation() {
        calculator.changeNumber(129);
        calculator.divide();
        calculator.add();
        calculator.changeNumber(38);
        calculator.equal();
        assertEquals(129+38, Integer.parseInt(gui.getTextContent()));
    }

    @Test
    public void checkMultiplyBigValues() {
        calculator.changeNumber(888888888);
        calculator.separateByPoint();
        calculator.changeNumber(23);
        calculator.multiply();
        calculator.changeNumber(999999999);
        calculator.equal();
        assertEquals(888888888.23 * 999999999.0, Double.parseDouble(gui.getTextContent()));
    }
}
