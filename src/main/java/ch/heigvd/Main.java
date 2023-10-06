package ch.heigvd;

import picocli.*;

public class Main {
    public static void main(String[] args) {
        CommandLine command = new CommandLine(new Commands());
        command.setUsageHelpAutoWidth(true);
        int exitCode = command.execute(args);
        System.exit(exitCode);
    }
}