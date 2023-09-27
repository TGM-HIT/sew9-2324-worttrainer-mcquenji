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
    final String word;

    /**
     * The url that is associated with the {@link #word}
     * 
     * This url has to be a link to an image.
     */
    final String url;

    final String URL_REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

    /**
     * Constructor
     * 
     * @param word The word that is associated with the {@link #url}
     * @param url  The url that is associated with the {@link #word}
     */
    public WordEntry(String word, String url) {
        this.word = word;
        this.url = url;
    }

    /**
     * Checks if the {@link #url} is a valid url.
     * 
     * @return true if the {@link #url} is a valid url, false otherwise.
     */
    public boolean validateUrl() {
        return url.matches(URL_REGEX);
    }
}
