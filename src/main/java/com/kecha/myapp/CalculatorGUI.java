package com.kecha.myapp;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class CalculatorGUI extends JFrame {
    /* Class responsible for creating GUI for calculator */

    private Calculator calculator;
    private JPanel mainPanel;
    private JTextField resultField;

    CalculatorGUI() {
        // Instantiate class responsible for logic of the program
        calculator = new Calculator(this);

        // Set default settings for main frame
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
        /* Add created components to the main frame */
        this.add(buildTextField(), BorderLayout.NORTH);
        this.add(buildPanel(), BorderLayout.CENTER);
    }

    private JTextField buildTextField() {
        /* Initialise and customise text field */
        resultField = new JTextField();
        resultField.setBorder(BorderFactory.createLineBorder(new Color(30, 20, 20), 15));
        resultField.setBorder(BorderFactory.createCompoundBorder(resultField.getBorder(),
                BorderFactory.createEmptyBorder(3,25,3,25)));
        resultField.setPreferredSize(new Dimension(450,100));
        resultField.setBackground(new Color(255, 210,50));
        resultField.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        resultField.setEditable(false);
        return resultField;
    }

    private JPanel buildPanel() {
        mainPanel = new JPanel(new GridLayout(5,4,10,10));
        mainPanel.setBackground(null);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));

        // Initialise buttons with correspondent numbers (0-9)
        NumberButton[] numberBtnArray = new NumberButton[10];
        for (int i=0; i<10;i++) {
            numberBtnArray[i] = new NumberButton(String.valueOf(i));
            numberBtnArray[i].addActionListener(new NumberPressedListener(i));
        }

        // Initialise buttons with main mathematical operations
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
        OperationButton buttonDelete = new OperationButton("<-");
        buttonDelete.addActionListener(new DeletePressedListener());
        OperationButton buttonClean = new OperationButton("C");
        buttonClean.addActionListener(new CleanPressedListener());
        OperationButton buttonCleanAll = new OperationButton("CE");
        buttonCleanAll.addActionListener(new CleanAllPressedListener());
        OperationButton buttonEqual = new OperationButton("=");
        buttonEqual.setBackground(new Color(80, 80, 80));
        buttonEqual.addActionListener(new EqualPressedListener());

        // Add buttons to the panel
        mainPanel.setBackground(null);
        mainPanel.add(numberBtnArray[1]);
        mainPanel.add(numberBtnArray[2]);
        mainPanel.add(numberBtnArray[3]);
        mainPanel.add(buttonAdd);
        mainPanel.add(numberBtnArray[4]);
        mainPanel.add(numberBtnArray[5]);
        mainPanel.add(numberBtnArray[6]);
        mainPanel.add(buttonSubtract);
        mainPanel.add(numberBtnArray[7]);
        mainPanel.add(numberBtnArray[8]);
        mainPanel.add(numberBtnArray[9]);
        mainPanel.add(buttonDivide);
        mainPanel.add(buttonSign);
        mainPanel.add(numberBtnArray[0]);
        mainPanel.add(buttonPoint);
        mainPanel.add(buttonMultiply);
        mainPanel.add(buttonClean);
        mainPanel.add(buttonCleanAll);
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

    public class CleanAllPressedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            calculator.cleanAll();
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
