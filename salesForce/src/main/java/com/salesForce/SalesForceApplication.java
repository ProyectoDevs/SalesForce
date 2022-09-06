package com.salesForce;

import com.salesForce.model.Empleado;
import com.salesForce.model.Empresa;
import com.salesForce.model.MovimientoDinero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesForceApplication.class, args);

		System.out.println("");
		Empleado unEmpleado = new Empleado();

		unEmpleado.setNombreEmpleado("Jairo Morales Rodriguez.com");
		unEmpleado.setEmailEmpleado("jmr1309@gmail.com");
		unEmpleado.setEmpresaEmpleado("ForceSales");
		unEmpleado.setRolEmpleado("Desarrolador");

		//System.out.println("Id: " +unEmpleado.getId());
		System.out.println("Nombre Empleado " +unEmpleado.getNombreEmpleado());
		System.out.println("Email: " +unEmpleado.getEmailEmpleado());
		System.out.println("Empresa: " +unEmpleado.getEmpresaEmpleado());
		System.out.println("Rol del Empleado: " +unEmpleado.getRolEmpleado());

		System.out.println("");

		Empresa miEmpresa = new Empresa();

		miEmpresa.setNombreEmpresa("Sales Force");
		miEmpresa.setNitEmpresa("123456789");
		miEmpresa.setTelefonoEmpresa("+57 602333333");
		miEmpresa.setDireccionEmpresa("Calle 1 carrera 2");

		System.out.println("Nombre de la empresa:" + miEmpresa.getNombreEmpresa());
		System.out.println("Nit de la empresa:" + miEmpresa.getNitEmpresa());
		System.out.println("Dirección de la empresa:" + miEmpresa.getDireccionEmpresa());
		System.out.println("Teléfono de la empresa:" + miEmpresa.getTelefonoEmpresa());

		System.out.println("");
		MovimientoDinero entrada1 =new MovimientoDinero();
		entrada1.setMontoMovimiento(1200000);
		entrada1.setConceptoMovimiento("Pago alquiler");
		entrada1.setUsuarioMovimiento("Administrador");

		System.out.println("El valor del movimiento fue : " +entrada1.getMontoMovimiento());
		System.out.println("El concepto del movimiento fue : " +entrada1.getConceptoMovimiento());
		System.out.println("El usuario del movimiento fue: " +entrada1.getUsuarioMovimiento());
	}

}
