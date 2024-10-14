package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static hexlet.code.Formatter.checkValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FormatterTest {
    private String content1;
    private String[] content2;
    private Map<String, Object> content3 = new HashMap<>();

    @BeforeEach
    public void beforeEach() {
        content1 = "value";
        content2 = new String[]{"a", "b", "c"};
        content3.put("nestedKey", "value");
        content3.put("isNested", true);
    }

    @Test
    public void testCheckValue() {
        assertEquals("'value'", checkValue(content1));
        assertEquals("[complex value]", checkValue(content2));
        assertEquals("[complex value]", checkValue(content3));
    }


}
