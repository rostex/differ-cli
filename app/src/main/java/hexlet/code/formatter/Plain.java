package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlainFormat(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        for (var data : dataList) {
            switch (data.getStatus()) {
                case ADDED:
                    result.append(String.format("Property '%s' was added with value: %s%n",
                            data.getKey(), checkValue(data.getValue2())));
                    break;
                case REMOVED:
                    result.append(String.format("Property '%s' was removed%n", data.getKey()));
                    break;
                case UPDATED:
                    result.append(String.format("Property '%s' was updated. From %s to %s%n",
                            data.getKey(), checkValue(data.getValue1()), checkValue(data.getValue2())));
                    break;
                case UNCHANGED:
                    break;
                default:
                    break;
            }
        }
        return result.toString().trim();
    }


    public static String checkValue(Object value) {
        if (value == null) {
            return "null";
        }

        return switch (value) {
            case String s -> "'" + s + "'";
            case Iterable<?> i -> "[complex value]";
            case Object[] arr -> "[complex value]";
            case Map<?, ?> m -> "[complex value]";
            default -> String.valueOf(value);
        };
    }
}
