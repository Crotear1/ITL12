package test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Bruchrechner {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JButton button1;
    private JTextField textField5;
    private JTextField textField6;

    public Bruchrechner() {
        this.comboBox1.addItem("+");
        this.comboBox1.addItem("-");
        this.comboBox1.addItem("/");
        this.comboBox1.addItem("*");

        this.button1.addActionListener(e -> {
            if ((!Objects.equals(String.valueOf(this.textField1.getText()), "0")
                    && this.textField1.getText().length() > 0)
                    && (!Objects.equals(String.valueOf(this.textField2.getText()), "0")
                    && (this.textField2.getText().length() > 0)
                    && (!Objects.equals(String.valueOf(this.textField3.getText()), "0")
                    && this.textField3.getText().length() > 0)
                    && (!Objects.equals(String.valueOf(this.textField4.getText()), "0")
                    && this.textField4.getText().length() > 0))
                    && this.comboBox1.getSelectedItem() != null) {
                System.out.println((String) this.comboBox1.getSelectedItem());
                switch ((String) this.comboBox1.getSelectedItem()) {
                    case "+":
                        try {
                            Bruch bruch = new Bruch(Integer.parseInt(this.textField1.getText()), Integer.parseInt(this.textField2.getText()));
                            Bruch bruch2 = new Bruch(Integer.parseInt(this.textField3.getText()), Integer.parseInt(this.textField4.getText()));

                            ArrayList ergebnis = bruch.addiere(bruch2);

                            this.textField5.setText(ergebnis.get(0).toString());
                            this.textField6.setText(ergebnis.get(1).toString());
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(this.panel1, "Die Eingabe müssen Zahlen sein");
                        }
                        break;
                    case "-":
                        try {
                            Bruch bruch = new Bruch(Integer.parseInt(this.textField1.getText()), Integer.parseInt(this.textField2.getText()));
                            Bruch bruch2 = new Bruch(Integer.parseInt(this.textField3.getText()), Integer.parseInt(this.textField4.getText()));

                            ArrayList ergebnis = bruch.subtrahiere(bruch2);
                            this.textField5.setText(ergebnis.get(0).toString());
                            this.textField6.setText(ergebnis.get(1).toString());
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(this.panel1, "Die Eingabe müssen Zahlen sein");
                        }
                        break;
                    case "/":
                        try {
                            Bruch bruch = new Bruch(Integer.parseInt(this.textField1.getText()), Integer.parseInt(this.textField2.getText()));
                            Bruch bruch2 = new Bruch(Integer.parseInt(this.textField3.getText()), Integer.parseInt(this.textField4.getText()));

                            ArrayList ergebnis = bruch.dividiere(bruch2);

                            this.textField5.setText(ergebnis.get(0).toString());
                            this.textField6.setText(ergebnis.get(1).toString());
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(this.panel1, "Die Eingabe müssen Zahlen sein");
                        }
                        break;
                    case "*":
                        try {
                            Bruch bruch = new Bruch(Integer.parseInt(this.textField1.getText()), Integer.parseInt(this.textField2.getText()));
                            Bruch bruch2 = new Bruch(Integer.parseInt(this.textField3.getText()), Integer.parseInt(this.textField4.getText()));

                            ArrayList ergebnis = bruch.multipliziere(bruch2);

                            this.textField5.setText(ergebnis.get(0).toString());
                            this.textField6.setText(ergebnis.get(1).toString());
                        } catch (Exception e1) {
                            JOptionPane.showMessageDialog(this.panel1, "Die Eingabe müssen Zahlen sein");

                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(this.panel1, "Falsche Operation");
                }
            } else {
                JOptionPane.showMessageDialog(this.panel1, "Alle Felder müssen belegt und dürfen nicht 0 sein!");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bruchrechner");
        frame.setContentPane(new Bruchrechner().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
