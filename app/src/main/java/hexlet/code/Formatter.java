package hexlet.code;


import java.util.*;

public class Formatter {

    public static String stylish(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        result.append("{").append("\n");
        for (var data : dataList) {
            switch (data.getStatus()) {
                case UNCHANGED:
                    result.append("  ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    break;
                case ADDED:
                    result.append("+ ").append(data.getKey())
                            .append(": ").append(data.getValue2()).append("\n");
                    break;
                case REMOVED:
                    result.append("- ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    break;
                case UPDATED:
                    result.append("- ").append(data.getKey())
                            .append(": ").append(data.getValue1()).append("\n");
                    result.append("+ ").append(data.getKey())
                            .append(": ").append(data.getValue2()).append("\n");
                    break;
            }
        }

        result.append("}");

        return result.toString();
    }

    public static String plain(List<Data> dataList) {
        StringBuilder result = new StringBuilder();

        for (var data : dataList) {

            //var value1 = data.getValue1() instanceof Object  ? "[complex value]" : data.getValue1();
            //var value2 = data.getValue2() instanceof Object ? "[complex value]" : data.getValue2();

            switch (data.getStatus()) {
                case ADDED:
                    result.append("Property ").append(data.getKey())
                            .append(" was added with value: ").append(data.getValue2()).append("\n");
                    break;
                case REMOVED:
                    result.append("Property ").append(data.getKey())
                            .append(" was removed").append("\n");
                    break;
                case UPDATED:
                    result.append("Property ").append(data.getKey())
                            .append(" was updated. From ").append(data.getValue1())
                            .append(" to ").append(data.getValue2()).append("\n");
                    break;
            }
        }

        return result.toString();
    }

}
