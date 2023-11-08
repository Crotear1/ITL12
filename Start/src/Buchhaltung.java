import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Buchhaltung {
    private JTable table1;
    private JTextField betrag;
    private JTextField art;
    private JTextField datum;
    private JButton buchenButton;
    private JPanel panel1;
    private JComboBox comboBox1;

    private DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<String> tableData;
    private Datenbank datenbank;

    public Buchhaltung() {
        table1.setModel(tableModel);
        tableModel.addColumn("TransaktionsID");
        tableModel.addColumn("Betrag");
        tableModel.addColumn("Datum");
        tableModel.addColumn("Kategorie");
        comboBox1.addItem("Einnahme");
        comboBox1.addItem("Ausgabe");

        buchenButton.addActionListener(e -> {
            if (betrag.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Betrag ein.");
                return;
            }
            if (art.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Art ein.");
                return;
            }
            if (datum.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein Datum ein.");
                return;
            }
            try {
                Integer.parseInt(betrag.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine richtige Zahl beim Betrag ein");
                return;
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate parsedDate = LocalDate.parse(datum.getText(), formatter);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein gültiges Datum ein.");
                return;
            }


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDate parsedDate = LocalDate.parse(datum.getText(), formatter);

            Datenbank datenbank = new Datenbank();
            if (comboBox1.getSelectedItem().toString().equals("Einnahme"))
                datenbank.transaktionSpeichern(Integer.parseInt(betrag.getText()), parsedDate, art.getText(), true);
            else if (comboBox1.getSelectedItem().toString().equals("Ausgabe")) {
                datenbank.transaktionSpeichern(Integer.parseInt(betrag.getText()), parsedDate, art.getText(), false);
            }

            // Reset fields
            betrag.setText("");
            art.setText("");
            datum.setText("");
            ladeTransaktionen();
        });
        this.datenbank = new Datenbank();
        this.datenbank.verbindeDatenbank();

        ladeTransaktionen();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Buchhaltung GUI");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new Buchhaltung().panel1);
            frame.pack();
            frame.setVisible(true);
        });
    }

    public void ladeTransaktionen() {
        tableModel.setRowCount(0);
        tableData = datenbank.getTransaktionen();
        tableModel.addRow(new String[]{"TransaktionsID", "Betrag", "Datum", "Kategorie"});
        for (String transaktion : tableData) {
            String[] split = transaktion.split(",");
            tableModel.addRow(split);
        }
    }

}
