import javax.swing.*;
import java.util.Objects;

public class transfer {
    private JComboBox comboBox1;
    private JTextField textField1;
    private JComboBox comboBox2;
    private JPanel panel1;
    private JButton überweisenButton;
    private JButton abbrechenButton;

    private JFrame frame;

    private static boolean showOverlay = false;


    public transfer() {
        frame = new JFrame("Deposit");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(showOverlay);

        for (int i = 0; i < Main.konten.size(); i++) {
            Konto konto = (Konto) Main.konten.get(i);
            this.comboBox1.addItem(konto.getKontoinhaber() + " " + konto.getKontonummer());
        }
        for (int i = 0; i < Main.konten.size(); i++) {
            Konto konto = (Konto) Main.konten.get(i);
            this.comboBox2.addItem(konto.getKontoinhaber() + " " + konto.getKontonummer());
        }
        überweisenButton.addActionListener(e -> {
            String[] parts = ((String) this.comboBox1.getSelectedItem()).split(" ");
            String name = parts[0];
            String number = parts[parts.length - 1];
            String[] parts2 = ((String) this.comboBox2.getSelectedItem()).split(" ");
            String name2 = parts2[0];
            String number2 = parts2[parts2.length - 1];
            for (int i = 0; i < Main.konten.size(); i++) {
                Konto x = (Konto) Main.konten.get(i);
                if (x.getKontonummer().equals(number)) {
                    for (int j = 0; j < Main.konten.size(); j++) {
                        Konto y = (Konto) Main.konten.get(j);
                        if (y.getKontonummer().equals(number2)) {
                            System.out.println("Überweisung von " + x.getKontonummer() + " auf " + y.getKontonummer());
                            x.überweisen(Double.parseDouble(textField1.getText()), y);
                            System.out.println("Überweisung erfolgreich");
                        }
                    }
                }
            }
        });
        abbrechenButton.addActionListener(e -> {
            showOverlay = false;
        });
    }

    public void showOverlay() {
        showOverlay = true;
        this.frame.pack();
        this.frame.setVisible(showOverlay);
    }
}
