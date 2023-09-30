package ch.heigvd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.debug("Hello World!");

        CommandLine commandLine = new CommandLine(new Commands());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }
}