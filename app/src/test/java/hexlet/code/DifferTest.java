package hexlet.code;

import static hexlet.code.Differ.getFileFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;


public class DifferTest {
    private String jsonFile1 = "src/test/resources/testfile1.json";
    private String jsonFile2 = "src/test/resources/testfile2.json";
    private String yamlFile1 = "src/test/resources/testfile1.yml";
    private String yamlFile2 = "src/test/resources/testfile2.yml";

    private String expectedStylishFile = "src/test/resources/expected-stylish";
    private String expectedPlainFile = "src/test/resources/expected-plain";
    private String expectedJsonFile = "src/test/resources/expected-json";


    private static String readFixture(String fileName) throws Exception {
        return Files.readString(Path.of(fileName));
    }

    @Test
    public void testJsonToStylishDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedStylishFile), Differ.generate(jsonFile1, jsonFile2));
    }

    @Test
    public void testYamlToStylishDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedStylishFile), Differ.generate(yamlFile1, yamlFile2));
    }

    @Test
    public void testJsonToPlainDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedPlainFile), Differ.generate(jsonFile1, jsonFile2, "plain"));
    }

    @Test
    public void testYamlToPlainDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedPlainFile), Differ.generate(yamlFile1, yamlFile2, "plain"));
    }

    @Test
    public void testJsonToJsonDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedJsonFile), Differ.generate(jsonFile1, jsonFile2, "json"));
    }

    @Test
    public void testYamlToJsonDifferGenerate() throws Exception {
        assertEquals(readFixture(expectedJsonFile), Differ.generate(yamlFile1, yamlFile2, "json"));
    }

    @Test
    public void testGetFileFormat() {
        assertEquals("yml", getFileFormat("file1.yml"));
        assertEquals("json", getFileFormat("file1.my-lib.2024.json"));
    }


}
