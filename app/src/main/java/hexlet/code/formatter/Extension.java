package hexlet.code.formatter;

import hexlet.code.exceptions.UnsupportedFileFormatException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum Extension {
    JSON("json"),
    YAML("yaml"),
    YML("yml"),
    XML("xml");

    private final String extension;

    Extension(String extension) {
        this.extension = extension;
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null) {
            return null;
        }
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex >= 0) {
            return fileName.substring(dotIndex + 1);
        }
        return "";
    }

    public static Set<String> getSupportedExtension() {
        return Arrays.stream(Extension.values())
                .map(Extension::toString)
                .collect(Collectors.toSet());
    }

    public static boolean isValidExtension(String extension) throws UnsupportedFileFormatException {
        return getSupportedExtension().contains(extension.toLowerCase());
    }

    @Override
    public String toString() {
        return extension;
    }
}
