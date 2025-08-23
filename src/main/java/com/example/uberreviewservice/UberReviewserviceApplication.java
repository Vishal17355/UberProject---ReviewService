package com.example.uberreviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
 @SpringBootApplication
 @EnableJpaAuditing
public class UberReviewserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UberReviewserviceApplication.class, args);
	}
}
