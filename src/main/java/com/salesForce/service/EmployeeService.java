package com.salesForce.service;

import com.salesForce.entity.Employee;
import com.salesForce.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee consultarEmpleado(Long id_employee) {
        return employeeRepository.findById(id_employee).get();
    }

    public void crearEmpleado (Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee editarNombreEmpleado (Long id, String nombreEmpleado) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setNombreEmpleado(nombreEmpleado);
        return employee;
    }

    public List<Employee> consultarEmpleados (){
        return new ArrayList<Employee>(employeeRepository.findAll());
    }

    public void borrarEmpleado (Long id_empleado) {
        employeeRepository.deleteById(id_empleado);
    }
}