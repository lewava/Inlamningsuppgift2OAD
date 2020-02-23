package Uppgift_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class CalculatorController extends Observable implements ActionListener {

    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonAddition;
    private JButton buttonSubtraction;
    private JButton buttonMultiplication;
    private JButton buttonDivision;
    private JButton buttonEquality;
    private JButton buttonComma;
    private JButton buttonClear;
    private JTextArea textArea;
    private String mathExpression;
    private String answer;
    private BeingObserved beingObserved = new BeingObserved();
    private Uppgift_2.Observable observable = new Uppgift_2.Observable();

    public CalculatorController(JButton button0, JButton button1, JButton button2, JButton button3, JButton button4,
                                JButton button5, JButton button6, JButton button7, JButton button8, JButton button9,
                                JButton buttonAddition, JButton buttonSubtraction, JButton buttonMultiplication,
                                JButton buttonDivision, JButton buttonEquality, JButton buttonComma,
                                JButton buttonClear, JTextArea textArea) {

        this.button0 = button0;
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.button5 = button5;
        this.button6 = button6;
        this.button7 = button7;
        this.button8 = button8;
        this.button9 = button9;
        this.buttonAddition = buttonAddition;
        this.buttonSubtraction = buttonSubtraction;
        this.buttonMultiplication = buttonMultiplication;
        this.buttonDivision = buttonDivision;
        this.buttonEquality = buttonEquality;
        this.buttonComma = buttonComma;
        this.buttonClear = buttonClear;
        this.textArea = textArea;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button0) {
            textArea.append("0");

        } else if (e.getSource() == button1) {
            textArea.append("1");

        } else if (e.getSource() == button2) {
            textArea.append("2");

        } else if (e.getSource() == button3) {
            textArea.append("3");

        } else if (e.getSource() == button4) {
            textArea.append("4");

        } else if (e.getSource() == button5) {
            textArea.append("5");

        } else if (e.getSource() == button6) {
            textArea.append("6");

        } else if (e.getSource() == button7) {
            textArea.append("7");

        } else if (e.getSource() == button8) {
            textArea.append("8");

        } else if (e.getSource() == button9) {
            textArea.append("9");

        } else if (e.getSource() == buttonAddition) {
            textArea.append("+");

        } else if (e.getSource() == buttonSubtraction) {
            textArea.append("-");

        } else if (e.getSource() == buttonMultiplication) {
            textArea.append("*");

        } else if (e.getSource() == buttonDivision) {
            textArea.append("/");

        } else if (e.getSource() == buttonComma) {
            textArea.append(".");

        } else if (e.getSource() == buttonClear) {
            textArea.setText("");

        } else if (e.getSource() == buttonEquality) {
            beingObserved.addObserver(observable);
            beingObserved.observer();
            try {
                mathExpression = textArea.getText();
                double temp = readStringMathExpression(mathExpression);
                answer = Double.toString(temp);
                textArea.setText(answer);
            } catch (Exception ex) {
                textArea.setFont(new Font("Serif", Font.BOLD, 18));
                textArea.setText("Du måste ange ett matematiskt uttryck.");
            }
        }
    }

    /*
    Klassen readStringExpression är tagen ifrån Stackoverflow då jag inte kunde hitta något enkelt sätt att
    räkna ut ett matematiskt uttryck ifrån en String.
     */

    public double readStringMathExpression(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }

    public static class BeingObserved extends Observable {
        void observer() {
            setChanged();
            notifyObservers();

        }
    }
}
