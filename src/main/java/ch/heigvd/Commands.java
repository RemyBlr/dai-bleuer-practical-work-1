package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

import picocli.CommandLine;

@CommandLine.Command(name="commands", description="My custom CLI", version = "1.0")
public class Commands implements Runnable {

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
    }
}