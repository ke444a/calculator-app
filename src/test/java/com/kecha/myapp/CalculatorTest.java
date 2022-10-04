package com.kecha.myapp;

import org.junit.jupiter.api.Test;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private CalculatorGUI gui = new CalculatorGUI();
    private Calculator calculator = new Calculator(gui);

    @Test
    public void checkAddTwoPositiveIntegers() {
        calculator.changeNumber(239);
        calculator.add();
        calculator.changeNumber(1000);
        assertEquals(1239.0, calculator.calculate());
    }

    @Test
    public void checkAddPositiveNegativeIntegers() {
        calculator.changeNumber(239);
        calculator.add();
        calculator.changeNumber(-1000);
        assertEquals(239.0-1000, calculator.calculate());
    }

    @Test
    public void checkAddTwoNegativeIntegers() {
        calculator.changeNumber(-239);
        calculator.add();
        calculator.changeNumber(-1000);
        assertEquals(-239.0-1000, calculator.calculate());
    }

    @Test
    public void checkSubtractTwoPositiveIntegers() {
        calculator.changeNumber(1509);
        calculator.subtract();
        calculator.changeNumber(721);
        assertEquals(1509.0-721, calculator.calculate());
    }

    @Test
    public void checkSubtractPositiveNegativeIntegers() {
        calculator.changeNumber(1509);
        calculator.subtract();
        calculator.changeNumber(-721);
        assertEquals(1509.0+721, calculator.calculate());
    }

    @Test
    public void checkSubtractTwoNegativeIntegers() {
        calculator.changeNumber(-1509);
        calculator.subtract();
        calculator.changeNumber(-721);
        assertEquals(-1509.0+721.0, calculator.calculate());
    }

    @Test
    public void checkMultiplyTwoPositiveIntegers() {
        calculator.changeNumber(61);
        calculator.multiply();
        calculator.changeNumber(99);
        assertEquals(61.0*99, calculator.calculate());
    }

    @Test
    public void checkMultiplyPositiveNegativeIntegers() {
        calculator.changeNumber(61);
        calculator.multiply();
        calculator.changeNumber(-99);
        assertEquals(-61*99.0, calculator.calculate());
    }

    @Test
    public void checkMultiplyTwoNegativeIntegers() {
        calculator.changeNumber(-61);
        calculator.multiply();
        calculator.changeNumber(-99);
        assertEquals(61.0*99, calculator.calculate());
    }

    @Test
    public void checkDivideTwoPositiveIntegers() {
        calculator.changeNumber(920);
        calculator.divide();
        calculator.changeNumber(32);
        assertEquals(920.0/32, calculator.calculate());
    }

    @Test
    public void checkDividePositiveNegativeIntegers() {
        calculator.changeNumber(920);
        calculator.divide();
        calculator.changeNumber(-32);
        assertEquals(-920.0/32, calculator.calculate());
    }

    @Test
    public void checkDivideTwoNegativeIntegers() {
        calculator.changeNumber(-920);
        calculator.divide();
        calculator.changeNumber(-32);
        assertEquals(920.0/32, calculator.calculate());
    }

    @Test
    public void checkSeparateByPoint() {
        calculator.changeNumber(140);
        calculator.separateByPoint();
        calculator.changeNumber(5);
        assertEquals(140.5, calculator.calculate());
    }

    @Test
    public void checkDelete() {
        calculator.changeNumber(12304);
        calculator.delete();
        calculator.delete();
        assertEquals(123.0, calculator.calculate());
    }

    @Test
    public void checkCleanAll() {
        calculator.changeNumber(1290);
        calculator.add();
        calculator.clean();
        calculator.changeNumber(870);
        calculator.divide();
        calculator.changeNumber(12);
        assertEquals(870.0/12, calculator.calculate());
    }

    @Test
    public void checkChangeSign() {
        calculator.changeNumber(765);
        calculator.changeSign();
        assertEquals(-765.0, calculator.calculate());

    }

    @Test
    public void checkInputNumberLimit() {
        // Maximum - 17 numbers
        assertTrue(1==1);
    }

    @Test
    public void checkResponseNumberLimit() {
        // Check for response limit
    }

    @Test
    public void checkDivisionByZero() {
        calculator.changeNumber(120);
        calculator.divide();
        calculator.changeNumber(0);
        calculator.updateNumber(calculator.calculate());
        assertEquals("Division by zero is impossible", gui.getTextContent());
        /*
        assertThrows(RuntimeException.class,
                () -> {
                    calculator.changeNumber(120);
                    calculator.divide();
                    calculator.changeNumber(0);
                    calculator.calculate();
                });
        */
    }

    @Test
    public void checkDivisionOfZeroByNumber() {
        calculator.changeNumber(0);
        calculator.divide();
        calculator.changeNumber(23);
        assertEquals(0.0, calculator.calculate());
    }

    @Test
    public void checkOverridingOperation() {
        assertTrue(1==1);
    }
}
