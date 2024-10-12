package hexlet.code;

import static hexlet.code.Differ.getFileFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferTest {
    String fileJsonPath1 = "src/test/resources/testfile1.json";
    String fileJsonPath2 = "src/test/resources/testfile2.json";
    String fileYamlPath1 = "src/test/resources/testfile1.yml";
    String fileYamlPath2 = "src/test/resources/testfile2.yml";

    Map<String, Object> content1 = new HashMap<>();
    Map<String, Object> content2 = new HashMap<>();

    Map<String, Object> content3 = new HashMap<>();
    Map<String, Object> content4 = new HashMap<>();

    List<Data> expected = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        content1.put("client", "windows");
        content1.put("open-source", true);
        content1.put("version", 2);
        content1.put("application", "JsonDiff");

        content2.put("application", "JsonDiff");
        content2.put("version", 5);
        content2.put("client", "macOS");
/*
        content3.put("setting1", "Some value");
        content3.put("setting2", 200);
        content3.put("setting3", true);
        content3.put("key1", "value1");
        content3.put("numbers1", new Integer[]{1, 2, 3, 4});
        content3.put("numbers2", new Integer[]{2, 3, 4, 5});
        content3.put("id", null);
        content3.put("default", false);
        content3.put("checked", 45);
        content3.put("numbers3", new Integer[]{3, 4, 5});
        content3.put("chars1", new String[]{"a", "b", "c"});
        content3.put("chars2", new String[]{"d", "e", "f"});

        content4.put("setting1", "Another value");
        content4.put("setting2", 300);
        content4.put("setting3", "none");
        content4.put("key2", "value2");
        content4.put("numbers1", new Integer[]{1, 2, 3, 4});
        content4.put("numbers2", new Integer[]{22, 33, 44, 55});
        content4.put("id", null);
        content4.put("default", new String[]{"value1", "value2"});
        content4.put("checked", true);
        content4.put("numbers4", new Integer[]{4, 5, 6});
        content4.put("chars1", new String[]{"a", "b", "c"});
        content4.put("chars2", false);
        content4.put("obj1", new HashMap<String, Object>() {{
                put("nestedKey", "value");
                put("isNested", true);
            }});
*/
        expected.add(new Data("application", "JsonDiff", "JsonDiff", Data.Status.UNCHANGED));
        expected.add(new Data("client", "windows", "macOS", Data.Status.UPDATED));
        expected.add(new Data("open-source", true, null, Data.Status.REMOVED));
        expected.add(new Data("version", 2, 5, Data.Status.UPDATED));
    }

    @Test
    public void testGetDiff() {
        assertEquals(expected, Differ.getDiff(content1, content2));

    }

    @Test
    public void testGetFileFormat() {
        assertEquals("yml", getFileFormat("file1.yml"));
        assertEquals("json", getFileFormat("file1.my-lib.2024.json"));
    }

    @Test
    public void testGenerate() throws Exception {
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

}
