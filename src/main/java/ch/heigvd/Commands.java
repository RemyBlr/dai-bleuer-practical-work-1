package ch.heigvd;

import picocli.CommandLine;

import java.io.*;
import java.nio.charset.Charset;

@CommandLine.Command(name="commands", description="My custom CLI")
class Commands implements Runnable {

    @CommandLine.Option(names = {"-h", "--help"}, description = "Information about the CLI")
    private String optHelp;

    @CommandLine.Option(names = {"-f", "--file"}, description = "Input file")
    public static String optInputFile;

    @CommandLine.Option(names = {"-o", "--output"}, description = "Output file")
    public static String optOutputFile;

    @CommandLine.Option(names = {"-e", "--encoding"}, description = "File encoding")
    private Charset optEncoding;

    public void run() {
        String input = null;
        try {
            input = ReadWriteFiles.readFile(Commands.optInputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String output = input.toUpperCase();
        try {
            ReadWriteFiles.writeFile(output, Commands.optOutputFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
