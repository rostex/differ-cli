package hexlet.code.exceptions;

public class UnsupportedFileFormatException extends Exception {
    public UnsupportedFileFormatException(String fileName) {
        super("Unsupported dile getFormat: " + fileName);
    }
}