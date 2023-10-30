import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql. * ;
import java.util.ArrayList;

public class Buchhaltung {
    private JTable table1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton buchenButton;
    private JList list1;

    private DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<String> tableData;

    public Buchhaltung(){
        buchenButton.addActionListener(e -> {
            // get the values from the text fields
            // create a new transaction object
            // save the transaction to the database
            // update the table
            ladeTransaktionen();
        });

        table1.setModel(tableModel);
        tableModel.addColumn("TransaktionsID");
        tableModel.addColumn("Betrag");
        tableModel.addColumn("Datum");
        tableModel.addColumn("Kategorie");
        tableModel.addColumn("Beschreibung");
    }

    public static void main(String[] args) {
        Buchhaltung buchhaltung = new Buchhaltung();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Buchhaltung");
            frame.setContentPane(buchhaltung.table1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });

        Datenbank datenbank = new Datenbank();
        datenbank.verbindeDatenbank();
        buchhaltung.ladeTransaktionen();
    }

    public void ladeTransaktionen() {
        // get all data from the database and put it into the table
        Datenbank datenbank = new Datenbank();
        this.tableData = datenbank.getTransaktionen();
        tableModel.addRow(this.tableData.toArray());

    }

}
