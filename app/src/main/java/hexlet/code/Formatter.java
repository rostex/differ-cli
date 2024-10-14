package hexlet.code;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String stylish(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        result.append("{").append("\n");
        for (var data : dataList) {
            switch (data.getStatus()) {
                case UNCHANGED:
                    result.append("    ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    break;
                case ADDED:
                    result.append("  + ").append(data.getKey())
                            .append(": ").append(data.getValue2()).append("\n");
                    break;
                case REMOVED:
                    result.append("  - ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    break;
                case UPDATED:
                    result.append("  - ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    result.append("  + ").append(data.getKey())
                            .append(": ").append(data.getValue2()).append("\n");
                    break;
                default:
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }

    public static String plain(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        for (var data : dataList) {
            switch (data.getStatus()) {
                case ADDED:
                    result.append("Property '").append(data.getKey())
                            .append("' was added with value: ").append(checkValue(data.getValue2())).append("\n");
                    break;
                case REMOVED:
                    result.append("Property '").append(data.getKey())
                            .append("' was removed").append("\n");
                    break;
                case UPDATED:
                    result.append("Property '").append(data.getKey())
                            .append("' was updated. From ").append(checkValue(data.getValue1()))
                            .append(" to ").append(checkValue(data.getValue2())).append("\n");
                    break;
                default:
                    break;
            }
        }
        return result.toString().trim();
    }

    public static String json(List<Data> dataList) throws JsonProcessingException {
        return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT).writeValueAsString(dataList);
    }

    public static String checkValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Iterable<?> || value instanceof Map<?, ?>
                || value instanceof Integer[] || value instanceof String[]) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }

}
