package sew9.worttrainer.mcquenji.serialization.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import sew9.worttrainer.mcquenji.serialization.Serializer;

public class JsonSerializer extends Serializer {

    public JsonSerializer(String path) {
        super(path);
    }

    @Override
    public void serialize(Object object) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        mapper.writeValue(this.file, object);
    }

}
