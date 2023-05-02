package pao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiFetcher {
    public static void main(String[] args) {
        // Create an instance of HttpClient
        HttpClient httpClient = HttpClient.newHttpClient();

        // Create an instance of HttpRequest with the URL
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/todos/1"))
                .build();

        // Send the GET request and get the response as a string
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            // Print the JSON response
            System.out.println(httpResponse.body());

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
