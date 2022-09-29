package com.salesForce.service;

import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
        Long datetime = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(datetime);
        nuevoMovimiento.setCreated_at(timestamp);
        System.out.println("creando desde service");
        return this.repository.save(nuevoMovimiento);
    }

    // Consulta de movimiento por ID
    public MovimientoDinero getMovimientoById(Long id_transaction) {
        return this.repository.findById(id_transaction).get();
    }

    // Metodo para Eliminar un registro por ID
    public void deleteMovimiento(Long id_transaction) {
        repository.deleteById(id_transaction);
    }

    // Methodo para Actualizar todos los datos del objeto
    public void updateMovimiento(MovimientoDinero movimiento) {
        try {
            Long datetime = System.currentTimeMillis();
            Timestamp timestamp = new Timestamp(datetime);
            movimiento.setUpdated_at(timestamp);
            repository.save(movimiento);
        } catch (Exception e) {
            throw new EntityNotFoundException("Error: " + e);
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
                movimiento.getCreated_at(),movimiento.getUpdated_at());
    }

    public Integer cantidadMovimientos() {
        return Math.toIntExact(repository.count());
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