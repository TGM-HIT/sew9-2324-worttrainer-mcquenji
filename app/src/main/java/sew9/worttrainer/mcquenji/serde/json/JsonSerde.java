package sew9.worttrainer.mcquenji.serde.json;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;

import sew9.worttrainer.mcquenji.serde.*;

/**
 * Implementation of {@link ISerde} for JSON.
 */
public class JsonSerde implements ISerde {
    private final ObjectMapper mapper;

    public JsonSerde() {
        mapper = new ObjectMapper();
    }

    @Override
    public void serialize(Object object, File file) throws Exception {
        mapper.writeValue(file, object);
    }

    @Override
    public <T> T deserialize(File file, Class<T> type) throws Exception {
        return mapper.readValue(file, type);

    }

    @Override
    public <T> T deserialize(String path, Class<T> type) throws Exception {
        return deserialize(new File(path), type);
    }

    @Override
    public void serialize(Object object, String path) throws Exception {
        serialize(object, new File(path));
    }
}
