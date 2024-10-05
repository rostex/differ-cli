package hexlet.code;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;



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
