package com.salesForce.controller;


import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.TransactionRepository;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@Slf4j
public class TransactionController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;


    @GetMapping("/transaction")
    public String inicio(Model model) {
        var movimientos = movimientoDineroService.listarMovimientos();
        log.info("Ejecutando desde controlador");

        model.addAttribute("movimientos", movimientos);
        return "transaction";
    }

    @GetMapping("/agregar")
    public String agregar(MovimientoDinero movimientoDinero) {
        log.info("Ejecutando desde EDITAR");
        return "editTransactions";
    }

    @PostMapping("/guardar")
    public String guardar(MovimientoDinero movimientoDinero) {
        movimientoDineroService.guardarMovimiento(movimientoDinero);
        return "saludos";
    }
}