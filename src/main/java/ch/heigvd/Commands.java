package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import picocli.CommandLine;

@CommandLine.Command(name="commands",
        version = "1.0",
        description="Various operations on files (uppercase, lowercase, reverse, alternate)",
        descriptionHeading = "%n@|bold,underline Description|@:%n%n",
        optionListHeading = "%n@|bold,underline Options|@:%n%n",
        parameterListHeading = "%n@|bold,underline Parameters|@:%n%n",
        commandListHeading = "%n@|bold,underline Commands|@:%n%n")
public class Commands implements Runnable {

    // I need the version and help options so it can be displayed
    @CommandLine.Option(names = {"-V", "--version"}, versionHelp = true, description = "display version info")
    boolean versionInfoRequested;

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Option(names = {"-i", "--input"}, required = true, description = "Input file")
    public String optInputFile;

    @CommandLine.Option(names = {"-ie", "--input-encoding"}, description = "Input file encoding")
    public static Charset optInputFileEncoding;

    @CommandLine.Option(names = {"-o", "--output"}, required = true, description = "Output file")
    public String optOutputFile;

    @CommandLine.Option(names = {"-oe", "--output-encoding"}, description = "Output file encoding")
    public static Charset optOutputFileEncoding;

    @CommandLine.Parameters(description = "Operations to perform (e.g., 'uppercase', 'lowercase', 'reverse', 'alternate')")
    public static List<String> operations;

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();

        // Try to process the file
        try {
            String input = ReadWriteFiles.readFile(optInputFile);
            String output = ProcessFiles.processFile(input);
            ReadWriteFiles.writeFile(output, optOutputFile);
        }
        // Catch the exception thrown by processFile()
        catch (IOException e) {
            System.err.println("The error is : " + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime; // in milliseconds

        // Convert to seconds
        double executionTimeSeconds = executionTime / 1000.0;
        System.out.println("File was processed in " + executionTimeSeconds + " seconds.");
    }
}