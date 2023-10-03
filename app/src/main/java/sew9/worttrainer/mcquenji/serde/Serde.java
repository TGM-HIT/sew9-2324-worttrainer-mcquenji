package sew9.worttrainer.mcquenji.serde;

import java.io.File;

/**
 * Interface for serialization and deserialization.
 * 
 * @see sew9.worttrainer.mcquenji.serde.json.JsonSerde
 * 
 * @author Benjamin McEachnie
 * @version 2023-10-03
 */
public interface Serde {

    /**
     * Deserializes an object from given path.
     * 
     * @param path The path to the file to deserialize.
     * 
     * @return The deserialized object.
     * 
     * @throws Exception If an error occurs during deserialization.
     */
    public Object deserialize(String path) throws Exception;

    /**
     * Deserializes an object from given file.
     * 
     * @param file The file to deserialize.
     * 
     * @return The deserialized object.
     * 
     * @throws Exception If an error occurs during deserialization.
     */
    public Object deserialize(File file) throws Exception;

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
}
