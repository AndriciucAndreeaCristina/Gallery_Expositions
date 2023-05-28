package pao.gateways;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import pao.mappers.ArtistMapper;
import pao.model.abstracts.Artist;
import pao.services.impl.artworks.ArtistInterfaceImplementation;
import pao.services.interfaces.artworks.ArtistInterface;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests implements Runnable{
    private static HttpClient httpClient = HttpClient.newHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ArtistMapper artistMapper = ArtistMapper.getInstance();
    private static final ArtistInterface artistInterface = new ArtistInterfaceImplementation();

    public void saveNewArtistInfo() throws URISyntaxException, IOException, InterruptedException {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://api.artic.edu/api/v1/artworks"))
                    .GET()
                    .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String responseBody = httpResponse.body();
            JsonNode content = objectMapper.readTree(responseBody);

            for (JsonNode jsonNode : content.get("data")) {
                Artist artist = artistMapper.artistMapper(jsonNode);
                //System.out.println("Artist2: " + artist.getFirstName());
                artistInterface.addArtist(artist);
            }


//            System.out.println(httpResponse.body());
//            System.out.println();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            saveNewArtistInfo();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
