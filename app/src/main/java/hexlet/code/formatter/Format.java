package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.Data;

import java.util.List;

public enum Format {

    JSON("json") {
        @Override
        public String getFormat(List<Data> dataList) throws JsonProcessingException {
            return Json.getJsonFormat(dataList);
        }
    },
    PLAIN("plain") {
        @Override
        public String getFormat(List<Data> dataList) {
            return Plain.getPlainFormat(dataList);
        }
    },
    STYLISH("stylish") {
        @Override
        public String getFormat(List<Data> dataList) {
            return Stylish.getStylishFormat(dataList);
        }
    };

    private final String format;

    Format(String format) {
        this.format = format;
    }

    public abstract String getFormat(List<Data> dataList) throws JsonProcessingException;

    @Override
    public String toString() {
        return format;
    }
}
