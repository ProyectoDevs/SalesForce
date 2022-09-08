package com.salesForce.service;

import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoDineroService {

    private TransactionRepository repository;

    public MovimientoDineroService(TransactionRepository repository){
        this.repository = repository;
    }

    public List<MovimientoDinero> getLstMovimientos() {
        return this.repository.findAll();
    }

    public MovimientoDinero crearMovimiento(MovimientoDinero nuevoMovimiento) {
        return this.repository.save(nuevoMovimiento);
    }

    // Consulta de movimiento por ID
    public MovimientoDinero getMovimiento(Long id_transaction) {
        return this.repository.findById(id_transaction).get();
    }

    public void updateMovimiento(MovimientoDinero movimiento) {
        repository.save(movimiento);
    }

   public void deleteMovimiento(Long id_transaction) {
       repository.deleteById(id_transaction);
    }



    // Consulta de los movimientos
    private static  MovimientoDinero movimientoDetail(MovimientoDinero movimiento) {
        return new MovimientoDinero(movimiento.getId_transaction(),  movimiento.getMount(), movimiento.getConcept(), movimiento.getId_employee(),movimiento.getId_enterprise());
    }
}
