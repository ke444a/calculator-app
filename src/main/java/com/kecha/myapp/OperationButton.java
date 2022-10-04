package com.kecha.myapp;

import javax.swing.*;
import java.awt.*;

public class OperationButton extends JButton {
    public OperationButton(String text) {
        this.setBackground(new Color(203, 82, 98));
        this.setFont(new Font("Courier New", Font.BOLD, 20));
        this.setForeground(Color.WHITE);
        this.setText(text);
        this.setFocusable(false);
    }
}
