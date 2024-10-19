package dev.KwadwoAK;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class ImageToBase64 {
    public static String DownloadImageAndConvertToBase64(String imageUrl) throws IOException, InterruptedException {
        try (var client = HttpClient.newHttpClient()) {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(imageUrl))
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofByteArray());

            return switch (response.statusCode()) {
                case 200 -> Base64.getEncoder().encodeToString(response.body());
                case 404 -> throw new IOException("Image not found (404)");
                case 403 -> throw new IOException("Access forbidden (403)");
                default -> throw new IOException("Failed to download image. HTTP status code: " + response.statusCode());
            };
        }

    }
}



