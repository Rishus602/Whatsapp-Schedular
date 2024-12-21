package com.sahni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WhatsappSchedularApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsappSchedularApplication.class, args);
	}

}
