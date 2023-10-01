package ch.heigvd;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadWriteFiles {
    public static String readFile(String inputFileName) throws IOException {

        Charset encoding = StandardCharsets.UTF_8;
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
        Charset encoding = StandardCharsets.UTF_8;
        if(Commands.optOutputFileEncoding != null) {
            encoding = Commands.optOutputFileEncoding;
        }

        FileWriter writer = new FileWriter(outputFileName, encoding);
        writer.write(data);
        writer.close();
    }

    public static void lowerToUpper() throws IOException {
        String input = readFile(Commands.optInputFile);
        String output = input.toUpperCase();
        writeFile(output, Commands.optOutputFile);
    }

    public static void upperToLower() throws IOException {
        String input = readFile(Commands.optInputFile);
        String output = input.toLowerCase();
        writeFile(output, Commands.optOutputFile);
    }


}