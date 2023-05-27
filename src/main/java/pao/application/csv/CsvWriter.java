package pao.application.csv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvWriter {
    private static final String CSV_PATH_WRITE = "csv/twoColumn-write.csv";

    private static final String CUSTOM_FILE_PATH_1 = "files/";

    private static final String FILE_NAME = "file_name.txt";

    private static final String FULL_PATH_FILE_NAME_1 = CUSTOM_FILE_PATH_1 + FILE_NAME;
    private static CsvWriter INSTANCE;
    private CsvWriter() {
    }

    public static CsvWriter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CsvWriter();
        }

        return INSTANCE;
    }

    public String writeLineByLine(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toFile()))) {
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }
        // Read the file and return its contents
        return Files.readString(path);
    }

    public String writeAllLines(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        }
        return Files.readString(path);
    }

    public String executeLineByLine(List<String[]> lines) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_WRITE).toURI());

        return writeLineByLine(lines, path);
    }

    public String executeAllLines(List<String[]> lines) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_WRITE).toURI());

        return writeAllLines(lines, path);
    }
}
