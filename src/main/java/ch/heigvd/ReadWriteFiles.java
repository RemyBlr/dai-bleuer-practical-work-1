package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadWriteFiles {

    private static final Charset ENCODING = StandardCharsets.UTF_8;

    public static String readFile(String inputFileName) throws IOException {

        Charset encoding = ENCODING;
        if(Commands.optInputFileEncoding != null) {
            encoding = Commands.optInputFileEncoding;
        }

        FileReader reader = new FileReader(inputFileName, encoding);
        BufferedReader bufferedReader = new BufferedReader(reader);

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        reader.close();

        return sb.toString();
    }

    public static void writeFile(String data, String outputFileName) throws IOException {
        Charset encoding = ENCODING;
        if(Commands.optOutputFileEncoding != null) {
            encoding = Commands.optOutputFileEncoding;
        }

        FileWriter writer = new FileWriter(outputFileName, encoding);
        writer.write(data);
        writer.close();
    }

    public static void processFile() throws IOException {
        String input = readFile(Commands.optInputFile);
        String output = "";

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
            StringBuilder sb = new StringBuilder();
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