package sew9.worttrainer.mcquenji.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordEntryTest {

    @Test
    public void testConstructorWithNullValuesThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new WordEntry(null, "https://example.com"));
        assertThrows(IllegalArgumentException.class, () -> new WordEntry("word", null));
    }

    @Test
    public void testConstructorWithInvalidUrlThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new WordEntry("word", "not a url"));
    }

    @Test
    public void testValidateUrlReturnsTrueForValidUrl() {
        WordEntry entry = new WordEntry("word", "https://example.com");
        assertTrue(entry.validateUrl());
    }

    @Test
    public void testValidateUrlReturnsFalseForInvalidUrl() {
        WordEntry entry = new WordEntry();
        entry.setUrl("not a url");
        assertFalse(entry.validateUrl());
    }

    @Test
    public void testAssertValidUrlThrowsExceptionForInvalidUrl() {
        WordEntry entry = new WordEntry();
        entry.setUrl("not a url");
        assertThrows(IllegalArgumentException.class, entry::assertValidUrl);
    }

}
