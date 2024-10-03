package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.1",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> {

    @Parameters(index = "0", description = "path to first file")
    private static String filePath1;

    @Parameters(index = "1", description = "path to second file")
    private String filePath2;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Override
    public String call() throws Exception { // your business logic goes here...
        //readfile(filePath1, filePath2);
        parse(filePath1, filePath2);
        return null;
    }

    /*

    private void readfile(String ... filepath) {
        var filepaths = List.of(filepath);
        filepaths.forEach((value) -> {
            Path path = Paths.get(value).toAbsolutePath().normalize();
            try {
                System.out.println(Files.readString(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

     */

    public static void parse(String ... filePath) throws Exception {
        var filePaths = List.of(filePath);

        filePaths.forEach((value) -> {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(value);
            try {
                HashMap<String, String> server = objectMapper.readValue(file, Server.class);
                System.out.println(server);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }


    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
