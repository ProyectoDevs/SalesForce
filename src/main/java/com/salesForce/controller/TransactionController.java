package com.salesForce.controller;


import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.MovimientoDineroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class TransactionController {

    @Autowired
    private MovimientoDineroService movimientoDineroService;
    @GetMapping("/transaction")
    public List<MovimientoDinero> listaMovimientos() {
        log.info("Ejecutando desde controlador");
        return this.movimientoDineroService.getLstMovimientos();
    }
    @GetMapping("/transaction/{id_transaction}")
    public MovimientoDinero getMovimientoById(@PathVariable("id_transaction") Long id_transaction) {
        return this.movimientoDineroService.getMovimiento(id_transaction);
    }

    @PostMapping("/transaction")
    public MovimientoDinero crearMovimiento(@RequestBody MovimientoDinero movimiento){
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
}