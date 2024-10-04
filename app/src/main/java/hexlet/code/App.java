package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
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
        System.out.println(JsonParse.getDiff(getData(filePath1), getData(filePath2)));
        //System.out.println(getData(filePath1));
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

//    public static void getData(String ... filePath) throws Exception {
//        var filePaths = List.of(filePath);
//
//        filePaths.forEach((value) -> {
//        ObjectMapper objectMapper = new ObjectMapper();
//        File file = new File(value);
//            try {
//                Map<String, String> = objectMapper.readValue(file, Server.class);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//    }

    public static Map getData(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filePath);
        return objectMapper.readValue(file, Map.class);

    }


    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
