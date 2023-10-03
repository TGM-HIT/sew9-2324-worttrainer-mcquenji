package sew9.worttrainer.mcquenji.serialization;

import java.io.File;

public abstract class Deserializer {
    /**
     * The path to the file to deserialize from.
     */
    protected final File file;

    /**
     * Constructor
     * 
     * @param path The path to the file to deserialize from.
     */
    public Deserializer(String path) {
        file = new File(path);
    }

    /**
     * Deserializes an object from the file at {@link #file}
     * 
     * @return The deserialized object.
     * 
     * @throws Exception If an error occurs during deserialization.
     */
    public abstract Object deserialize() throws Exception;
}
