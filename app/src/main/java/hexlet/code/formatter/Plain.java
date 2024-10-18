package hexlet.code.formatter;

import hexlet.code.Data;

import java.util.List;

import static hexlet.code.formatter.Formatter.checkValue;

public class Plain {
    public static String format(List<Data> dataList) {
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
}
