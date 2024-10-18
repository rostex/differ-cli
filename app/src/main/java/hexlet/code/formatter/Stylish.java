package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;

public class Stylish {
    public static String format(List<Data> dataList) {
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
}
