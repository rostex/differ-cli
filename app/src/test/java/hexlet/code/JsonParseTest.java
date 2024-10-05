package hexlet.code;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class JsonParseTest {
    Map<String, Object> content1 = new HashMap<>();
    Map<String, Object> content2 = new HashMap<>();

    @BeforeEach
    public void beforeEach () {
        content1.put("client", "windows");
        content1.put("open-source", true);
        content1.put("version", 2);
        content1.put("application", "JsonDiff");

        content2.put("application", "JsonDiff");
        content2.put("version", 5);
        content2.put("client", "macOS");
    }

    @Test
    public void testGetDiff() {
        assertEquals("{"
                + "\n"
                + "  application: JsonDiff" + "\n"
                + "- client: windows" + "\n"
                + "+ client: macOS" + "\n"
                + "- open-source: true" + "\n"
                + "- version: 2" + "\n"
                + "+ version: 5"
                + "\n"
                + "}",
                JsonParse.getDiff(content1, content2));

    }
}
