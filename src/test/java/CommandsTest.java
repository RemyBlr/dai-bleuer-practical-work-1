import ch.heigvd.Commands;
import ch.heigvd.ReadWriteFiles;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.baeldung.com/parameterized-tests-junit-5#4-csv-literals
public class CommandsTest {
    @TempDir
    Path tempDir;

    @ParameterizedTest
    @CsvSource({
            "uppercase, This is a test., THIS IS A TEST.",
            "lowercase, This is a test., this is a test.",
            "reverse, This is a test., .tset a si sihT",
            "alternate, This is a test., ThIs iS A TeSt."
    })
    public void testFileOperations(String operation, String inputContent, String expectedOutput) throws IOException {
        // Test input file in the tmp directory
        Path inputFile = tempDir.resolve("test_input.txt");
        ReadWriteFiles.writeFile(inputContent, inputFile.toString());

        // Test output file in the tmp directory
        Path outputFile = tempDir.resolve("test_output.txt");

        // Call the run() method
        Commands commands = new Commands();
        commands.optInputFile = inputFile.toString();
        commands.optOutputFile = outputFile.toString();
        commands.operations = List.of(operation);

        // Contains processFile()
        commands.run();

        // Compare the expected output with the actual output
        String actualOutput = ReadWriteFiles.readFile(outputFile.toString());
        assertEquals(expectedOutput, actualOutput);
    }
}
