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

    private JList list1;

    private DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<String> tableData;

    public Buchhaltung(){
        buchenButton.addActionListener(e -> {
            // get the values from the text fields
            // create a new transaction object
            // save the transaction to the database
            // update the table

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            LocalDate parsedDate = LocalDate.parse(datum.getText(), formatter);

            Datenbank datenbank = new Datenbank();
            if (comboBox1.getSelectedItem().toString().equals("Einnahme"))
                datenbank.transaktionSpeichern(Integer.parseInt(betrag.getText()), parsedDate , art.getText(), true);
            else if (comboBox1.getSelectedItem().toString().equals("Ausgabe")) {
                datenbank.transaktionSpeichern(Integer.parseInt(betrag.getText()), parsedDate , art.getText(), false);
            }

            ladeTransaktionen();
        });


        table1.setModel(tableModel);
        tableModel.addColumn("TransaktionsID");
        tableModel.addColumn("Betrag");
        tableModel.addColumn("Datum");
        tableModel.addColumn("Kategorie");
        tableModel.addColumn("Beschreibung");
        tableModel.addColumn("PlusMinus");
        comboBox1.addItem("Einnahme");
        comboBox1.addItem("Ausgabe");
    }

    public static void main(String[] args) {
        Buchhaltung buchhaltung = new Buchhaltung();
        JFrame frame = new JFrame("Buchhaltung GUI");

        // Create a new JPanel to hold both table1 and panel1
        JPanel combinedPanel = new JPanel(new BorderLayout());

        // Add table1 and panel1 to the combinedPanel
        combinedPanel.add(buchhaltung.table1, BorderLayout.NORTH);
        combinedPanel.add(new Buchhaltung().panel1, BorderLayout.CENTER);

        // Set the combinedPanel as the content pane
        frame.setContentPane(combinedPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Datenbank datenbank = new Datenbank();
        datenbank.verbindeDatenbank();
        buchhaltung.ladeTransaktionen();

    }

    public void ladeTransaktionen() {
        // get all data from the database and put it into the table
        Datenbank datenbank = new Datenbank();

        // clear table


        this.tableData = datenbank.getTransaktionen();
        tableModel.addRow(this.tableData.toArray());

    }

}
