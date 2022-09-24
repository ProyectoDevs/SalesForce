package com.salesForce.controller;


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

import java.util.List;


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

    @GetMapping("/icons.html")
    public String verEmpleados(Model model) {

        return "layout/employee";
    }
    @GetMapping("/crearempleado")
    public String ingresarEmpleados(Model model) {

        return "layout/formEmployee";
    }

    // Metodos para Movements - Luis Gabriel
    @GetMapping("/movements")
    public String verMovements(Model model) {
        var titulo = "Movimientos";
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        model.addAttribute("titulo",titulo);
        return "layout/movements";
    }

    @GetMapping("/new-movement")
    public String newMovement(Model model) {
        var titulo = "Crear Movimiento";
        var enterprises = enterpriseService.findEnterprises();
        model.addAttribute("enterprises",enterprises);
        var employees = employeeService.consultarEmpleados();
        model.addAttribute("employees",employees);
        return "layout/newMovement";
    }
}
