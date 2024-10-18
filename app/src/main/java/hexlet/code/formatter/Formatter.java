package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;
import java.util.Map;

public class Formatter {

    public static String format(List<Data> dataList, Format format) throws Exception {
        return switch (format) {
            case STYLISH -> Stylish.format(dataList);
            case PLAIN -> Plain.format(dataList);
            case JSON -> Json.format(dataList);
        };
    }

    public static Format formatConverter(String stringFormat) {
        return Format.valueOf(stringFormat.toUpperCase());
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
