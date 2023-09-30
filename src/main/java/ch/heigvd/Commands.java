package ch.heigvd;

import picocli.CommandLine;
import java.util.concurrent.Callable;

@CommandLine.Command(name="commands", description="My custom CLI")
public class Commands {

    @CommandLine.Option(names = {"-h", "--help"}, description = "Information about the CLI")
    private String optHelp;

    @CommandLine.Option(names = {"-f", "--file"}, description = "Input file")
    private String optInputFile;

    @CommandLine.Option(names = {"-o", "--output"}, description = "Output file")
    private String optOutputFile;

    @CommandLine.Option(names = {"-e", "--encoding"}, description = "File encoding")
    private String optEncoding;
}
