package pao.animals;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WeatherApiClient {
    public static void main(String[] args) {
        HttpClient httpClient = HttpClient.newHttpClient();
        String apiUrl = "https://api.weatherapi.com/v1/current.json?key=YOUR_API_KEY&q=London";
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
    }
}
