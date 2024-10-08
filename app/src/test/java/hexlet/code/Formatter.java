package hexlet.code;


import java.util.*;

public class Formatter {


    public static String stylish(Map<String, Object> content1, Map<String, Object> content2) {
        StringBuilder result = new StringBuilder();

        Map<String, Object> keys = new HashMap<>(content1);
        keys.putAll(content2);

        List<String> sortedKeys = new ArrayList<>(keys.keySet());
        Collections.sort(sortedKeys);



        result.append("{").append("\n");
        for (var key : sortedKeys) {
            var value1 = content1.get(key);
            var value2 = content2.get(key);

            if (value1 == null && value2 == null) {
                result.append("  ").append(key).append(": ").append(value1).append("\n");
            } else if (value1 == null) {
                result.append("+ ").append(key).append(": ").append(value2).append("\n");
            } else if (value2 == null) {
                result.append("- ").append(key).append(": ").append(value1).append("\n");
            }else if (!value1.equals(value2)) {
                result.append("- ").append(key).append(": ").append(value1).append("\n");
                result.append("+ ").append(key).append(": ").append(value2).append("\n");
            } else {
                result.append("  ").append(key).append(": ").append(value1).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }

}
