package hexlet.code;


import java.util.*;

public class Formatter {

    public static String stylish(Data data) {
        StringBuilder result = new StringBuilder();

        result.append("{").append("\n");
            switch (data.getStatus()) {
                case UNCHANGED:
                    result.append("  ").append(data.getKey()).append(": ").append(data.getValue1()).append("\n");
                    break;
                case ADDED:
                    result.append("+ ").append(data.getKey()).append(": ").append(data.getValue2()).append("\n");
                    break;
                case REMOVED:
                    result.append("- ").append(data.getKey()).append(": ").append(data.getValue1()).append("\n");
                    break;
                case UPDATED:
                    result.append("- ").append(data.getKey()).append(": ").append(data.getValue1()).append("\n");
                    result.append("+ ").append(data.getKey()).append(": ").append(data.getValue2()).append("\n");
                    break;
            }

        result.append("}");

        return result.toString();
    }

}
