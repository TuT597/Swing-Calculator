package calculator_pack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator extends JFrame implements ActionListener {

    private final DecimalFormat df = new DecimalFormat("#,###.00");

    private final String[] symbols = {
            "AC", "€", "%", "÷",
            "7", "8", "9", "x",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "Adv", "="
    };

    private int operator = 0;
    private final JPanel panel = new JPanel(new BorderLayout(5,5));
    private final JPanel btnPanel = new JPanel(new GridLayout(5,3,2,2));
    private final JButton[] btns =  new JButton[20];
    private final JTextArea screen = new JTextArea(5,40);
    private double firstNum = 0, secondNum = 0;
    private final JTextField calculatingTf = new JTextField(40);

    public Calculator() {
        init();
    }

    private void init() {

        add(panel);
        screen.setBackground(Color.BLACK);
        panel.setBackground(Color.BLACK);
        btnPanel.setBackground(Color.black);
        screen.setForeground(Color.WHITE);

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(symbols[i]);
            btns[i].setOpaque(false);
            btns[i].setBorderPainted(false);
            btns[i].setBackground(Color.black);
            btns[i].setForeground(Color.white);
            btns[i].addActionListener(this);
            btnPanel.add(btns[i]);
        }


        panel.add(calculatingTf, BorderLayout.SOUTH);
        panel.add(btnPanel, BorderLayout.CENTER);
        panel.add(screen, BorderLayout.NORTH);
        add(panel);
        setSize(340, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cmd = e.getActionCommand();

        switch (cmd) {

            case "0" -> screen.setText(screen.getText() + "0");
            case "1" -> screen.setText(screen.getText() + "1");
            case "2" -> screen.setText(screen.getText() + "2");
            case "3" -> screen.setText(screen.getText() + "3");
            case "4" -> screen.setText(screen.getText() + "4");
            case "5" -> screen.setText(screen.getText() + "5");
            case "6" -> screen.setText(screen.getText() + "6");
            case "7" -> screen.setText(screen.getText() + "7");
            case "8" -> screen.setText(screen.getText() + "8");
            case "9" -> screen.setText(screen.getText() + "9");

            case "." -> {
                if (!screen.getText().contains(".")) {
                    screen.setText(screen.getText() + ".");
                }
            }

            case "+" -> {
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText());
                    operator = 1;
                    screen.setText("");
                }
            }

            case "-" -> {
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText());
                    operator = 2;
                    screen.setText("");
                }
            }

            case "x" -> {
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText());
                    operator = 3;
                    screen.setText("");
                }
            }

            case "÷" -> {
                if (!screen.getText().isEmpty()) {
                    firstNum = Double.parseDouble(screen.getText());
                    operator = 4;
                    screen.setText("");
                }
            }

            default -> {
            }
        }

        if (cmd.equalsIgnoreCase("=")) {
            if (!screen.getText().isEmpty()) {
                secondNum = Double.parseDouble(screen.getText());

                switch (operator) {
                    case 1 -> { // addition
                        screen.setText(String.valueOf(firstNum + secondNum));
                        calculatingTf.setText(firstNum + " + " + secondNum + " = " + (firstNum + secondNum));
                    }
                    case 2 -> { // subtraction
                        screen.setText(String.valueOf(firstNum - secondNum));
                        calculatingTf.setText(firstNum + " - " + secondNum + " = " + (firstNum - secondNum));
                    }
                    case 3 -> { // multiplication
                        screen.setText(String.valueOf(firstNum * secondNum));
                        calculatingTf.setText(firstNum + " x " + secondNum + " = " + (firstNum * secondNum));
                    }
                    case 4 -> { // division
                        screen.setText(String.valueOf(firstNum / secondNum));
                        calculatingTf.setText(firstNum + " / " + secondNum + " = " + (firstNum / secondNum));
                    }
                    default -> {
                    }
                }
            }
        }
    }
}



