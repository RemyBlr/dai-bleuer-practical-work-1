package ch.heigvd;

import java.io.*;

public class ReadWriteFiles {
    public static String readFile(String inputFileName) throws IOException {
        FileReader reader = new FileReader(inputFileName);
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
        FileWriter writer = new FileWriter(outputFileName);
        writer.write(data);
        writer.close();
    }
}