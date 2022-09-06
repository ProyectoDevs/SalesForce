package com.salesForce.service;

import com.salesForce.entity.MovimientoDinero;

import java.util.List;

public interface MovimientoDineroService {
    public List<MovimientoDinero> listarMovimientos();
    public void guardarMovimiento(MovimientoDinero movimientoDinero);
    public void editarMovimiento(MovimientoDinero movimientoDinero);
    public void eliminarMovimiento(MovimientoDinero movimientoDinero);
}
