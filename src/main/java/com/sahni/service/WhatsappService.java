package com.sahni.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
public class WhatsappService {

    @Value("${whatsapp.api.url}")
    private String apiUrl;

    @Value("${whatsapp.phone.number.id}")
    private String phoneNumberId;

    @Value("${whatsapp.access.token}")
    private String accessToken;

    // Method to send a template message
    public String sendTemplateMessage(String phoneNumber, String templateName) {
        // Construct the URL with phone number ID
        String url = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .pathSegment(phoneNumberId, "messages")
                .toUriString();

        // Create HTTP Headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        headers.set("Content-Type", "application/json");

        // Construct the request body with the template
        Map<String, Object> body = new HashMap<>();
        body.put("messaging_product", "whatsapp");  // This is mandatory
        body.put("to", phoneNumber);
        body.put("type", "template");

        // Include template details in the request body
        Map<String, Object> template = new HashMap<>();
        template.put("name", templateName);  // The template name from WhatsApp Business API
        Map<String, String> language = new HashMap<>();
        language.put("code", "en_US");  // Language code for the template
        template.put("language", language);
        body.put("template", template);

        // Debugging: Log the request body
        System.out.println("Request Body: " + body);

        // Create the request entity
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        // Send the POST request to the WhatsApp API
        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);

            // Log the response for debugging
            System.out.println("Response: " + response.getBody());

            // If the request is successful, the status code will be OK
            if (response.getStatusCode() == HttpStatus.OK) {
                return "Message successfully sent to " + phoneNumber;
            } else {
                return "Failed to send message. Response: " + response.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}
