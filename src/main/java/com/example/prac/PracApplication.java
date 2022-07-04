package com.example.prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PracApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracApplication.class, args);
	}

}
