import javax.swing.*;

public class Withdraw {
    private JPanel panel1;
    private JTextField textField1;
    private JButton auszahlenButton;
    private JButton abbrechenButton;
    private String currentKontoNumber;

    private JFrame frame;

    private static boolean showOverlay = false;



    public Withdraw() {
        frame = new JFrame("Withdraw");
        frame.setContentPane(panel1);
        frame.pack();
        frame.setVisible(showOverlay);
        auszahlenButton.addActionListener(e -> {
            for (int i = 0; i < Main.konten.size(); i++) {
                Konto x = (Konto) Main.konten.get(i);
                if (x.getKontonummer().equals(this.currentKontoNumber)) {
                    System.out.println("Einzahlung von " + textField1.getText() + " auf " + x.getKontonummer());
                    x.abheben(Double.parseDouble(textField1.getText()));
                    System.out.println("Einzahlung erfolgreich");
                }
            }
            showOverlay = false;
            frame.setVisible(showOverlay);
        });
        abbrechenButton.addActionListener(e -> {
            showOverlay = false;
            frame.setVisible(showOverlay);
        });
    }

    public void showOverlay(String currentKontoNumber) {
        this.currentKontoNumber = currentKontoNumber;
        showOverlay = true;
        this.frame.pack();
        this.frame.setVisible(showOverlay);
    }

}

