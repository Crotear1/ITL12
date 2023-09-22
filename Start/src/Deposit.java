import javax.swing.*;

public class Deposit {
    private JPanel panel1;
    private JTextField textField1;
    private JButton auszahlenButton;
    private JButton abbrechenButton;
    private String currentKontoNumber;

    private JFrame frame; // Hinzufügen dieser Zeile

    private static boolean showOverlay = false;



    public Deposit() {
        frame = new JFrame("Deposit"); // Initialisieren Sie das JFrame hier
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(showOverlay);
        auszahlenButton.addActionListener(e -> {
            for (int i = 0; i < Main.konten.size(); i++) {
                Konto x = (Konto) Main.konten.get(i);
                if (x.getKontonummer().equals(this.currentKontoNumber)) {
                    System.out.println("Einzahlung von " + textField1.getText() + " auf " + x.getKontonummer());
                    x.einzahlen(Double.parseDouble(textField1.getText()));
                    System.out.println("Einzahlung erfolgreich");
                }
            }
        });
        abbrechenButton.addActionListener(e -> {
            showOverlay = false;
        });
    }

    public void showOverlay(String currentKontoNumber) {
        this.currentKontoNumber = currentKontoNumber;
        showOverlay = true;
        this.frame.pack();
        this.frame.setVisible(showOverlay);
    }

}
