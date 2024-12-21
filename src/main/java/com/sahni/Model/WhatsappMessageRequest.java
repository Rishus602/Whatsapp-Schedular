package com.sahni.Model;


//import lombok.*;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class WhatsappMessageRequest {

    private String phoneNumber;
    private String templateName;
//    private String languageCode;
    // Getters and Setters


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
