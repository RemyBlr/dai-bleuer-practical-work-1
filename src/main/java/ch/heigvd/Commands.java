package ch.heigvd;

import picocli.CommandLine;
import java.io.*;
import java.nio.charset.Charset;

@CommandLine.Command(name="Cli", description="My custom CLI")
public class Cli {

    @CommandLine.Option(names = {"-h", "--help"}, description = "Information about the CLI")
    private String optHelp;

    @CommandLine.Option(names = {"-f", "--file"}, description = "Input file")
    private String optInputFile;

    @CommandLine.Option(names = {"-o", "--output"}, description = "Output file")
    private String optOutputFile;

    @CommandLine.Option(names = {"-e", "--encoding"}, description = "File encoding")
    private Charset optEncoding;
}
