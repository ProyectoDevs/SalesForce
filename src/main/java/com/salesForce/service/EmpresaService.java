package com.salesForce.service;

import com.salesForce.entity.Empresa;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    // Metodo consulta una empresa en especifico
    public Empresa consultarEmpresa(Long id_empresa) {
        return this.empresaRepository.findById(id_empresa).get();
    }

    // Metodo crea registro de empresas
    public void crearEmpresa (Empresa empresa) {
        empresaRepository.save(empresa);
    }

    // Metodo consulta todas las empresas
    public List<Empresa> consultarEmpresas (){
        return new ArrayList<Empresa>(empresaRepository.findAll());
    }

    // Metodo actualiza nit empresa
    public Empresa editarNitEmpresa (Long id, String nitEmpresa) {
        Empresa empresa = empresaRepository.findById(id).get();
        empresa.setNitEmpresa(nitEmpresa);
        return empresaRepository.save(empresa);
    }
    // Metodo elimina empresa
    public void borrarEmpresa (Long id_empresa) {
        empresaRepository.deleteById(id_empresa);
    }
}