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

    private String expectedStylishFile = "src/test/resources/expected-stylish.txt";
    private String expectedPlainFile = "src/test/resources/expected-plain.txt";
    private String expectedJsonFile = "src/test/resources/expected-json.txt";


    private static String readFixture(String fileName) throws Exception {
        return Files.readString(Path.of(fileName));
    }

    private void assertStringsEquals(String value1, String value2) {
        assertEquals(value1.replaceAll("\r", ""), value2.replaceAll("\r", ""));
    }

    @Test
    public void testJsonToStylishDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generate(jsonFile1, jsonFile2);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToStylishDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generate(yamlFile1, yamlFile2);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testJsonToPlainDifferGenerate() throws Exception {
        var expected = readFixture(expectedPlainFile);
        var actual = Differ.generate(jsonFile1, jsonFile2, "plain");
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToPlainDifferGenerate() throws Exception {
        var expected = readFixture(expectedPlainFile);
        var actual = Differ.generate(yamlFile1, yamlFile2, "plain");
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testJsonToJsonDifferGenerate() throws Exception {
        var expected = readFixture(expectedJsonFile);
        var actual = Differ.generate(jsonFile1, jsonFile2, "json");
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToJsonDifferGenerate() throws Exception {
        var expected = readFixture(expectedJsonFile);
        var actual = Differ.generate(yamlFile1, yamlFile2, "json");
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testGetFileFormat() {
        assertStringsEquals("yml", getFileFormat("file1.yml"));
        assertStringsEquals("json", getFileFormat("file1.my-lib.2024.json"));
    }


}
