package com.salesForce.controller;


import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@Slf4j
@RequestMapping("/")
public class HomeController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;

    @GetMapping("/")
    public String verHome(Model model) {
        var movimientos = movimientoDineroService.getLstMovimientos();
        log.info("saludos desde Home");
        model.addAttribute("movimientos", movimientos);
        return "home";
    }
}

