package com.dawn.origins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.dawn.origins.repository")
@OpenAPIDefinition(info = @io.swagger.v3.oas.annotations.info.Info(title = "HNG 12 API Documentation", version = "1.0", description = "HNG 12 STAGE TASKS FOR API Documentation"))
public class OriginsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OriginsApplication.class, args);
	}

}
