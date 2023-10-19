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
    private JLabel hangmanPicture;
    private JButton newWordButton;
    private JTextArea textArea1;
    private JLabel trys;
    private JButton wortAnzeigenButton;
    private JButton wortAusblendenButton;
    private int wrongGuesses;
    private int guessesLeft;
    private String randomWord;
    private String wordToGuess;

    public HangmanGUI() {
        getTheWord();

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWordToTable(textField1.getText());
                guessWord();
                textField1.setText("");
            }
        });

        newWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTheWord();
                textArea1.setText("");
                textField1.setText("");
            }
        });

        // function to show word
        wortAnzeigenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWord.setText(randomWord);

            }
        });

        wortAusblendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showWord.setText(wordToGuess.replaceAll(".(?!$)", "$0 "));
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
                getTheWord();
            }
        } else {
            wrongGuesses++;
            guessesLeft--;
            System.out.println("Letter is not in word");
            System.out.println("Wrong guesses: " + wrongGuesses);
            trys.setText("Guesses left: " + guessesLeft);
            // show hangman picture
            if (wrongGuesses == 1) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt1.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 2) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt2.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 3) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt3.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 4) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt4.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 5) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt5.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 6) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt6.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 7) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt7.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 8) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt8.PNG");
                hangmanPicture.setIcon(hangmanIcon);
            } else if (wrongGuesses == 9) {
                ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/Unbenannt9.PNG");
                hangmanPicture.setIcon(hangmanIcon);
                // show full word
                showWord.setText(randomWord);
                System.out.println("You've lost.");
            }
        }
    }

    public void getTheWord() {
        // show hangman picture
        ImageIcon hangmanIcon = new ImageIcon("C:/Users/Kevin/Documents/GitHub/ITL12/Start/src/utilities/start.PNG");
        hangmanPicture.setIcon(hangmanIcon);

        wrongGuesses = 0;
        guessesLeft = 9;
        trys.setText("Guesses left: " + guessesLeft);

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
    }
    public void addWordToTable(String word) {
        // add letter to table
        textArea1.append("Last Word: " + word + "\n");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("HangmanGUI");
        frame.setContentPane(new HangmanGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}