package sew9.worttrainer.mcquenji.serialization;

/**
 * Serializes objects to a file.
 */
public class Serializer {
    /**
     * The path to the file to serialize to.
     */
    final String path;

    /**
     * Constructor
     * 
     * @param path The path to the file to serialize to.
     */
    public Serializer(String path) {
        this.path = path;
    }

    public void serialize(Object object) {
    }
}
