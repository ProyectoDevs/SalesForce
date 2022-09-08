package com.salesForce;

import com.salesForce.entity.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesForceApplication.class, args);

		MovimientoDinero movimiento = new MovimientoDinero();
	}

}
