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
    static boolean optUppercase;

    @CommandLine.Option(names = "lowercase", description = "Converts input file to lowercase")
    static boolean optLowercase;

    @CommandLine.Option(names = "alternate", description = "Alternate lower and uppercase letters")
    static boolean optAlternate;

    @CommandLine.Option(names = "reverse", description = "Reverse the input file")
    static boolean optReverse;

    @Override
    public void run() {
        try {
            ReadWriteFiles.processFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}