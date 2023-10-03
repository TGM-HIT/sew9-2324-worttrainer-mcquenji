package sew9.worttrainer.mcquenji.view;

import javax.swing.*;

import java.awt.*;
import java.net.URL;

public class View extends JFrame {
    JLabel imageLabel;
    JTextField guessField;
    JButton loadButton;
    JButton saveButton;
    JButton addButton;
    JLabel feedbackLabel;
    JComboBox<String> validationAlgorithmDropdown;

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

        // Feedback label
        feedbackLabel = new JLabel("Guess the word for the image!");
        add(feedbackLabel, BorderLayout.NORTH);

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

        add(menuPanel, BorderLayout.WEST);
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

    public void setImage(URL imageUrl) {
        ImageIcon icon = new ImageIcon(imageUrl);
        imageLabel.setIcon(icon);
    }

    public void setFeedback(String feedback) {
        feedbackLabel.setText(feedback);
    }
}
