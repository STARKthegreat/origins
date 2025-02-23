package com.dawn.origins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Secret;

@SpringBootApplication
public class OriginsApplication {

	public static void main(String[] args) {
		Secret.setSecret();
		SpringApplication.run(OriginsApplication.class, args);
	}

}
