package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static hexlet.code.Formatter.checkValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    String content1;
    Integer[] content2;
    Map<String, Object> content3 = new HashMap<>();
    List<Data> content4 = new ArrayList<>();

    @BeforeEach
    public void beforeEach() {
        content1 = "value";
        content2 = new Integer[]{4, 5, 6};
        content3.put("nestedKey", "value");
        content3.put("isNested", true);

        content4.add(new Data("chars1", new String[]{"a", "b", "c"}, new String[]{"a", "b", "c"},
                Data.Status.UNCHANGED));
        content4.add(new Data("chars2", new String[]{"d", "e", "f"}, false, Data.Status.UPDATED));
        content4.add(new Data("checked", false, true, Data.Status.UPDATED));
        content4.add(new Data("default", null, new String[]{"value1", "value2"}, Data.Status.UPDATED));
        content4.add(new Data("id", 45, null, Data.Status.UPDATED));
        content4.add(new Data("key1", "value1", null, Data.Status.REMOVED));
        content4.add(new Data("key2", null, "value2", Data.Status.ADDED));
        content4.add(new Data("numbers1", new Integer[]{1, 2, 3, 4}, new Integer[]{1, 2, 3, 4},
                Data.Status.UNCHANGED));
        content4.add(new Data("numbers2", new Integer[]{2, 3, 4, 5}, new Integer[]{22, 33, 44, 55},
                Data.Status.UPDATED));
        content4.add(new Data("numbers3", new Integer[]{3, 4, 5}, null, Data.Status.REMOVED));
        content4.add(new Data("numbers4", null, new Integer[]{4, 5, 6}, Data.Status.ADDED));
        content4.add(new Data("obj1", null, new HashMap<String, Object>() {{
                put("nestedKey", "value");
                put("isNested", true);
            }}, Data.Status.ADDED));
        content4.add(new Data("setting1", "Some value", "Another value", Data.Status.UPDATED));
        content4.add(new Data("setting2", 200, 300, Data.Status.UPDATED));
        content4.add(new Data("setting3", true, "none", Data.Status.UPDATED));
    }

    /*
@Test
public void testStylish() {
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
            Formatter.stylish(content4));

}
    */
    @Test
    public void testPlain() {
        assertEquals("Property 'chars2' was updated. From [complex value] to false" + "\n"
                + "Property 'checked' was updated. From false to true" + "\n"
                + "Property 'default' was updated. From null to [complex value]" + "\n"
                + "Property 'id' was updated. From 45 to null" + "\n"
                + "Property 'key1' was removed" + "\n"
                + "Property 'key2' was added with value: 'value2'" + "\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]" + "\n"
                + "Property 'numbers3' was removed" + "\n"
                + "Property 'numbers4' was added with value: [complex value]" + "\n"
                + "Property 'obj1' was added with value: [complex value]" + "\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'" + "\n"
                + "Property 'setting2' was updated. From 200 to 300" + "\n"
                + "Property 'setting3' was updated. From true to 'none'" + "\n", Formatter.plain(content4));
    }

    @Test
    public void testCheckValue() {
        assertEquals("'value'", checkValue(content1));
        assertEquals("[complex value]", checkValue(content2));
        assertEquals("[complex value]", checkValue(content3));
    }


}
