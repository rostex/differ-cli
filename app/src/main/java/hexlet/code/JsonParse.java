package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.Map;

public class JsonParse {

    public static String getDiff(Map<String, Object> content1, Map<String, Object> content2) {
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
            } else if (!value1.equals(value2)) {
                result.append("- ").append(key).append(": ").append(value1).append("\n");
                result.append("+ ").append(key).append(": ").append(value2).append("\n");
            } else {
                result.append("  ").append(key).append(": ").append(value1).append("\n");
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

    public static Map getData(String filePath) throws Exception {
        int indexOfDoT = filePath.indexOf(".");
        var fileFormat = filePath.substring(indexOfDoT + 1);

        if (fileFormat.equals("yml") || fileFormat.equals("yaml")) {
            YAMLMapper yamlMapper = new YAMLMapper();
            File file = new File(filePath);
            return yamlMapper.readValue(file, Map.class);
        } else {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            return objectMapper.readValue(file, Map.class);
        }

    }

}

