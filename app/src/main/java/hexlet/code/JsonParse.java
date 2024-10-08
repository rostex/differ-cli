package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.*;


public class JsonParse {

    public static Data getDiff(Map<String, Object> content1, Map<String, Object> content2) {
        Set<String> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(content1.keySet());
        sortedKeys.addAll(content2.keySet());

        Data data = new Data("host", null, null, Data.Status.UNCHANGED);

        for (var key : sortedKeys) {
            var value1 = content1.get(key);
            var value2 = content2.get(key);

            if (value1 == null && value2 == null) {
                data.addData(new Data(key, null, null, Data.Status.UNCHANGED));
            } else if (value1 == null) {
                data.addData(new Data(key, null, value2, Data.Status.ADDED));
            } else if (value2 == null) {
                data.addData(new Data(key, value1, null, Data.Status.REMOVED));
            } else if (!value1.equals(value2)) {
                data.addData(new Data(key, value1, value2, Data.Status.UPDATED));
            } else {
                data.addData(new Data(key, value1, value2, Data.Status.UNCHANGED));
            }
        }
        return data;
    }

    public static Map getData(String filePath) throws Exception {
        File file = new File(filePath);
        YAMLMapper yamlMapper = new YAMLMapper();
        ObjectMapper objectMapper = new ObjectMapper();

        if (getFileFormat(filePath).equals("yml") || getFileFormat(filePath).equals("yaml")) {
            return yamlMapper.readValue(file, Map.class);
        } else if (getFileFormat(filePath).equals("json")) {
            return objectMapper.readValue(file, Map.class);
        } else {
            throw new Exception(filePath + " format is not supported");
        }

    }

    private static String getFileFormat(String filePath) {
        int indexOfDoT = filePath.lastIndexOf(".");
        return filePath.substring(indexOfDoT + 1);
    }


}

