import javax.swing.*;
import java.util.Objects;

public class Overview {
    private JPanel panel1;
    private JTextField textfield1;
    private JComboBox<String> comboBox1;
    private JButton createButton;
    private JTextField textField2;
    private JComboBox comboBox2;

    private JTextArea textArea1;
    private JButton einzahlenButton;
    private JButton auszahlenButton;
    private JButton überweisenButton;
    private Konto currentKonto;

    public Overview() {
        this.comboBox1.addItem("Girokonto");
        this.comboBox1.addItem("Sparkonto");
        this.comboBox1.addItem("Kreditkonto");

        this.createButton.addActionListener(e -> {
            String type = (String) this.comboBox1.getSelectedItem();
            String name = this.textfield1.getText();
            double balance = Double.parseDouble(this.textField2.getText());
            Konto konto = new Konto(this.textfield1.getText(), 200,
                    balance, (String) comboBox1.getSelectedItem());
            Main.konten.add(konto);
            switch (type) {
                case "Girokonto":
                    konto.setGirokontos(new Girokonto(this.textfield1.getText(), 200,
                            balance, (String) comboBox1.getSelectedItem(), konto));
                    System.out.println("OMG Das konto wurde erstell sees");
                    this.textfield1.setText("");
                    this.textField2.setText("");
                    this.comboBox2.addItem(konto.getKontoinhaber()+" "+konto.getKontonummer());
                    break;
                case "Sparkonto":
                    konto.setSparkontos(new Sparkonto(this.textfield1.getText(), 200,
                            balance, (String) comboBox1.getSelectedItem(), konto));
                    System.out.println("OMG Das konto wurde erstell sees");
                    this.textfield1.setText("");
                    this.textField2.setText("");
                    this.comboBox2.addItem(konto.getKontoinhaber()+" "+konto.getKontonummer());
                    break;
                case "Kreditkonto":
                    konto.setKreditkontos(new Kreditkonto(this.textfield1.getText(), 200,
                            balance, (String) comboBox1.getSelectedItem(), konto));
                    System.out.println("OMG Das konto wurde erstell sees");
                    this.textfield1.setText("");
                    this.textField2.setText("");
                    this.comboBox2.addItem(konto.getKontoinhaber()+" "+konto.getKontonummer());
                    break;
            }
        });
        this.comboBox2.addItemListener(e -> {
            String[] parts = ((String) this.comboBox2.getSelectedItem()).split(" ");
            String name = parts[0];
            String  number = parts[parts.length -1];
            for (int i = 0; i < Main.konten.size(); i++) {
                Konto x = (Konto) Main.konten.get(i);
                this.currentKonto = x;
                if (Objects.equals(x.getKontonummer(), number)) {
                    this.textArea1.setText(x.kontoauszug());
                }
            }
        });
        this.einzahlenButton.addActionListener(e -> {
            Deposit deposit = new Deposit();
            deposit.showOverlay(this.currentKonto.getKontonummer());
        });
        this.auszahlenButton.addActionListener(e -> {
            Withdraw withdraw = new Withdraw();
            withdraw.showOverlay(this.currentKonto.getKontonummer());
        });
        this.überweisenButton.addActionListener(e -> {
            transfer transfer = new transfer();
            transfer.showOverlay();
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Overview");
        frame.setContentPane(new Overview().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
