package com.salesForce.controller;

import com.salesForce.entity.Employee;
import com.salesForce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos:  |GET|POST|
    //Se puede crear un empleado segun post

    @PostMapping("/user")
    public List<Employee> crearEmpleado (@RequestBody Employee employee){
        employeeService.crearEmpleado (employee);
        return employeeService.consultarEmpleados ();
    }

    //Se puede consultar la lista de empleados
    @GetMapping("/user")
    public List<Employee> consultarEmpleados (){
        List<Employee> employee = employeeService.consultarEmpleados();
        return employee;
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    @GetMapping("/user/{id_empleado}")
    public  Employee consultarEmpleado (@PathVariable ("id_empleado") Long id_Empleado) {
        return employeeService.consultarEmpleado (id_Empleado) ;
    }

    @DeleteMapping("/user/{id_empleado}")
    private List<Employee> eliminarEmpleado (@PathVariable ("id_empleado") Long id) {
        employeeService.borrarEmpleado(id);
        return employeeService.consultarEmpleados();
    }

    @PatchMapping("/user/{id_empleado}/{nombreEmpleado}")
    public Employee editarNombreEmpleado (@PathVariable ("id_empleado")Long id,@PathVariable ("nombreEmpleado") String nombreEmpleado ){
        employeeService.editarNombreEmpleado(id,nombreEmpleado);
        return employeeService.consultarEmpleado(id);
    }

}
