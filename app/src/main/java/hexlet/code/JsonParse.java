package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.*;
import hexlet.code.Data;



public class JsonParse {

    public static String getDiff(Map<String, Object> content1, Map<String, Object> content2) {
        StringBuilder result = new StringBuilder();

        Set<String> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(content1.keySet());
        sortedKeys.addAll(content2.keySet());

        Data data = new Data

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

    public static Map getData(String filePath) throws Exception {
        if (getFileFormat(filePath).equals("yml") || getFileFormat(filePath).equals("yaml")) {
            YAMLMapper yamlMapper = new YAMLMapper();
            File file = new File(filePath);
            return yamlMapper.readValue(file, Map.class);
        } else if (getFileFormat(filePath).equals("json")){
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File(filePath);
            return objectMapper.readValue(file, Map.class);
        } else {
            throw new Exception(filePath + " format is not supported");
        }

    }

    private static String getFileFormat (String filePath) {
        int indexOfDoT = filePath.indexOf(".");
        return filePath.substring(indexOfDoT + 1);
    }


}

