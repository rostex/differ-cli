package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import hexlet.code.formatter.Extension;
import hexlet.code.formatter.Format;
import hexlet.code.exceptions.UnsupportedFileFormatException;

import java.io.File;
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
        String fileExtension = getFileExtension(filePath);
        File file = new File(filePath);
        YAMLMapper yamlMapper = new YAMLMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        switch (fileExtension) {
            case "yml":
            case "yaml":
                return yamlMapper.readValue(file, Map.class);
            case "json":
                return objectMapper.readValue(file, Map.class);
            case "xml":
                return xmlMapper.readValue(file, Map.class);
            default:
                throw new UnsupportedFileFormatException(filePath);
        }
    }

    public static String getFileExtension(String fileName) throws UnsupportedFileFormatException {
        int indexOfDoT = fileName.lastIndexOf(".");
        if (indexOfDoT == -1) {
            throw new UnsupportedFileFormatException(fileName);
        }

        String extension = fileName.substring(indexOfDoT + 1);

        boolean validExtension = false;
        for (Extension ext : Extension.values()) {
            if (ext.toString().equals(extension)) {
                validExtension = true;
                break;
            }
        }

        if (!validExtension) {
            throw new UnsupportedFileFormatException(fileName);
        }
        return extension;
    }

    private static boolean getEqualsData(Object value1, Object value2) {
        if (value1 == null || value2 == null) {
            return value1 == value2;
        }
        return value1.equals(value2);
    }
}
