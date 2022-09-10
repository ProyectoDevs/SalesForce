package com.salesForce.controller;

import com.salesForce.entity.Empleado;
import com.salesForce.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos:  |GET|POST|

    //Se puede crear un empleado segun post

    @PostMapping("/user")
    public List<Empleado> crearEmpleado (@RequestBody Empleado empleado){
        empleadoService.crearEmpleado (empleado);
        return empleadoService.consultarEmpleados ();
    }

    //Se puede consultar la lista de empleados
    @GetMapping("/user")
    public List<Empleado> consultarEmpleados (){
        List<Empleado> empleados = empleadoService.consultarEmpleados();
        return empleados;
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    @GetMapping("/user/{id_empleado}")
    public  Empleado consultarEmpleado (@PathVariable ("id_empleado") Long id_Empleado) {
        return empleadoService.consultarEmpleado (id_Empleado) ;
    }

    @DeleteMapping("/user/{id_empleado}")
    private List<Empleado> eliminarEmpleado (@PathVariable ("id_empleado") Long id) {
        empleadoService.borrarEmpleado(id);
        return empleadoService.consultarEmpleados();
    }

    @PatchMapping("/user/{id_empleado}/{nombreEmpleado}")
    public Empleado editarNombreEmpleado (@PathVariable ("id_empleado")Long id,@PathVariable ("nombreEmpleado") String nombreEmpleado ){
        empleadoService.editarNombreEmpleado(id,nombreEmpleado);
        return empleadoService.consultarEmpleado(id);
    }


}

