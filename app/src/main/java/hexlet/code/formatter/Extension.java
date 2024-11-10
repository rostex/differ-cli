package hexlet.code.formatter;

public enum Extension {
    JSON("json"),
    YAML("yaml"),
    YML("yml"),
    XNL("xml");

    private final String extension;

    Extension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return extension;
    }
}
