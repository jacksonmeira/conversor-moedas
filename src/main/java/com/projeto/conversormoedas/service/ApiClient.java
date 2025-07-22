package com.projeto.conversormoedas.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiClient {
    private final RestTemplate restTemplate;
    private final String apiKey;

    public ApiClient(RestTemplate restTemplate,
                     @Value("${app.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public JsonObject fetchRates(String base) {
        String url = String.format(
                "https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, base);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Falha na requisição: HTTP " + response.getStatusCodeValue());
        }
        JsonObject root = JsonParser.parseString(response.getBody()).getAsJsonObject();
        return root.getAsJsonObject("conversion_rates");
    }
}