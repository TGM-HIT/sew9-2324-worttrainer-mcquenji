package sew9.worttrainer.mcquenji.serde.json;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import sew9.worttrainer.mcquenji.serde.*;

/**
 * Implementation of {@link Serde} for JSON.
 */
public class JsonSerde implements Serde {
    private final ObjectMapper mapper;

    public JsonSerde() {
        mapper = new ObjectMapper();
    }

    @Override
    public void serialize(Object object, File file) throws Exception {
        mapper.writeValue(file, object);
    }

    @Override
    public Object deserialize(File file) throws Exception {
        return mapper.readValue(file, Object.class);
    }

    @Override
    public Object deserialize(String path) throws Exception {
        return deserialize(new File(path));
    }

    @Override
    public void serialize(Object object, String path) throws Exception {
        serialize(object, new File(path));
    }
}
