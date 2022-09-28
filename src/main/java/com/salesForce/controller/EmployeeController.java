package com.salesForce.controller;

import com.salesForce.entity.Employee;
import com.salesForce.entity.Enterprise;
import com.salesForce.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/crearEmpleado")
    public RedirectView newEmployee (Model model, Employee employee) {
        employeeService.crearEmpleado(employee);
        return new RedirectView("/empleados");
    }

    @GetMapping("eliminarEmpleado/{id_employee}" )
    public RedirectView deleteEmployee (@PathVariable ("id_employee") Long id){
        employeeService.borrarEmpleado(id);
        return new RedirectView ("/empleados");
    }

    @PostMapping("actualizarEmpleado/{id_employee}" )
    public RedirectView updateEmployee (@PathVariable ("id_employee") Long id, Employee employee){
        employeeService.crearEmpleado(employee);
        return new RedirectView ("/empleados");
    }

}
