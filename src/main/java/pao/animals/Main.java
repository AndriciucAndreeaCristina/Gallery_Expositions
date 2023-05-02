package pao.animals;

import pao.animals.exceptions.InvalidAnimal;
import pao.animals.exceptions.InvalidDate;
import pao.animals.exceptions.InvalidSpeed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws InvalidAnimal, InvalidDate, InvalidSpeed, IOException {

        //logger.setLevel(Level.INFO);
        //logger.info("Starting the operation...");

        try {
            Path filePath = Paths.get("src/main/java/pao/animals/sightings.txt");

            try {
                List<String> lines = Files.readAllLines(filePath);

                // Process the read lines as needed
                for (String line : lines) {
                    // Do something with each line
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred", e);
        }

        InputStream configFile = Main.class.getResourceAsStream("/logging.properties");
        LogManager.getLogManager().readConfiguration(configFile);

        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = "https://apiv3.iucnredlist.org/api/v3/species/region/europe/page/0?token=9bb4facb6d23f48efbf424bb05c0c1ef1cf6f468393bc745d42179ac4aca5fee";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Process the response
            int statusCode = response.statusCode();
            String responseBody = response.body();

            // Example: Print the response body
            System.out.println(responseBody);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        MammalHandler mammalHandler = new MammalHandler();
        BirdHandler birdHandler = new BirdHandler();
        ReptileHandler reptileHandler = new ReptileHandler();

        Animal animal1 = new Mammal("Lion");
        Animal animal2 = new Bird("Eagle");
        Animal animal3 = new Reptile("Snake");

        mammalHandler.handleAnimal(animal1); // Output: Handling mammal: Lion
        birdHandler.handleAnimal(animal2); // Output: Handling bird: Eagle
        reptileHandler.handleAnimal(animal3); // Output: Handling reptile: Snake

    }
}
