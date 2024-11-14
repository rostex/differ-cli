package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hexlet.code.formatter.Extension;
import hexlet.code.formatter.Format;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;


public class DifferTest {
    private String jsonFile1 = "src/test/resources/testfile1.json";
    private String jsonFile2 = "src/test/resources/testfile2.json";
    private String yamlFile1 = "src/test/resources/testfile1.yml";
    private String yamlFile2 = "src/test/resources/testfile2.yml";
    private String xmlFile1 = "src/test/resources/testfile1.yml";
    private String xmlFile2 = "src/test/resources/testfile2.yml";

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
    public void testJsonToDefaultDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(jsonFile1, jsonFile2);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToDefaultDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(yamlFile1, yamlFile2);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testXmlToDefaultDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(xmlFile1, xmlFile2);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testJsonToStylishDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(jsonFile1, jsonFile2, Format.STYLISH);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToStylishDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(yamlFile1, yamlFile2, Format.STYLISH);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testXmlToStylishDifferGenerate() throws Exception {
        var expected = readFixture(expectedStylishFile);
        var actual = Differ.generateDiff(xmlFile1, xmlFile2, Format.STYLISH);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testJsonToPlainDifferGenerate() throws Exception {
        var expected = readFixture(expectedPlainFile);
        var actual = Differ.generateDiff(jsonFile1, jsonFile2, Format.PLAIN);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToPlainDifferGenerate() throws Exception {
        var expected = readFixture(expectedPlainFile);
        var actual = Differ.generateDiff(yamlFile1, yamlFile2, Format.PLAIN);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testXmlToPlainDifferGenerate() throws Exception {
        var expected = readFixture(expectedPlainFile);
        var actual = Differ.generateDiff(xmlFile1, xmlFile2, Format.PLAIN);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testJsonToJsonDifferGenerate() throws Exception {
        var expected = readFixture(expectedJsonFile);
        var actual = Differ.generateDiff(jsonFile1, jsonFile2, Format.JSON);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testYamlToJsonDifferGenerate() throws Exception {
        var expected = readFixture(expectedJsonFile);
        var actual = Differ.generateDiff(yamlFile1, yamlFile2, Format.JSON);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testXmlToJsonDifferGenerate() throws Exception {
        var expected = readFixture(expectedJsonFile);
        var actual = Differ.generateDiff(xmlFile1, xmlFile2, Format.JSON);
        assertStringsEquals(expected, actual);
    }

    @Test
    public void testGetFileFormat() throws Exception {
        assertStringsEquals("yml", Extension.getFileExtension("file1.yml"));
        assertStringsEquals("json", Extension.getFileExtension("file1.my-lib.2024.json"));
    }


}
