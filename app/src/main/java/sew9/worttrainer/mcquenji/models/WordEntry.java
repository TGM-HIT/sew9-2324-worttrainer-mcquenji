package sew9.worttrainer.mcquenji.models;

import java.io.Serializable;

/**
 * Connects a word to a url that is associated with it.
 * 
 * @author Benjamin McEachnie
 * @version 2023-09-27
 */
public class WordEntry implements Serializable {
    /**
     * The word that is associated with the {@link #url}
     */
    private String word;

    /**
     * The url that is associated with the {@link #word}
     * 
     * This url has to be a link to an image.
     */
    private String url;

    final String URL_REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**
     * Empty constructor for serialization.
     * 
     * This constructor will set the {@link #word} and {@link #url} to null.
     * Do not use this constructor manually.
     * 
     * @see sew9.worttrainer.mcquenji.serde.json.JsonSerde
     * @see sew9.worttrainer.mcquenji.serde.ISerde
     * 
     * @deprecated This constructor is only used for serialization.
     */
    public WordEntry() {
        url = null;
        word = null;
    }

    /**
     * Constructor
     * 
     * @param word The word that is associated with the {@link #url}
     * @param url  The url that is associated with the {@link #word}
     * 
     * @throws IllegalArgumentException if the {@link #url} is not a valid url.
     *                                  See {@link #validateUrl()}
     * @throws IllegalArgumentException if the {@link #word} or the {@link #url} is
     *                                  null.
     */
    public WordEntry(String word, String url) {
        this.word = word;
        this.url = url;

        if (word == null || url == null) {
            throw new IllegalArgumentException("The word or the url must not be null");
        }

        assertValidUrl();
    }

    /**
     * Checks if the {@link #url} is a valid url.
     * 
     * @return true if the {@link #url} is a valid url, false otherwise.
     */
    public boolean validateUrl() {
        return url.matches(URL_REGEX);
    }

    /**
     * Throws an {@link IllegalArgumentException} if the {@link #url} is not a
     * valid url.
     */
    public void assertValidUrl() {
        if (!validateUrl()) {
            throw new IllegalArgumentException("The url is not valid");
        }
    }

    @Override
    public String toString() {
        return String.format("WordEntry[word=%s, url=%s]", word, url);
    }

    public String getUrl() {
        return url;
    }

    public String getWord() {
        return word;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
