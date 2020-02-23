package Uppgift_2;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {

    private JPanel panel = new JPanel();
    private JPanel panelButtons = new JPanel();
    private JPanel textPanel = new JPanel();
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton buttonAddition = new JButton("+");
    private JButton buttonSubtraction = new JButton("-");
    private JButton buttonMultiplication = new JButton("x");
    private JButton buttonDivision = new JButton("/");
    private JButton buttonEquality = new JButton("=");
    private JButton buttonComma = new JButton(".");
    private JButton buttonClear = new JButton("C");
    private JTextArea textArea = new JTextArea();
    private CalculatorController model = new CalculatorController(
            button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9,
            buttonAddition, buttonSubtraction, buttonMultiplication,
            buttonDivision, buttonEquality, buttonComma, buttonClear, textArea);

    public CalculatorView() {
        this.setSize(350, 420);
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        panel.setLayout(new BorderLayout());
        add(panelButtons, BorderLayout.CENTER);
        add(buttonClear, BorderLayout.SOUTH);
        add(textPanel, BorderLayout.NORTH);
        textPanel.setPreferredSize(new Dimension(50, 60));
        buttonClear.setForeground(Color.RED);
        textPanel.add(textArea);
        textArea.setFont(new Font("Serif", Font.BOLD, 35));
        textArea.setEditable(false);
        textArea.setBackground(null);
        panelButtons.setLayout(new GridLayout(4, 4));
        add(panelButtons);
        panelButtons.add(button7);
        panelButtons.add(button8);
        panelButtons.add(button9);
        panelButtons.add(buttonMultiplication);
        panelButtons.add(button4);
        panelButtons.add(button5);
        panelButtons.add(button6);
        panelButtons.add(buttonSubtraction);
        panelButtons.add(button1);
        panelButtons.add(button2);
        panelButtons.add(button3);
        panelButtons.add(buttonAddition);
        panelButtons.add(buttonDivision);
        panelButtons.add(button0);
        panelButtons.add(buttonComma);
        panelButtons.add(buttonEquality);
        this.setVisible(true);

        button0.addActionListener(model);
        button1.addActionListener(model);
        button2.addActionListener(model);
        button3.addActionListener(model);
        button4.addActionListener(model);
        button5.addActionListener(model);
        button6.addActionListener(model);
        button7.addActionListener(model);
        button8.addActionListener(model);
        button9.addActionListener(model);
        buttonAddition.addActionListener(model);
        buttonSubtraction.addActionListener(model);
        buttonMultiplication.addActionListener(model);
        buttonDivision.addActionListener(model);
        buttonEquality.addActionListener(model);
        buttonComma.addActionListener(model);
        buttonClear.addActionListener(model);

    }
}
