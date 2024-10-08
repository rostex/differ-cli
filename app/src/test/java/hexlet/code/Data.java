package hexlet.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Data {
    private String key;
    private Object value1;
    private Object value2;
    private String status;

    enum Status {
        UNCHANGED,
        ADED,
        REMOVED,
        UPDATED
    }
}
