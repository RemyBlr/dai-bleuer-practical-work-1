package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadWriteFiles {

    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static String readFile(String inputFileName) throws IOException {
        Charset encoding = ENCODING;
        // Sets the input encoding specified by the user if it exists
        if(Commands.optInputFileEncoding != null) {
            encoding = Commands.optInputFileEncoding;
        }

        // FileReader because i deal with characters and not bytes
        FileReader reader = new FileReader(inputFileName, encoding);
        // BufferReader makes the reading more efficient when calling readLine() and read()
        BufferedReader bufferedReader = new BufferedReader(reader);

        // StringBuilder is used to concatenate strings
        StringBuilder sb = new StringBuilder();
        String line;
        // Read the file line by line
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        // Release resources
        reader.close();

        return sb.toString();
    }

    public static void writeFile(String data, String outputFileName) throws IOException {
        Charset encoding = ENCODING;
        // Sets the output encoding specified by the user if it exists
        if(Commands.optOutputFileEncoding != null) {
            encoding = Commands.optOutputFileEncoding;
        }

        FileWriter writer = new FileWriter(outputFileName, encoding);
        // Write the data to the file
        writer.write(data);
        // Release resources
        writer.close();
    }

    public static void processFile() throws IOException {
        String input = readFile(Commands.optInputFile);
        String output = "";

        // Done this way to avoid multiple calls on read/writeFile
        if (Commands.optUppercase) {
            output = input.toUpperCase();
        }
        else if (Commands.optLowercase) {
            output = input.toLowerCase();
        }
        else if (Commands.optReverse) {
            output = new StringBuilder(input).reverse().toString();
        }
        else if (Commands.optAlternate) {
            // StringBuilder is used to concatenate strings
            StringBuilder sb = new StringBuilder();
            // Loop on the input string and alternate between upper and lower case
            for (int i = 0; i < input.length(); i++) {
                if (i % 2 == 0) {
                    sb.append(Character.toUpperCase(input.charAt(i)));
                } else {
                    sb.append(Character.toLowerCase(input.charAt(i)));
                }
            }
            output = sb.toString();
        }
        else {
            throw new IllegalArgumentException("Invalid operation");
        }

        writeFile(output, Commands.optOutputFile);
    }

}