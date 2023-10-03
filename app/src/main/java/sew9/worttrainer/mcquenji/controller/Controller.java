package sew9.worttrainer.mcquenji.controller;

import sew9.worttrainer.mcquenji.models.*;
import sew9.worttrainer.mcquenji.models.validation.*;
import sew9.worttrainer.mcquenji.view.*;

import java.net.URL;

import javax.swing.*;

public class Controller {
    private Trainer trainer;
    private View view;

    public Controller(Trainer trainer) {
        this.trainer = trainer;
        this.view = new View();

        // Attach event listeners to the View's UI components
        view.getGuessField().addActionListener(e -> handleGuess());
        view.getAddButton().addActionListener(e -> handleAddImage());
        view.getValidationAlgorithmDropdown().addActionListener(e -> handleValidationAlgorithmChange());

        loadRandomEntry();
    }

    private void loadRandomEntry() {
        WordEntry entry = trainer.getRandomEntry();
        try {
            URL url = new URL(entry.url);
            view.setImage(url);
        } catch (Exception e) {
            view.setFeedback("Error loading image.");
        }
    }

    private void handleGuess() {
        String guess = view.getGuess();
        if (trainer.guess(guess)) {
            view.setFeedback("Correct! Guess the next word.");
            loadRandomEntry();
        } else {
            view.setFeedback("Incorrect. Try again.");
        }
    }

    private void handleAddImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            String imagePath = fileChooser.getSelectedFile().getAbsolutePath();
            String word = JOptionPane.showInputDialog(view, "Enter the word associated with this image:");
            if (word != null && !word.trim().isEmpty()) {
                WordEntry newEntry = new WordEntry(word, "file://" + imagePath);
                trainer.addEntry(newEntry);
                view.setFeedback("Image added successfully!");
            } else {
                view.setFeedback("Invalid word. Image not added.");
            }
        }
    }

    private void handleValidationAlgorithmChange() {
        String selectedAlgorithm = (String) view.getValidationAlgorithmDropdown().getSelectedItem();

        if ("Case Sensitive".equals(selectedAlgorithm)) {
            trainer.setValidationAlgorithm(new CaseSensitiveValadtionAlgorithm());
        } else if ("Case Insensitive".equals(selectedAlgorithm)) {
            trainer.setValidationAlgorithm(new CaseInsensitiveValidationAlgorithm());
        }
    }

    public void show() {
        view.setVisible(true);
    }
}
