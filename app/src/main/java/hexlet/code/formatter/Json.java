package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.Data;

import java.util.List;

public class Json {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public static String getJsonFormat(List<Data> dataList) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(dataList);
    }
}
