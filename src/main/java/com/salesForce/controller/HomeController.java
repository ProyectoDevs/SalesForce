package com.salesForce.controller;


<<<<<<< HEAD
import com.salesForce.entity.Employee;
=======
import com.salesForce.entity.Enterprise;
>>>>>>> ec5e1db005e59abf2d13d2cd92998f75b69d2a1f
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EmployeeService;
import com.salesForce.service.EnterpriseService;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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
        var titulo = "Home !!!";
        log.info("saludos desde Home");
        model.addAttribute("titulo", titulo);
        return "home";
    }

    // Visualizar |Empresas|Empleados|Movimientos|Usuarios|
    @GetMapping("/empresas")
    public String verEnterprise(Model model) {
        String title = "Empresas";
        model.addAttribute("title",title);
        model.addAttribute("enterprises",enterpriseService.findEnterprises());
        return "layout/enterprises/enterprise";
    }

<<<<<<< HEAD
    @GetMapping("/empleados")
    public String verEmpleados(Model model, Employee employee) {
        model.addAttribute("empleado", new Employee());
        return "layout/employee";
    }
    @GetMapping("/crearempleado")
    public String ingresarEmpleados(Model model) {
        return "layout/formEmployee";
    }

    // Metodos para Movements - Luis Gabriel
    @GetMapping("/movements")
=======
    @GetMapping("/movimientos")
>>>>>>> ec5e1db005e59abf2d13d2cd92998f75b69d2a1f
    public String verMovements(Model model) {
        var titulo = "Movimientos";
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        model.addAttribute("titulo",titulo);
        return "layout/movements/movements";
    }

    @GetMapping("/empleados")
    public String verEmpleados(Model model) {
        var titulo = "Empleados";
        var empleados = employeeService.consultarEmpleados();
        model.addAttribute("empleados", empleados);
        model.addAttribute("titulo",titulo);
        return "layout/employees/employee";
    }

    @GetMapping("/formEmpresa")
    public String crearEmpresa(Model model, Enterprise enterprise){
        var titulo = "formEmpresa";
        model.addAttribute("enteprise",new Enterprise());
        model.addAttribute("/titulo", titulo);
        return "/layout/enterprises/crearEmpresa";
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
        return "layout/movements/updateMovement";
    }


}
