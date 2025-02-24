package com.dawn.origins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dawn.origins.repository")
public class OriginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OriginsApplication.class, args);
	}

}
