package hexlet.code;

import org.junit.jupiter.api.Test;

import static hexlet.code.Differ.getData;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    String fileJsonPath1 = "src/test/resources/testfile1.json";
    String fileJsonPath2 = "src/test/resources/testfile2.json";
    String fileYamlPath1 = "src/test/resources/testfile1.yml";
    String fileYamlPath2 = "src/test/resources/testfile2.yml";

    @Test
    public void testCallJson() throws Exception {
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
                Differ.generate(fileJsonPath1, fileJsonPath2, "stylish"));

    }

    @Test
    public void testCallYaml() throws Exception {
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
                Differ.generate(fileYamlPath1, fileYamlPath2, "stylish"));

    }
}
