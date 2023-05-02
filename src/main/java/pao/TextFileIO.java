package pao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class TextFileIO {

    public static void main(String[] args) {
        Path inputPath = Path.of("src/main/java/pao/input.txt");
        Path outputPath = Path.of("src/main/java/pao/output.txt");

        try {
            // Read data from input.txt
            List<String> lines = Files.readAllLines(inputPath);

            // Process the data (e.g., reverse lines, sort lines)
            Collections.reverse(lines);

            // Write the processed data to output.txt
            Files.write(outputPath, lines, StandardOpenOption.CREATE);
            System.out.println("Data written to output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
