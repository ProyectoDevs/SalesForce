package com.salesForce.service;

import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovimientoDineroService {

    private TransactionRepository repository;

    public MovimientoDineroService(TransactionRepository repository){
        this.repository = repository;
    }

    public List<MovimientoDinero> getLstMovimientos() {
        List<MovimientoDinero> lista = this.repository.findAll();
        return this.repository.findAll();
    }

    public MovimientoDinero crearMovimiento(MovimientoDinero nuevoMovimiento) {
        try {
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
            nuevoMovimiento.setCreatedAt(timestamp);
            return this.repository.save(nuevoMovimiento);
        }catch (Exception e) {
            throw new EntityNotFoundException("Error: " + e);
        }
    }

    // Consulta de movimiento por ID
    public MovimientoDinero getMovimiento(Long id_transaction) {
        try {
            return this.repository.findById(id_transaction).get();
        } catch (Exception e) {
            throw new EntityNotFoundException("Error: " + e);
        }
    }

    // Methodo para Actualizar todos los datos del objeto
    public void updateMovimiento(MovimientoDinero movimiento) {
        try {
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
            movimiento.setUpdatedAt(timestamp);
            repository.save(movimiento);
        } catch (Exception e) {
            throw new EntityNotFoundException("Error: " + e);
        }
    }

    // Metodo para Eliminar un registro por ID
   public void deleteMovimiento(Long id_transaction) {
       try {
           repository.deleteById(id_transaction);
       }catch (Exception e) {
           throw new EntityNotFoundException("Error al eliminar" + e);
       }
    }

    //Metodo para actualizar CONCEPTO de la transacción
    public MovimientoDinero updatedMovimientoById(Long id_transaction, String conceptInput, float monto) {
        MovimientoDinero movimiento = this.repository.findById(id_transaction).get();
        movimiento.setConcept(conceptInput);
        movimiento.setMount(monto);
        return repository.save(movimiento);
    }

    // Consulta de los movimientos
    private static  MovimientoDinero movimientoDetail(MovimientoDinero movimiento) {
        return new MovimientoDinero(movimiento.getId_transaction(),  movimiento.getMount(), movimiento.getConcept(),
                movimiento.getEmployee(),
                movimiento.getEnterprise(),
                movimiento.getCreatedAt(),movimiento.getUpdatedAt());
    }


/*
    public List<MovimientoDinero> listOfMovements (Long id_enterprise) {
        List<MovimientoDinero> listOfMovements = repository.findAll();
        List<MovimientoDinero> listOfMovementsNew = new ArrayList<>();
        for (int i=0; i<listOfMovements.size();i++){
         if (id_enterprise == listOfMovements.get(i).getId_enterprise()){
             listOfMovementsNew.add(listOfMovements.get(i));
         }
        }
        return listOfMovementsNew;
    }
*/
}