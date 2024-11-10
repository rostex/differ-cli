package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;

public class Stylish {
    private static final String ADDED_SYMBOL = "+";
    private static final String REMOVED_SYMBOL = "-";
    private static final String UNCHANGED_SYMBOL = " ";

    public static String getStylishFormat(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        result.append("{")
                .append("\n");
        for (var data : dataList) {
            switch (data.getStatus()) {
                case UNCHANGED:
                    appendLine(result, UNCHANGED_SYMBOL, data.getKey(), data.getValue1());
                    break;
                case ADDED:
                    appendLine(result, ADDED_SYMBOL, data.getKey(), data.getValue2());
                    break;
                case REMOVED:
                    appendLine(result, REMOVED_SYMBOL, data.getKey(), data.getValue1());
                    break;
                case UPDATED:
                    appendLine(result, REMOVED_SYMBOL, data.getKey(), data.getValue1());
                    appendLine(result, ADDED_SYMBOL, data.getKey(), data.getValue2());
                    break;
                default:
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }

    private static void appendLine(StringBuilder result, String symbol, String key, Object value) {
        result.append("  ").append(symbol).append(" ")
                .append(key).append(": ").append((value))
                .append("\n");
    }
}
