package com.salesForce.service;

import com.salesForce.entity.Empresa;
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

    public Empresa consultarEmpresa(Long id_empresa) {
        return this.empresaRepository.findById(id_empresa).get();
    }

    public void crearEmpresa (Empresa empresa) {
        empresaRepository.save(empresa);
    }

    public void editarNitEmpresa (Long id, String nitEmpresa) {
        empresaRepository.findById(id).get().setNitEmpresa(nitEmpresa);
        }

    public List<Empresa> consultarEmpresas (){
        return new ArrayList<Empresa>(empresaRepository.findAll());
    }

    //prueba
    public void actualizarEmpresa(Empresa enterprise) {
        empresaRepository.save(enterprise);
    }

    public void borrarEmpresa (Long id_empresa) {
        empresaRepository.deleteById(id_empresa);
    }
}