package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Data> dataList, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.format(dataList);
            case "plain" -> Plain.format(dataList);
            case "json" -> Json.format(dataList);
            default -> throw new Exception("Unexpected format: " + format);
        };
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
