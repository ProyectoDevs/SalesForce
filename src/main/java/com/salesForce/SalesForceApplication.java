package com.salesForce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.salesForce.controller","com.salesForce.repository","com.salesForce.service"})
public class SalesForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesForceApplication.class, args);

	}

}
