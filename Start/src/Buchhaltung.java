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
    private JPanel panel1;
    private JList list1;

    private DefaultTableModel tableModel = new DefaultTableModel();
    private ArrayList<String> tableData;

    public Buchhaltung(){
        buchenButton.addActionListener(e -> {
            // get the values from the text fields
            // create a new transaction object
            // save the transaction to the database
            // update the table
            Datenbank datenbank = new Datenbank();
            datenbank.transaktionSpeichern(Integer.parseInt(textField4.getText()), null, textField5.getText(), Boolean.parseBoolean(textField6.getText()));

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
        JFrame frame = new JFrame("HangmanGUI");

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
        this.tableData = datenbank.getTransaktionen();
        tableModel.addRow(this.tableData.toArray());

    }

}
