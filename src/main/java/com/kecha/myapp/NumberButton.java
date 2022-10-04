package com.kecha.myapp;
import javax.swing.*;
import java.awt.*;

public class NumberButton extends JButton {
    public NumberButton(String value) {
        this.setBackground(new Color(80, 80, 80));
        this.setFont(new Font("Courier New", Font.BOLD, 20));
        this.setForeground(Color.WHITE);
        this.setText(value);
        this.setFocusable(false);
    }
}
