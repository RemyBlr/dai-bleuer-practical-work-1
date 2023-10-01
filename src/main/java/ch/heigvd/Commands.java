package ch.heigvd;

import picocli.CommandLine;

import java.io.*;
import java.nio.charset.Charset;

@CommandLine.Command(name="commands", description="My custom CLI")
class Commands implements Runnable {

    @CommandLine.Option(names = {"-h", "--help"}, description = "Information about the CLI")
    private String optHelp;

    @CommandLine.Option(names = {"-i", "--input"}, required = true, description = "Input file")
    public static String optInputFile;

    @CommandLine.Option(names = {"-ie", "--input-encoding"}, description = "Input file encoding")
    private Charset optInputFileEncoding;

    @CommandLine.Option(names = {"-o", "--output"}, required = true, description = "Output file")
    public static String optOutputFile;

    @CommandLine.Option(names = {"-oe", "--output-encoding"}, description = "Output file encoding")
    private Charset optOutputFileEncoding;

    @CommandLine.Option(names = {"uppercase"}, description = "Converst input file to uppercase")
    private boolean optUppercase;

    @CommandLine.Option(names = {"lowercase"}, description = "Converts input file to lowercase")
    private boolean optLowercase;

    public void run() {
        if(optLowercase) {
            try {
                ReadWriteFiles.upperToLower();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (optUppercase) {
            try {
                ReadWriteFiles.lowerToUpper();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid option");
        }
    }
}
