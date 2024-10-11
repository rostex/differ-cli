package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Formatter.checkValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    String content1;
    Integer[] content2;
    Map<String, Object> content3 = new HashMap<>();

    @BeforeEach
    public void beforeEach() {
        content1 = "value";
        content2 = new Integer[]{4, 5, 6};
        content3.put("nestedKey", "value");
        content3.put("isNested", true);
    }

    @Test
    public void checkValueTest() {
        assertEquals("'value'", checkValue(content1));
        assertEquals("[complex value]", checkValue(content2));
        assertEquals("[complex value]", checkValue(content3));
    }
}
