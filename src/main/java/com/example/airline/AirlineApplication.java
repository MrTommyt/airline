package com.example.airline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("com.example.airline.repositories")
@EntityScan("com.example.airline")
@SpringBootApplication(scanBasePackages = { "com.example.airline" })
@EnableTransactionManagement
public class AirlineApplication {

	private static final Logger logger = LoggerFactory.getLogger(AirlineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AirlineApplication.class, args);
	}

}
