package com.salesForce;

//import com.salesForce.controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.salesForce.controller","com.salesForce.repository","com.salesForce.service"})
public class SalesForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesForceApplication.class, args);

	}

}
