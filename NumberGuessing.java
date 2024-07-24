import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessing {
    private JButton guessButton;
    private JButton restartButton;
    private JTextField myNumber;
    private JLabel message;
    private JPanel myPanel;
    private JLabel feedbackLabel;
    private JLabel titleLabel;
    private JLabel guessLabel;
    private JLabel scoreLabel;
    private JLabel attemptsLabel;
    private int targetNumber;
    private int score;
    private int attemptsLeft;

    public NumberGuessing() {
        // Initialize components with custom styles
        myPanel = new JPanel();
        myPanel.setLayout(new GridBagLayout());
        myPanel.setBackground(new Color(70, 130, 180)); // Steel blue background

        titleLabel = new JLabel("Number Guessing Game");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        guessLabel = new JLabel("Enter your guess (1-100):");
        guessLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        guessLabel.setForeground(Color.WHITE);

        myNumber = new JTextField(10);
        myNumber.setFont(new Font("Arial", Font.PLAIN, 18));
        myNumber.setHorizontalAlignment(SwingConstants.CENTER);

        guessButton = new JButton("Guess");
        guessButton.setFont(new Font("Arial", Font.BOLD, 18));
        guessButton.setBackground(new Color(30, 144, 255)); // Dodger blue
        guessButton.setForeground(Color.WHITE);

        restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.BOLD, 18));
        restartButton.setBackground(new Color(60, 179, 113)); // Medium sea green
        restartButton.setForeground(Color.WHITE);
        restartButton.setEnabled(false); // Disable restart button initially

        message = new JLabel();
        message.setFont(new Font("Arial", Font.PLAIN, 18));
        message.setForeground(Color.WHITE);

        feedbackLabel = new JLabel();
        feedbackLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        feedbackLabel.setForeground(Color.YELLOW);

        scoreLabel = new JLabel("Score: 0/10");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 18));
        scoreLabel.setForeground(Color.WHITE);

        attemptsLabel = new JLabel("Attempts Left: 10");
        attemptsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        attemptsLabel.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        myPanel.add(titleLabel, gbc);

        gbc.gridy++;
        gbc.gridwidth = 1;
        myPanel.add(guessLabel, gbc);

        gbc.gridx = 1;
        myPanel.add(myNumber, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        myPanel.add(guessButton, gbc);

        gbc.gridy++;
        myPanel.add(message, gbc);

        gbc.gridy++;
        myPanel.add(feedbackLabel, gbc);

        gbc.gridy++;
        myPanel.add(scoreLabel, gbc);

        gbc.gridy++;
        myPanel.add(attemptsLabel, gbc);

        gbc.gridy++;
        myPanel.add(restartButton, gbc);

        // Generate the target number and reset attempts
        resetGame();

        // Add action listener to the guess button
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (attemptsLeft > 0) {
                    try {
                        int myno = Integer.parseInt(myNumber.getText().trim());

                        if (myno < 1 || myno > 100) {
                            feedbackLabel.setText("Please enter a number between 1 and 100.");
                        } else {
                            attemptsLeft--;
                            attemptsLabel.setText("Attempts Left: " + attemptsLeft);

                            if (myno == targetNumber) {
                                score = attemptsLeft + 1; // Calculate score based on remaining attempts
                                message.setText("You guessed the correct number!");
                                feedbackLabel.setText("Congratulations! The number was " + targetNumber + ".");
                                scoreLabel.setText("Score: " + score + "/10");
                                endGame();
                            } else if (myno > targetNumber) {
                                message.setText("Number guessed is higher.");
                                feedbackLabel.setText("Try again!");
                            } else {
                                message.setText("Number guessed is lower.");
                                feedbackLabel.setText("Try again!");
                            }

                            if (attemptsLeft == 0) {
                                message.setText("Game Over! You've used all your attempts.");
                                feedbackLabel.setText("The number was " + targetNumber + ".");
                                scoreLabel.setText("Score: " + score + "/10");
                                endGame();
                            }
                        }
                    } catch (NumberFormatException ex) {
                        feedbackLabel.setText("Please enter a valid number!");
                    }
                }
                myNumber.setText(""); // Clear input field after each guess
            }
        });

        // Add action listener to the restart button
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    private void resetGame() {
        targetNumber = generateRandomNumber();
        attemptsLeft = 10;
        score = 0;
        message.setText("");
        feedbackLabel.setText("");
        scoreLabel.setText("Score: 0/10");
        attemptsLabel.setText("Attempts Left: 10");
        guessButton.setEnabled(true);
        restartButton.setEnabled(false);
    }

    private void endGame() {
        guessButton.setEnabled(false); // Disable the guess button
        restartButton.setEnabled(true); // Enable the restart button
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Guessing Game");
        frame.setContentPane(new NumberGuessing().myPanel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
