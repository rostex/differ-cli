package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.Data;

import java.util.List;

public class Json {
    public static String format(List<Data> dataList) throws JsonProcessingException {
        return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(dataList);
    }
}
