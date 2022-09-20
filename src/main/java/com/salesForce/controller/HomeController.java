package com.salesForce.controller;


import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
<<<<<<< HEAD
    public String verHome(Model model) {
        var titulo = "Home";
=======
    public String verHome(Model model, @AuthenticationPrincipal OidcUser principal) {
        var movimientos = movimientoDineroService.getLstMovimientos();
>>>>>>> db91d04c662125306f0197be6f9e9f7006508827
        log.info("saludos desde Home");
        model.addAttribute("titulo", titulo);
        return "home";
    }

    @GetMapping("/empresas")
    public String verEnterprise(Model model) {
        String title = "Empresas";
        model.addAttribute("title",title);
        return "enterprise";
    }

    @GetMapping("/movements")
    public String verMovements(Model model) {
        var movimientos = movimientoDineroService.getLstMovimientos();
        model.addAttribute("movimientos", movimientos);
        return "layout/movements";
    }
}

