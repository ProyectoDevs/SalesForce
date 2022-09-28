package com.salesForce.controller;


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

    // @AuthenticationPrincipal OidcUser principal
    @GetMapping("/")
    public String verHome(Model model, @AuthenticationPrincipal OidcUser principal) {
        var titulo = "home";
        log.info("saludos desde Home");
        model.addAttribute("titulo", titulo);
        return "home";
    }

    @GetMapping("/empresas")
    public String verEnterprise(Model model) {
        String title = "Empresas";
        model.addAttribute("title",title);
        return "layout/enterprise";
    }
    @GetMapping("/crear")
    public String crearEmpresa(Model model){
        var titulo = "Enterprises";
        model.addAttribute("/titulo", titulo);
        return "crearEmpresa";

    }
        //Empleados
    @GetMapping("empleados")
    public String verEmpleados(Model model) {
        String title = "Employee";
        model.addAttribute("title",title);

        return "layout/employee";
    }
    @GetMapping("crearempleado")
    public String ingresarEmpleados(Model model) {
        String title = "Employee";
        model.addAttribute("title", title);


        return "layout/formEmployee";
    }

    // Metodos para Movements - Luis Gabriel
    @GetMapping("/movements")
    public String verMovements(Model model) {
        var titulo = "Movimientos";
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        model.addAttribute("titulo",titulo);
        return "layout/movements/movements";
    }

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
