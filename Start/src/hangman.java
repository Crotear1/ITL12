import javax.swing.*;

public class hangman {
    private JTextField textField1;
    private JPanel panel1;
    private JLabel hangmanLabel; // JLabel, um das Bild anzuzeigen

    String bildDatei = "./pictures/hangman.PNG"; // Passe den Pfad zur Bilddatei an

    public hangman() {
        ImageIcon icon = new ImageIcon(bildDatei);
        hangmanLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Hangman");
            frame.setContentPane(new hangman().panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
