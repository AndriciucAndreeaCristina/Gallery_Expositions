package pao.gateways;

import pao.services.impl.artworks.ArtistInterfaceImplementation;
import pao.services.interfaces.artworks.ArtistInterface;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    private ArtistInterface artistInterface = new ArtistInterfaceImplementation();
    public void saveNewArtistInfo() throws URISyntaxException, IOException, InterruptedException {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://galleryguide.me/api/artists"))
                    .GET()
                    .build();

            var httpResponse = httpClient.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());
            System.out.println(httpResponse.body());
            System.out.println();

        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
