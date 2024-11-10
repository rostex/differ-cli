package hexlet.code;

import hexlet.code.formatter.Format;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 0.8",
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {

    @Parameters(index = "0", description = "Path to first file")
    private String filePath1;

    @Parameters(index = "1", description = "Path to second file")
    private String filePath2;

    @Option(names = {"-f", "--format"}, description = "Output getStylishFormat."
            + " Available: stylish, plain, json [Default: stylish]")
    private Format defualtFormat = Format.STYLISH;

    @Override
    public Integer call() throws Exception {
        System.out.println(Differ.generateDiff(filePath1, filePath2, defualtFormat));
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
