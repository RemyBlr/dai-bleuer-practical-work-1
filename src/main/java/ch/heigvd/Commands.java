package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import picocli.CommandLine;

@CommandLine.Command(name="commands", description="My custom CLI", version = "1.0")
public class Commands implements Runnable {

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = "display this help message")
    boolean usageHelpRequested;

    @CommandLine.Option(names = { "-V", "--version" }, versionHelp = true, description = "print version information and exit")
    boolean versionRequested;

    @CommandLine.Option(names = {"-i", "--input"}, required = true, description = "Input file")
    public static String optInputFile;

    @CommandLine.Option(names = {"-ie", "--input-encoding"}, description = "Input file encoding")
    public static Charset optInputFileEncoding;

    @CommandLine.Option(names = {"-o", "--output"}, required = true, description = "Output file")
    public static String optOutputFile;

    @CommandLine.Option(names = {"-oe", "--output-encoding"}, description = "Output file encoding")
    public static Charset optOutputFileEncoding;

    @CommandLine.Option(names = "uppercase", description = "Converst input file to uppercase")
    boolean optUppercase;

    @CommandLine.Option(names = "lowercase", description = "Converts input file to lowercase")
    boolean optLowercase;

    @CommandLine.Option(names = "alternate", description = "Alternate lower and uppercase letters")
    boolean optAlternate;

    @CommandLine.Option(names = "reverse", description = "Reverse the input file")
    boolean optReverse;

    @Override
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
        else if (optReverse) {
            try {
                ReadWriteFiles.reverse();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else if (optAlternate) {
            try {
                ReadWriteFiles.alternate();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new IllegalArgumentException("Invalid option");
        }
    }
}