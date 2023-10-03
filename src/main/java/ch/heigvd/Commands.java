package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

import picocli.CommandLine;

@CommandLine.Command(name="commands", description="My custom CLI", version = "1.0")
public class Commands implements Runnable {

    @CommandLine.Option(names = {"-i", "--input"}, required = true, description = "Input file")
    public static String optInputFile;

    @CommandLine.Option(names = {"-ie", "--input-encoding"}, description = "Input file encoding")
    public static Charset optInputFileEncoding;

    @CommandLine.Option(names = {"-o", "--output"}, required = true, description = "Output file")
    public static String optOutputFile;

    @CommandLine.Option(names = {"-oe", "--output-encoding"}, description = "Output file encoding")
    public static Charset optOutputFileEncoding;

    @CommandLine.Parameters(description = "Operations to perform (e.g., 'uppercase', 'lowercase', 'reverse', 'alternate')")
    private List<String> operations;

    @Override
    public void run() {
        // Try to process the file
        try {
            String input = ReadWriteFiles.readFile(optInputFile);
            String output = processFile(input);
            ReadWriteFiles.writeFile(output, optOutputFile);
        }
        // Catch the exception thrown by processFile()
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processFile(String input) {
        // Loop on all the parameters in the command line
        for (String operation : operations) {
            if (operation.equals("uppercase")) {
                input = input.toUpperCase();
            }
            else if (operation.equals("lowercase")) {
                input = input.toLowerCase();
            }
            else if (operation.equals("reverse")) {
                input = new StringBuilder(input).reverse().toString();
            }
            else if (operation.equals("alternate")) {
                // StringBuilder is used to concatenate strings
                StringBuilder sb = new StringBuilder();
                // Loop on the input string and alternate between upper and lower case
                for (int i = 0; i < input.length(); i++) {
                    if (i % 2 == 0) {
                        sb.append(Character.toUpperCase(input.charAt(i)));
                    } else {
                        sb.append(Character.toLowerCase(input.charAt(i)));
                    }
                }
                input = sb.toString();
            }
            else {
                throw new IllegalArgumentException("Invalid operation");
            }
        }
        return input;
    }
}