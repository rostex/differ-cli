package hexlet.code;

import lombok.*;

import java.util.HashMap;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Server {
    private String host;
    private String proxy;
    private int timeout;
    private boolean follow;
    private boolean verbose;

}
