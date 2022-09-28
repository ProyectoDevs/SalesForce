package com.salesForce.controller;


import com.salesForce.entity.Employee;
import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EmployeeService;
import com.salesForce.service.EnterpriseService;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private EmployeeService employeeService;


    //@AuthenticationPrincipal OidcUser principal
    @GetMapping("/")
    public String verHome(Model model, @AuthenticationPrincipal OidcUser principal) {
        var titulo = "Home";
        model.addAttribute("movimientos",movimientoDineroService.getLstMovimientos());


        model.addAttribute("titulo", titulo);
        return "home";
    }

    // Visualizar |Empresas|Empleados|Movimientos|Usuarios|
    @GetMapping("/empresas")
    public String verEnterprise(Model model) {
        model.addAttribute("titulo","empresas");
        model.addAttribute("enterprises",enterpriseService.findEnterprises());
        return "layout/enterprises/enterprise";
    }

    @GetMapping("/movimientos")
    public String verMovements(Model model) {
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        model.addAttribute("titulo","movimientos");
        return "layout/movements/movements";
    }

    @GetMapping("/empleados")
    public String verEmpleados(Model model) {
        model.addAttribute("employees", employeeService.consultarEmpleados());
        model.addAttribute("titulo","Empleados");
        return "layout/employees/employee";
    }

    @GetMapping("/formEmpresa")
    public String crearEmpresa(Model model, Enterprise enterprise){
        model.addAttribute("enteprise",new Enterprise());
        model.addAttribute("titulo", "formulario-Empresa");
        return "/layout/enterprises/crearEmpresa";
    }

    @GetMapping("/formEmployee")
    public String crearEmpleado(Model model, Employee employee){
        model.addAttribute("employee",new Employee());
        model.addAttribute("titulo", "formulario-Empleados");
        return "/layout/employees/formEmployee";
    }

    @GetMapping("/formActEmpresa/{id_enterprise}")
    public String editarEmpresa (@PathVariable ("id_enterprise") Long id, Model model) {
        model.addAttribute("enterprise", enterpriseService.findEnterprise(id) );
        model.addAttribute("titulo","formulario-Actualiza-Empresa");
        model.addAttribute("id_enterprise", id);
        return "/layout/enterprises/actualizarEmpresa";
    }

    @GetMapping("/formActEmpleado/{id_employee}")
    public String editarEmpleado (@PathVariable ("id_employee") Long id, Model model) {
        model.addAttribute("employee", employeeService.consultarEmpleado(id) );
        model.addAttribute("titulo","formulario-Actualiza-Empleado");
        model.addAttribute("id_employee", id);
        return "/layout/employees/actualizarEmpleado";
    }

    @GetMapping("/crearempleado")
    public String ingresarEmpleados(Model model) {
        return "layout/formEmployee";
    }

    // Metodos para Movements - Luis Gabriel


    @GetMapping(value="/new-movement")
    public ModelAndView newMovement(Model model, MovimientoDinero movimientoDinero) {
        var enterprises = enterpriseService.findEnterprises();
        model.addAttribute("enterprises",enterprises);
        var employees = employeeService.consultarEmpleados();
        model.addAttribute("employees",employees);
        model.addAttribute("movimientoDinero",new MovimientoDinero());
        model.addAttribute("titulo","Crear Movimiento");
        return new ModelAndView("layout/movements/newMovement");
    }

    @GetMapping(value = "/update-movement/{id_transaction}")
    public String movementById(@PathVariable("id_transaction") Long id_transaction, Model model) {

        MovimientoDinero movimientoDinero = movimientoDineroService.getMovimientoById(id_transaction);
        model.addAttribute("movimientoDinero", movimientoDinero);

        var enterprises = enterpriseService.findEnterprises();
        model.addAttribute("enterprises",enterprises);

        var employees = employeeService.consultarEmpleados();
        model.addAttribute("employees",employees);

        model.addAttribute("titulo","Actualizar Movimiento");

        return "layout/movements/updateMovement";
    }
}