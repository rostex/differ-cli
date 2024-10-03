package hexlet.code;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class Server extends HashMap<String, String> {
    private String host;
    private String proxy;
    private int timeout;
    private boolean follow;
    private boolean verbose;

}
