package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.formatter.Extension;
import hexlet.code.formatter.Format;
import hexlet.code.exceptions.UnsupportedFileFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Differ {

    public static String generateDiff(String filePath1, String filePath2, Format formatType) throws Exception {
        var content1 = getDataFromFile(filePath1);
        var content2 = getDataFromFile(filePath2);
        var dataList = Differ.getDiff(content1, content2);

        return formatType.getFormat(dataList);
    }

    public static String generateDiff(String filePath1, String filePath2) throws Exception {
        return generateDiff(filePath1, filePath2, Format.STYLISH);
    }

    public static List<Data> getDiff(Map<String, Object> content1, Map<String, Object> content2) {
        List<Data> data = new ArrayList<>();
        Set<String> sortedKeys = new TreeSet<>();
        sortedKeys.addAll(content1.keySet());
        sortedKeys.addAll(content2.keySet());

        for (var key : sortedKeys) {
            var value1 = content1.get(key);
            var value2 = content2.get(key);

            // This is a small working workaround: if value is an empty string, we convert it to null.
            // This happens because empty XML tags (like <key/>) are deserialized as empty strings,
            // but we want to treat them as null in the diffing process.
            if (value1 != null && value1.equals("")) {
                value1 = null;
            }
            if (value2 != null && value2.equals("")) {
                value2 = null;
            }

            if (!content1.containsKey(key)) {
                data.add(new Data(key, null, value2, Data.Status.ADDED));
            } else if (!content2.containsKey(key)) {
                data.add(new Data(key, value1, null, Data.Status.REMOVED));
            } else if (!getEqualsData(value1, value2)) {
                data.add(new Data(key, value1, value2, Data.Status.UPDATED));
            } else {
                data.add(new Data(key, value1, value2, Data.Status.UNCHANGED));
            }
        }
        return data;
    }

    public static Map getDataFromFile(String filePath) throws UnsupportedFileFormatException, IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filePath);
        }

        String fileExtension = Extension.getFileExtension(filePath);
        if (!Extension.isValidExtension(fileExtension)) {
            throw new UnsupportedFileFormatException("Unsupported file format: " + fileExtension);
        }

        switch (fileExtension) {
            case "yml":
            case "yaml":
                parseYaml(file);
            case "json":
                parseJson(file);
            case "xml":
                parseXml(file);
            default:
                throw new UnsupportedFileFormatException(filePath);
        }
    }

    private static boolean getEqualsData(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }
        return value1.equals(value2);
    }

    public static Map<String, Object> parseYaml(File file) throws IOException {
        YAMLMapper yamlMapper = new YAMLMapper();
        return yamlMapper.readValue(file, Map.class);
    }

    public static Map<String, Object> parseJson(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, Map.class);
    }

    private static Map<String, Object> parseXml(File file) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(file, Map.class);
    }

}
