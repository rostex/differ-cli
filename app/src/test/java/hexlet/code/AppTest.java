package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.JsonParse.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    String filePath1 = "src/test/resources/testfile1.json";
    String filePath2 = "src/test/resources/testfile2.json";

    @Test
    public void testCall() throws Exception {
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
                JsonParse.getDiff(getData(filePath1), getData(filePath2)));

    }
}
