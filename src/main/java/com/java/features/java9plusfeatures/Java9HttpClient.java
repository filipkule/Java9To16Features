package com.java.features.java9plusfeatures;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Java9HttpClient {
    public static void main(String[] args) {
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://postman-echo.com/get"))// URI.create() another option
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
            System.out.println(response.body());
        } catch (URISyntaxException | IOException | InterruptedException  e) {
            e.printStackTrace();
        }
    }


}
