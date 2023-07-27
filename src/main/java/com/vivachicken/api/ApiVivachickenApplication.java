package com.vivachicken.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ApiVivachickenApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiVivachickenApplication.class, args);
	}

}
