import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    private JButton searchButton;

    private JTextField searchField;
    private JButton resetButtonButton;
    private JTextField change1;
    private JButton ändernButton;
    private JComboBox comboid;
    private JButton deleteButton;

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

        searchButton.addActionListener( e -> {
            tableModel.setRowCount(0);
            //format date to correct format + error handling
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate parsedDate = LocalDate.parse(searchField.getText(), formatter);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie ein gültiges Datum ein.");
                return;
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate parsedDate = LocalDate.parse(searchField.getText(), formatter);
            System.out.println(parsedDate);


            tableData = datenbank.getTransaktionenWithDate(parsedDate);
            tableModel.addRow(new String[]{"TransaktionsID", "Betrag", "Datum", "Kategorie"});
            for (String transaktion : tableData) {
                String[] split = transaktion.split(",");
                tableModel.addRow(split);
            }
        });

        resetButtonButton.addActionListener(e -> {
            ladeTransaktionen();
        });

        comboid.addActionListener(e -> {
            int id = (int) comboid.getSelectedItem();
            change1.setText(datenbank.getBetrag(id)+"");
        });

        ändernButton.addActionListener(e -> {
            if (change1.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie einen Betrag ein.");
                return;
            }
            try {
                Integer.parseInt(change1.getText());
            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(null, "Bitte geben Sie eine richtige Zahl beim Betrag ein");
                return;
            }
            int id = (int) comboid.getSelectedItem();
            datenbank.updateBetrag(id, Integer.parseInt(change1.getText()));
            System.out.println("clicked");
            ladeTransaktionen();
            ladeComboBox();
        });

        deleteButton.addActionListener(e -> {
            int id = (int) comboid.getSelectedItem();
            datenbank.deleteTransaktion(id);
            ladeTransaktionen();
            ladeComboBox();
        });

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
        ladeComboBox();
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

    public void ladeComboBox() {
        ArrayList<Integer> ids = datenbank.getIds();
        for (int id : ids) {
            comboid.addItem(id);
            System.out.println(id);
        }

    }

}
