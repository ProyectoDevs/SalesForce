package com.salesForce.service;

import com.salesForce.repository.TransactionRepository;
import com.salesForce.entity.MovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovimientoDineroServiceImpl implements MovimientoDineroService {

    @Autowired
    private TransactionRepository transactionDao;

    @Transactional(readOnly = true)
    @Override
    public List<MovimientoDinero> listarMovimientos() {
        return (List<MovimientoDinero>) transactionDao.findAll();
    }

    @Override
    @Transactional
    public void guardarMovimiento(MovimientoDinero movimientoDinero) {
        transactionDao.save(movimientoDinero);
    }

    @Override
    @Transactional
    public void editarMovimiento(MovimientoDinero movimientoDinero) {

    }

    @Override
    @Transactional
    public void eliminarMovimiento(MovimientoDinero movimientoDinero) {

    }
}
