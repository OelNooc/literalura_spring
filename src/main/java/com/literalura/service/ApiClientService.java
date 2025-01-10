package com.literalura.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service
public class ApiClientService {
    private final HttpClient httpClient;

    public ApiClientService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String sendHttpGet(String url) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                return response.body();
            } else {
                throw new RuntimeException("Error en la petición: HTTP " + response.statusCode()
                        + " - " + response.body());
            }

        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error al realizar la petición HTTP: " + e.getMessage(), e);
        }
    }
}
