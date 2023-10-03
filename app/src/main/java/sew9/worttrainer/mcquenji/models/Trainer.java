package sew9.worttrainer.mcquenji.models;

import java.io.Serializable;
import java.util.*;

import sew9.worttrainer.mcquenji.models.validation.CaseSensitiveValadtionAlgorithm;
import sew9.worttrainer.mcquenji.models.validation.ValidationAlgorithm;

/**
 * Handles the logic for the training game.
 * 
 * @author Benjamin McEachnie
 * @version 2023-09-27
 */
public class Trainer implements Serializable {
    private List<WordEntry> entries;

    private WordEntry currentEntry;

    private int totalGuesses;
    private int correctGuesses;

    private ValidationAlgorithm validationAlgorithm;

    /**
     * Constructor.
     * 
     * Defaults to {@link CaseSensitiveValadtionAlgorithm} as
     * {@link #validationAlgorithm validation algorithm}.
     * 
     * @param entries The entries to use.
     * 
     * @throws IllegalArgumentException if {@link #entries} is null.
     */
    public Trainer(WordEntry[] entries) {
        this.entries = Arrays.asList(entries);

        if (entries == null) {
            throw new IllegalArgumentException("The entries must not be null");
        }

        validationAlgorithm = new CaseSensitiveValadtionAlgorithm();
    }

    /**
     * 
     * Throws an {@link IllegalStateException} if any of the fields are null
     */
    public void assertValidState() {
        if (entries == null) {
            throw new IllegalStateException("The entries must not be null");
        }

        for (WordEntry entry : entries) {
            if (entry == null) {
                throw new IllegalStateException("The entries must not contain null");
            }
        }

    }

    public List<WordEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    /**
     * Adds an entry to the {@link #entries}
     * 
     * @param entry The entry to add.
     */
    public void addEntry(WordEntry entry) {
        entries.add(entry);
    }

    /**
     * Removes an entry from the {@link #entries}
     * 
     * @param entry The entry to remove.
     */
    public void removeEntry(WordEntry entry) {
        entries.remove(entry);
    }

    /**
     * Picks a random entry from the {@link #entries} and returns it.
     * 
     * @return A random entry from the {@link #entries}
     */
    public WordEntry getRandomEntry() {
        Random random = new Random();

        return currentEntry = entries.get(random.nextInt(entries.size()));
    }

    /**
     * Returns the current entry selected by {@link #getRandomEntry()}
     * 
     * @return The current entry.
     */
    public WordEntry getCurrentEntry() {
        return currentEntry;
    }

    /**
     * Returns the total number of guesses tracked when {@link #guess(String)
     * guessing}.
     * 
     * @return The total number of guesses.
     */
    public int getTotalGuesses() {
        return totalGuesses;
    }

    /**
     * Returns the number of correct guesses tracked when {@link #guess(String)
     * guessing}.
     * 
     * @return The number of correct guesses.
     */
    public int getCorrectGuesses() {
        return correctGuesses;
    }

    /**
     * Returns the number of incorrect guesses tracked when {@link #guess(String)
     * guessing}.
     * 
     * @return The number of incorrect guesses.
     */
    public int getIncorrectGuesses() {
        return totalGuesses - correctGuesses;
    }

    /**
     * Checks if the guess is correct.
     * 
     * @param guess The guess to check.
     * @return true if the guess is correct, false otherwise.
     * 
     * @throws IllegalStateException if the {@link #getCurrentEntry() current entry}
     *                               is null.
     */
    public boolean guess(String guess) {
        if (currentEntry == null) {
            throw new IllegalStateException("There is no current entry");
        }

        totalGuesses++;

        if (validationAlgorithm.validate(guess, currentEntry.word)) {
            correctGuesses++;

            currentEntry = null;

            return true;
        }

        return false;
    }

    /**
     * Sets the {@link ValidationAlgorithm} to use when {@link #guess(String)
     * guessing}.
     * 
     * @param validationAlgorithm The {@link ValidationAlgorithm} to use.
     */
    public void setValidationAlgorithm(ValidationAlgorithm validationAlgorithm) {
        this.validationAlgorithm = validationAlgorithm;
    }

    /**
     * Returns the {@link ValidationAlgorithm} that is used when
     * {@link #guess(String) guessing}.
     * 
     * @return The {@link ValidationAlgorithm} that is used.
     */
    public ValidationAlgorithm getValidationAlgorithm() {
        return validationAlgorithm;
    }
}
