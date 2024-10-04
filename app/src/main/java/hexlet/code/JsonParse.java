package hexlet.code;

import java.util.Map;

public class JsonParse {

    public static String getDiff(Map<String, ?> content1, Map<String, ?> content2) {
        StringBuilder result = new StringBuilder();

        var sortedContent1 = content1.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();

        var sortedContent2 = content2.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();

        result.append("{").append("\n");
        for (var entry : sortedContent1) {
            var key = entry.getKey();
            var value1 = entry.getValue();
            var value2 = content2.get(key);

            if (!content2.containsKey(key)) {
                result.append("- ").append(key).append(": ").append(value1).append("\n");
            } else {
                if (!value1.equals(value2)) {
                    result.append("- ").append(key).append(": ").append(value1).append("\n");
                    result.append("+ ").append(key).append(": ").append(value2).append("\n");
                } else {
                    result.append("  ").append(key).append(": ").append(value1).append("\n");
                }
            }
        }

        for (var entry : sortedContent2) {
            var key = entry.getKey();
            if (!content1.containsKey(key)) {
                result.append("+ ").append(key).append(": ").append(entry.getValue()).append("\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}

