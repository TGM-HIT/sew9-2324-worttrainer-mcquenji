package sew9.worttrainer.mcquenji.serde;

import java.io.File;

import sew9.worttrainer.mcquenji.serde.json.JsonSerde;

/**
 * Interface for serialization and deserialization.
 * 
 * @see sew9.worttrainer.mcquenji.serde.json.JsonSerde
 * 
 * @author Benjamin McEachnie
 * @version 2023-10-03
 */
public interface ISerde {

    /**
     * Deserializes an object from given path.
     * 
     * @param path The path to the file to deserialize.
     * 
     * @return The deserialized object.
     * 
     * @throws Exception If an error occurs during deserialization.
     */
    public <T> T deserialize(String path, Class<T> type) throws Exception;

    /**
     * Deserializes an object from given file.
     * 
     * @param file The file to deserialize.
     * 
     * @return The deserialized object.
     * 
     * @throws Exception If an error occurs during deserialization.
     */
    public <T> T deserialize(File file, Class<T> type) throws Exception;

    /**
     * Serializes an object to the given file.
     * 
     * @param file   The file to serialize to.
     * @param object The object to serialize.
     * 
     * @throws Exception If an error occurs during serialization.
     */
    public void serialize(Object object, File file) throws Exception;

    /**
     * Serializes an object to the given path.
     * 
     * @param path   The path to serialize to.
     * @param object The object to serialize.
     * 
     * @throws Exception If an error occurs during serialization.
     */
    public void serialize(Object object, String path) throws Exception;

    /**
     * The instance to use for serialization and deserialization in the application.
     */
    public static final ISerde INSTANCE = new JsonSerde();
}
