import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class HangmanGUI {

    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JLabel showWord;
    private String randomWord;
    private String wordToGuess;

    public HangmanGUI() {
        //Reading the file
        String fileName = "C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/words.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String> words = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split(" ");

                for (String word : lineWords) {
                    words.add(word);
                }
            }

            // get random word
            int randomIndex = (int) (Math.random() * words.size());
            this.randomWord = words.get(randomIndex);
            this.wordToGuess = "_".repeat(randomWord.length());
            System.out.println(randomWord);

            // show word to guess with underlines + spaces between letters
            for (int i = 0; i < randomWord.length(); i++) {
                wordToGuess = wordToGuess.substring(0, i) + "_" + wordToGuess.substring(i + 1);
            }
            showWord.setText(wordToGuess.replaceAll(".(?!$)", "$0 "));

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guessWord();
                textField1.setText("");
            }
        });
    }

    public void guessWord() {
        String letter = textField1.getText();
        // check if letter is in word
        if (randomWord.contains(letter)) {
            System.out.println("Letter is in word");
            StringBuilder wordDisplay = new StringBuilder(wordToGuess);
            // set shown word with underlines
            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == letter.charAt(0)) {
                    wordDisplay.setCharAt(i, letter.charAt(0));
                    // show word to guess with underlines + spaces between letters
                    wordToGuess = wordDisplay.toString();
                    showWord.setText(wordToGuess.replaceAll(".(?!$)", "$0 "));

                }
            }
            System.out.println("Letter is in word: " + wordToGuess);
            wordToGuess = wordDisplay.toString();
            System.out.println("Letter is in word: " + wordToGuess);

            if (wordToGuess.equals(randomWord)) {
                System.out.println("Congratulations! You've won.");
            }
        } else {
            System.out.println("Letter is not in word");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HangmanGUI");
        frame.setContentPane(new HangmanGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}