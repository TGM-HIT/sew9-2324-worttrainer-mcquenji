package sew9.worttrainer.mcquenji.serialization;

import java.io.File;

/**
 * Serializes objects to a file.
 */
public abstract class Serializer {
    /**
     * The file to serialize to.
     * 
     */
    protected final File file;

    /**
     * Constructor
     * 
     * @param path The path to the file to serialize to.
     */
    public Serializer(String path) {
        file = new File(path);
    }

    /**
     * Serializes an object to the file at {@link #file}
     * 
     * @param object The object to serialize.
     * 
     * @throws Exception If an error occurs during serialization.
     */
    public abstract void serialize(Object object) throws Exception;
}
