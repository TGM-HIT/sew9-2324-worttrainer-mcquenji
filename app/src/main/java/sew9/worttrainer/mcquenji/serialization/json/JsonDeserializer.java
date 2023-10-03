package sew9.worttrainer.mcquenji.serialization.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import sew9.worttrainer.mcquenji.serialization.Deserializer;

public class JsonDeserializer extends Deserializer {

    public JsonDeserializer(String path) {
        super(path);
    }

    @Override
    public Object deserialize() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        return mapper.readValue(this.file, Object.class);
    }

}
