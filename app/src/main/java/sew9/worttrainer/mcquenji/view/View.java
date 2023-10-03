package sew9.worttrainer.mcquenji.view;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * The View for the Word Trainer application.
 * 
 * 
 * @author Benjamin McEachnie
 * @version 2023-10-03
 * 
 * @see sew9.worttrainer.mcquenji.controller.Controller
 */
public class View extends JFrame {
    JLabel imageLabel;
    JTextField guessField;
    JButton loadButton;
    JButton saveButton;
    JButton addButton;
    JLabel feedbackLabel;
    JComboBox<String> validationAlgorithmDropdown;
    JLabel totalGuessesLabel;
    JLabel correctGuessesLabel;
    JLabel incorrectGuessesLabel;

    public View() {

        setTitle("Word Trainer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Image in the center
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        // Text bar at the bottom
        guessField = new JTextField();
        add(guessField, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        // Feedback label
        feedbackLabel = new JLabel("Guess the word for the image!");
        northPanel.add(feedbackLabel, BorderLayout.NORTH);

        // Load, Save, and Add buttons
        JPanel menuPanel = new JPanel();
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        addButton = new JButton("Add Image");

        // Dropdown for validation algorithm
        String[] algorithms = { "Case Sensitive", "Case Insensitive" };
        validationAlgorithmDropdown = new JComboBox<>(algorithms);

        menuPanel.add(validationAlgorithmDropdown);
        menuPanel.add(loadButton);
        menuPanel.add(saveButton);
        menuPanel.add(addButton);

        northPanel.add(menuPanel);

        // Guess statistics

        JPanel statisticsPanel = new JPanel();

        totalGuessesLabel = new JLabel("Total Guesses: 0");
        correctGuessesLabel = new JLabel("Correct Guesses: 0");
        incorrectGuessesLabel = new JLabel("Incorrect Guesses: 0");

        statisticsPanel.add(totalGuessesLabel);
        statisticsPanel.add(correctGuessesLabel);
        statisticsPanel.add(incorrectGuessesLabel);

        northPanel.add(statisticsPanel);

        add(northPanel, BorderLayout.NORTH);
    }

    public JTextField getGuessField() {
        return guessField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public String getGuess() {
        return guessField.getText();
    }

    public JComboBox<String> getValidationAlgorithmDropdown() {
        return validationAlgorithmDropdown;
    }

    public void setImage(URL imageUrl) throws IOException {
        BufferedImage image = ImageIO.read(imageUrl);
        ImageIcon icon = new ImageIcon(image);
        imageLabel.setIcon(icon);
    }

    public void setFeedback(String feedback) {
        feedbackLabel.setText(feedback);
    }

    public void setTotalGuesses(int totalGuesses) {
        totalGuessesLabel.setText("Total Guesses: " + totalGuesses);
    }

    public void setCorrectGuesses(int correctGuesses) {
        correctGuessesLabel.setText("Correct Guesses: " + correctGuesses);
    }

    public void setIncorrectGuesses(int incorrectGuesses) {
        incorrectGuessesLabel.setText("Incorrect Guesses: " + incorrectGuesses);
    }

    public void clearGuessField() {
        guessField.setText("");
    }
}
