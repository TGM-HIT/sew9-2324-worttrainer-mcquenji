package sew9.worttrainer.mcquenji.controller;

import sew9.worttrainer.mcquenji.models.*;
import sew9.worttrainer.mcquenji.models.validation.*;
import sew9.worttrainer.mcquenji.serde.ISerde;
import sew9.worttrainer.mcquenji.view.*;

import java.io.File;

import javax.swing.*;

/**
 * Controller for the {@link View} and {@link Trainer}.
 * 
 * This class is responsible for handling events from the View and updating the
 * View and Trainer accordingly.
 * 
 * @author Benjamin McEachnie
 * @version 2023-10-03
 */
public class Controller {
    private Trainer trainer;
    private View view;

    /**
     * The name of the save file.
     */
    public static final String SAVE_FILE = "save.wts";

    public Controller(Trainer trainer) {
        this.trainer = trainer;
        this.view = new View();

        // Attach event listeners to the View's UI components
        view.getGuessField().addActionListener(e -> handleGuess());
        view.getAddButton().addActionListener(e -> handleAddImage());
        view.getValidationAlgorithmDropdown().addActionListener(e -> handleValidationAlgorithmChange());
        view.getSaveButton().addActionListener(e -> handleSave());
        view.getLoadButton().addActionListener(e -> handleLoad());

        if (trainer.getCurrentEntry() == null) {
            loadRandomEntry();
        } else {
            updateUI();
        }
    }

    private void updateUI() {
        view.setTotalGuesses(trainer.getTotalGuesses());
        view.setCorrectGuesses(trainer.getCorrectGuesses());
        view.setIncorrectGuesses(trainer.getIncorrectGuesses());

        try {
            view.setImage(trainer.getCurrentEntry().getUrl());
        } catch (Exception e) {
            view.setFeedback("Error loading image.");
            System.out.println("Error while loading image: " + e);
        }
    }

    private void loadRandomEntry() {
        updateUI();

        view.clearGuessField();
    }

    private void handleGuess() {
        String guess = view.getGuess();
        if (trainer.guess(guess)) {
            view.setFeedback("Correct! Guess the next word.");
            loadRandomEntry();
        } else {
            view.setFeedback("Incorrect. Try again.");
        }

        updateUI();
    }

    private void handleAddImage() {
        String word = JOptionPane.showInputDialog(view, "Enter the word associated with the image:");
        if (word == null || word.trim().isEmpty())
            return;

        String imagePath = JOptionPane.showInputDialog(view, "Enter the URL or path to the image:");

        if (imagePath == null || imagePath.trim().isEmpty())
            return;

        try {
            WordEntry newEntry = new WordEntry(word, imagePath);

            trainer.addEntry(newEntry);
            view.setFeedback("Image added successfully!");
        } catch (Exception e) {
            view.setFeedback("Invalid URL or path. Image not added.");

            System.out.println("Error while adding image: " + e);
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

    private void handleLoad() {
        File f = new File(SAVE_FILE);

        if (f.exists()) {
            try {
                trainer = ISerde.INSTANCE.deserialize(f, Trainer.class);
                view.setFeedback("Save loaded successfully!");

                updateUI();
            } catch (Exception e) {
                view.setFeedback("Error loading save.");
                System.out.println("Error while loading save: " + e);
            }
        } else {
            view.setFeedback("No save found.");
        }

    }

    private void handleSave() {
        try {
            ISerde.INSTANCE.serialize(trainer, SAVE_FILE);
            view.setFeedback("Save successful!");
        } catch (Exception e) {
            view.setFeedback("Error saving file.");
            System.out.println("Error while saving file: " + e);
        }
    }
}
