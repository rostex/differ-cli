package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.util.*;


public class Differ {

    public static List<Data> data = new ArrayList<>();

    public static String generate(String filePath1, String filePath2, String format) throws Exception {
        String result;
        switch (format) {
            case "plain":
                result = Formatter.plain(Differ.getDiff(getData(filePath1), getData(filePath2)));
                break;
            default:
                result = Formatter.stylish(Differ.getDiff(getData(filePath1), getData(filePath2)));
                break;
        }
        return result;
    }

    public static List<Data> getDiff(Map<String, Object> content1, Map<String, Object> content2) {
        Set<String> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(content1.keySet());
        sortedKeys.addAll(content2.keySet());


        for (var key : sortedKeys) {
            var value1 = content1.get(key);
            var value2 = content2.get(key);

            if (!content1.containsKey(key)) {
                data.add(new Data(key, null, value2, Data.Status.ADDED));
            } else if (!content2.containsKey(key)) {
                data.add(new Data(key, value1, null, Data.Status.REMOVED));
            } else if (value1 == null && value2 != null) {
                data.add(new Data(key, null, value2, Data.Status.UPDATED));
            } else if (value1 != null && value2 == null) {
                data.add(new Data(key, value1, null, Data.Status.UPDATED));
            } else if (value1 != null && value2 != null && !value1.equals(value2)) {
                data.add(new Data(key, value1, value2, Data.Status.UPDATED));
            } else {
                data.add(new Data(key, value1, value2, Data.Status.UNCHANGED));
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

