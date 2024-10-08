package hexlet.code;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Data {
    private String key;
    private Object value1;
    private Object value2;
    private Status status;
    private List<Data> dataList;

    public Data(String key, Object value1, Object value2, Status status) {
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
        this.status = status;
    }

    public Data() {
        this.dataList = new ArrayList<>();
    }


    public void addData(Data content) {
        dataList.add(content);
    }


    enum Status {
        UNCHANGED,
        ADDED,
        REMOVED,
        UPDATED
    }
}
