package com.salesForce.controller;

import com.salesForce.entity.Empleado;
import com.salesForce.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/employees")
    public void crearEmpleado (Empleado empleado){
        empleadoService.crearEmpleado(empleado);

    }
    @GetMapping("/employees")
    public  Empleado obtenerEmpleado (Long id_Empleado) {
        return empleadoService.consultarEmpleado (id_Empleado) ;

    }
    @DeleteMapping("/employees/{id}")
    private  void eliminarEmpleado (Long id) {
           empleadoService.borrarEmpleado(Long id);

    }
    @PatchMapping("/employees") {
        public
    }


}

