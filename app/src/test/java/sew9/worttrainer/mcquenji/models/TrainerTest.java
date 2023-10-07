package sew9.worttrainer.mcquenji.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void testConstructorWithNullArrayThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Trainer(null));
    }

    @Test
    public void testAddEntry() {
        Trainer trainer = new Trainer();
        WordEntry entry = new WordEntry("word", "https://example.com");
        trainer.addEntry(entry);
        assertTrue(trainer.getEntries().contains(entry));
    }

    @Test
    public void testRemoveEntry() {
        Trainer trainer = new Trainer();
        WordEntry entry = new WordEntry("word", "https://example.com");
        trainer.addEntry(entry);
        trainer.removeEntry(entry);
        assertFalse(trainer.getEntries().contains(entry));
    }

    @Test
    public void testAssertValidStateWithNullEntriesThrowsException() {
        Trainer trainer = new Trainer();
        trainer.setEntries(null);
        assertThrows(IllegalStateException.class, trainer::assertValidState);
    }

    @Test
    public void testAssertValidStateWithNullEntryThrowsException() {
        var entries = new WordEntry[] { new WordEntry("word", "https://example.com"), null };

        Trainer trainer = new Trainer(entries);

        assertThrows(IllegalStateException.class, trainer::assertValidState);
    }

    @Test
    public void testGuessWithNoCurrentEntryThrowsException() {
        Trainer trainer = new Trainer();
        assertThrows(IllegalStateException.class, () -> trainer.guess("any guess"));
    }

    @Test
    public void testGuessReturnsTrueForCorrectGuess() {
        Trainer trainer = new Trainer();
        WordEntry entry = new WordEntry("word", "https://example.com");
        trainer.setCurrentEntry(entry);
        assertTrue(trainer.guess("word"));
    }

    @Test
    public void testGuessReturnsFalseForIncorrectGuess() {
        Trainer trainer = new Trainer();
        WordEntry entry = new WordEntry("word", "https://example.com");
        trainer.setCurrentEntry(entry);
        assertFalse(trainer.guess("wrongWord"));
    }
}
