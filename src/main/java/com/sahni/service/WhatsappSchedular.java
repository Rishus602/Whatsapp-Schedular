package com.sahni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WhatsappSchedular {

@Autowired
private WhatsappService whatsappService;


    @Scheduled(fixedRate = 3000)
    public void sendScheduleMessage(){

        try {


            String phoneNumber = "919914513318";
            String templateName = "hello_world";

            String message = whatsappService.sendTemplateMessage(phoneNumber, templateName);

            System.out.printf("Schedule message sent: " + message);
        }
        catch (Exception err){
            System.out.println("Error Sending Message: " + err.getMessage());
        }
    }
}
