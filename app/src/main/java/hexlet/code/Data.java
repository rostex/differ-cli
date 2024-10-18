package hexlet.code;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Data {
    private String key;
    private Object value1;
    private Object value2;
    private Status status;

    public Data(String key, Object value1, Object value2, Status status) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.status = status;
    }

    public enum Status {
        UNCHANGED,
        ADDED,
        REMOVED,
        UPDATED
    }
}
