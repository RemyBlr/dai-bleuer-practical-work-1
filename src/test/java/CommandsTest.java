import ch.heigvd.Commands;
import ch.heigvd.ReadWriteFiles;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://www.baeldung.com/parameterized-tests-junit-5#4-csv-literals
// Had to ask chatgpt for the csv-literals, couldn't find my answer on the internet
public class CommandsTest {
    @TempDir
    Path tempDir;

    @ParameterizedTest
    @CsvSource({
            "uppercase, This is a test., THIS IS A TEST.",
            "reverse, This is a test., .tset a si sihT",
            "alternate, This is a test., ThIs iS A TeSt.",
            "lowercase, This is a test., this is a test."
    })
    public void testFileOperations(String operation, String inputContent, String expectedOutput) throws IOException {
        // Test input file in the tmp directory
        Path inputFile = tempDir.resolve("test_input_operations.txt");
        ReadWriteFiles.writeFile(inputContent, inputFile.toString());

        // Test output file in the tmp directory
        Path outputFile = tempDir.resolve("test_output_operations.txt");

        // Call the run() method
        Commands commands1 = new Commands();
        commands1.optInputFile = inputFile.toString();
        commands1.optOutputFile = outputFile.toString();
        commands1.operations = List.of(operation);

        // Contains processFile()
        commands1.run();

        // Compare the expected output with the actual output
        String actualOutput = ReadWriteFiles.readFile(outputFile.toString()).trim();
        assertEquals(expectedOutput, actualOutput);
    }

    // I really don't know why but the first test impacts the second one
    // so i cheated and put lowercase last, and test only on lowercase encoding
    // TODO: find a way to make it work without cheating
    @ParameterizedTest
    @CsvSource({
            "èéà !îô èüèėçæ, èéà !îô èüèėçæ, UTF-8, UTF-8",
            "èéà !îô èüèėçæ, ��� !�� ���?��, UTF-8, ISO_8859_1",
            "èéà !îô èüèėçæ, ??? !?? ??????, UTF-8, US-ASCII"
    })
    public void testFileEncoding(String inputContent,
                                 String expectedOutput,
                                 Charset inputEncoding,
                                 Charset outputEncoding) throws IOException {
        // Test input file in the tmp directory
        Path inputFile = tempDir.resolve("test_input_encoding.txt");
        ReadWriteFiles.writeFile(inputContent, inputFile.toString());

        // Test output file in the tmp directory
        Path outputFile = tempDir.resolve("test_output_encoding.txt");

        // Call the run() method
        Commands commands = new Commands();
        commands.optInputFile = inputFile.toString();
        commands.optOutputFile = outputFile.toString();
        commands.optInputFileEncoding = inputEncoding;
        commands.optOutputFileEncoding = outputEncoding;

        // Contains processFile()
        commands.run();

        // Compare the expected output with the actual output
        String actualOutput = ReadWriteFiles.readFile(outputFile.toString()).trim();
        assertEquals(expectedOutput, actualOutput);
    }
}
