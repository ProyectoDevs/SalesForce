package com.salesForce.controller;


import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EmployeeService;
import com.salesForce.service.EnterpriseService;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/movimientos")
public class TransactionController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/transaction")
    public List<MovimientoDinero> listaMovimientos() {
        var listaMovimientos = this.movimientoDineroService.getLstMovimientos();
        log.info("Ejecutando desde controlador");
        return listaMovimientos;
    }
    @GetMapping("/transaction/{id_transaction}")
    public MovimientoDinero getMovimientoById(@PathVariable("id_transaction") Long id_transaction, Model model) {
        return this.movimientoDineroService.getMovimientoById(id_transaction);
    }

    @PostMapping(value="/transaction", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public RedirectView crearMovimiento(MovimientoDinero movimientoDinero){
        log.info("Ejecutando desde CREAR");
        this.movimientoDineroService.crearMovimiento(movimientoDinero);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/movements");
        return redirectView;

    }

    @GetMapping("/delete-transaction/{id_transaction}")
    public RedirectView deleteMovimiento(@PathVariable("id_transaction") Long id_transaction) {
        this.movimientoDineroService.deleteMovimiento(id_transaction);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("/movements");
        return redirectView;
    }


    @PutMapping("/update-transaction")
    public MovimientoDinero updateMovimiento(@RequestParam MovimientoDinero movimiento) {
        this.movimientoDineroService.updateMovimiento(movimiento);
        return movimiento;
    }

    @PatchMapping("/transaction/{id_transaction}/{conceptInput}/{monto}")
    public MovimientoDinero updateConceptById(@PathVariable("id_transaction") Long id_transaction, @PathVariable("conceptInput") String conceptInput, @PathVariable("monto") float monto) {
        return movimientoDineroService.updatedMovimientoById(id_transaction,conceptInput,monto);
    }

    @RequestMapping(value = "/enterprises", method = RequestMethod.GET)
    public List<Enterprise> OptionEnterprise(Model model) {
        var enterpriseOptions = enterpriseService.findEnterprises();
        return enterpriseOptions;
    }
}