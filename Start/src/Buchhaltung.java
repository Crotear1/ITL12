import javax.swing.*;
import java.sql. * ;

public class Buchhaltung {
    private JTable table1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton buchenButton;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Buchhaltung");
        frame.setContentPane(new Buchhaltung().table1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Datenbank datenbank = new Datenbank();
        datenbank.verbindeUndFühreAbfrageAus();
    }

    public void ladeTransaktionen() {
        // select all transactions and display them in the table


    }
}
