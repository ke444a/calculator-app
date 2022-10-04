package com.kecha.myapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    private Calculator calculator;
    private JPanel mainPanel;
    private JTextField resultField;

    CalculatorGUI() {
        calculator = new Calculator(this);

        // Default setting for JFrame:
        this.setTitle("Calculator");
        ImageIcon icon = new ImageIcon("src/main/resources/calculator-icon.png");
        this.setIconImage(icon.getImage());
        this.setLayout(new BorderLayout());
        buildComponents();
        this.getContentPane().setBackground(new Color(30, 20, 20));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(450, 550);
        this.setVisible(true);
    }

    private void buildComponents() {
        this.add(buildTextField(), BorderLayout.NORTH);
        this.add(buildPanel(), BorderLayout.CENTER);
    }

    private JTextField buildTextField() {
        resultField = new JTextField();
        resultField.setBorder(BorderFactory.createEmptyBorder(3,20,3,20));
        resultField.setPreferredSize(new Dimension(450,100));
        resultField.setBackground(new Color(255, 210,50));
        resultField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        resultField.setFocusable(false);
        return resultField;
    }

    private JPanel buildPanel() {
        mainPanel = new JPanel(new GridLayout(5,4,10,10));
        mainPanel.setBackground(null);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        // Initializing buttons with numbers:
        NumberButton button1 = new NumberButton("1");
        button1.addActionListener(new NumberPressedListener(1));
        NumberButton button2 = new NumberButton("2");
        button2.addActionListener(new NumberPressedListener(2));
        NumberButton button3 = new NumberButton("3");
        button3.addActionListener(new NumberPressedListener(3));
        NumberButton button4 = new NumberButton("4");
        button4.addActionListener(new NumberPressedListener(4));
        NumberButton button5 = new NumberButton("5");
        button5.addActionListener(new NumberPressedListener(5));
        NumberButton button6 = new NumberButton("6");
        button6.addActionListener(new NumberPressedListener(6));
        NumberButton button7 = new NumberButton("7");
        button7.addActionListener(new NumberPressedListener(7));
        NumberButton button8 = new NumberButton("8");
        button8.addActionListener(new NumberPressedListener(8));
        NumberButton button9 = new NumberButton("9");
        button9.addActionListener(new NumberPressedListener(9));
        NumberButton button0 = new NumberButton("0");
        button0.addActionListener(new NumberPressedListener(0));
        
        // Initializing buttons with math operations:
        OperationButton buttonSign = new OperationButton("+/-");
        buttonSign.addActionListener(new SignPressedListener());
        OperationButton buttonPoint = new OperationButton(".");
        buttonPoint.addActionListener(new PointPressedListener());
        OperationButton buttonAdd = new OperationButton("+");
        buttonAdd.addActionListener(new AddPressedListener());
        OperationButton buttonSubtract = new OperationButton("-");
        buttonSubtract.addActionListener(new SubtractPressedListener());
        OperationButton buttonDivide = new OperationButton("/");
        buttonDivide.addActionListener(new DividePressedListener());
        OperationButton buttonMultiply = new OperationButton("*");
        buttonMultiply.addActionListener(new MultiplyPressedListener());
        OperationButton buttonDelete = new OperationButton("->");
        buttonDelete.addActionListener(new DeletePressedListener());
        OperationButton buttonClean = new OperationButton("CE");
        buttonClean.addActionListener(new CleanPressedListener());
        OperationButton buttonEqual = new OperationButton("=");
        buttonEqual.addActionListener(new EqualPressedListener());

        // Adding buttons to the panel:
        mainPanel.setBackground(null);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(buttonAdd);
        mainPanel.add(button4);
        mainPanel.add(button5);
        mainPanel.add(button6);
        mainPanel.add(buttonSubtract);
        mainPanel.add(button7);
        mainPanel.add(button8);
        mainPanel.add(button9);
        mainPanel.add(buttonDivide);
        mainPanel.add(buttonSign);
        mainPanel.add(button0);
        mainPanel.add(buttonPoint);
        mainPanel.add(buttonMultiply);
        mainPanel.add(buttonClean);
        mainPanel.add(buttonDelete);
        mainPanel.add(buttonEqual);

        return mainPanel;
    }

    public class NumberPressedListener implements ActionListener {
        private int number;

        public NumberPressedListener(int num) {
            this.number = num;
        }

        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.changeNumber(number);
        }
    }

    public class SignPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.changeSign();
        }
    }

    public class PointPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.separateByPoint();
        }
    }

    public class AddPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.add();
        }
    }

    public class SubtractPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.subtract();
        }
    }

    public class DividePressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.divide();
        }
    }

    public class MultiplyPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.multiply();
        }
    }

    public class EqualPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.equal();
        }
    }

    public class CleanPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.clean();
        }
    }

    public class DeletePressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.delete();
        }
    }

    public String getTextContent() {
        return resultField.getText();
    }

    public void setTextContent(String content) {
        resultField.setText(content);
    }

}
