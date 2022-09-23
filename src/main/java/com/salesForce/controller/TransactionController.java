package com.salesForce.controller;


import com.salesForce.entity.Employee;
import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EmployeeService;
import com.salesForce.service.EnterpriseService;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("movimientos")
public class TransactionController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;
    @Autowired
    EnterpriseService enterpriseService;
    @Autowired
    EmployeeService employeeService;

    @GetMapping(produces = "application/json")
    public List<MovimientoDinero> listaMovimientos() {
        var listaMovimientos = this.movimientoDineroService.getLstMovimientos();
        log.info("Ejecutando desde controlador");
        return listaMovimientos;
    }
    @GetMapping("/transaction/{id_transaction}")
    public MovimientoDinero getMovimientoById(@PathVariable("id_transaction") Long id_transaction) {
        return this.movimientoDineroService.getMovimiento(id_transaction);
    }


    @PostMapping("/saveTransaction")
    public MovimientoDinero crearMovimiento(@ModelAttribute MovimientoDinero movimiento){
        log.info("Ejecutando desde CREAR");
        return this.movimientoDineroService.crearMovimiento(movimiento);
    }
    @DeleteMapping("/transaction/{id_transaction}")
    public void deleteMovimiento(@PathVariable("id_transaction") Long id_transaction) {
        movimientoDineroService.deleteMovimiento(id_transaction);
        log.info("Eliminando registro");
    }

    @PutMapping("/transaction")
    public MovimientoDinero updateMovimiento(@RequestBody MovimientoDinero movimiento) {
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