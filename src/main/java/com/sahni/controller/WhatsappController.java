package com.sahni.controller;


import com.sahni.Model.WhatsappMessageRequest;
import com.sahni.service.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/whatsapp")
public class WhatsappController {


    @Autowired
    private WhatsappService whatsappService;

    @PostMapping("/send")
    public ResponseEntity<String> sendCustomMessage(@RequestBody WhatsappMessageRequest messageRequest) {
        // Print the incoming request for debugging
        System.out.println("Received request: " + messageRequest);

        // Call the WhatsApp service to send the custom message
        String message = whatsappService.sendTemplateMessage(
                messageRequest.getPhoneNumber(),
                messageRequest.getTemplateName() // Here templateName is being used as custom message
        );

        // Return the message wrapped in ResponseEntity with a status code of OK (200)
        return ResponseEntity.ok(message);
    }


}
