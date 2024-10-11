package hexlet.code;

import static hexlet.code.Differ.getFileFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class DifferTest {
    Map<String, Object> content1 = new HashMap<>();
    Map<String, Object> content2 = new HashMap<>();

    Map<String, Object> content3 = new HashMap<>();
    Map<String, Object> content4 = new HashMap<>();

    @BeforeEach
    public void beforeEach() {
        content1.put("client", "windows");
        content1.put("open-source", true);
        content1.put("version", 2);
        content1.put("application", "JsonDiff");

        content2.put("application", "JsonDiff");
        content2.put("version", 5);
        content2.put("client", "macOS");

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
                Formatter.stylish(Differ.getDiff(content1, content2)));

    }

    /*
        @Test
        public void testGetDiffMulti() {
            assertEquals("{"
                            + "\n"
                            + "chars1: [a, b, c]" + "\n"
                            + "- chars2: [d, e, f]" + "\n"
                            + "+ chars2: false" + "\n"
                            + "- checked: false" + "\n"
                            + "+ checked: true" + "\n"
                            + "- default: null" + "\n"
                            + "+ default: [value1, value2]" + "\n"
                            + "- id: 45" + "\n"
                            + "+ id: null" + "\n"
                            + "- key1: value1" + "\n"
                            + "+ key2: value2" + "\n"
                            + "numbers1: [1, 2, 3, 4]" + "\n"
                            + "- numbers2: [2, 3, 4, 5]" + "\n"
                            + "+ numbers2: [22, 33, 44, 55]" + "\n"
                            + "- numbers3: [3, 4, 5]" + "\n"
                            + "+ numbers4: [4, 5, 6]" + "\n"
                            + "+ obj1: {nestedKey=value, isNested=true}" + "\n"
                            + "- setting1: Some value" + "\n"
                            + "+ setting1: Another value" + "\n"
                            + "- setting2: 200" + "\n"
                            + "+ setting2: 300" + "\n"
                            + "- setting3: true" + "\n"
                            + "+ setting3: none"
                            + "\n"
                            + "}",
                    Formatter.stylish(Differ.getDiff(content3, content4)));

        }
    */

    @Test
    public void getFileFormatTest() {
        assertEquals("yml", getFileFormat("file1.yml"));
        assertEquals("json", getFileFormat("file1.my-lib.2024.json"));
    }

}
