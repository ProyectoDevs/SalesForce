package com.salesForce.controller;

import com.salesForce.entity.Empresa;
import com.salesForce.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos: |GET|POST|

    // Consulta todas las empresas
    @GetMapping("/enterprises")
    public List<Empresa> consultarEmpresas (){
        List<Empresa> empresas = new ArrayList<Empresa>();
        return empresaService.consultarEmpresas();
    }

    // Crea una empresa
    @PostMapping("/enterprises")
    public List<Empresa> crearEmpresa (@RequestBody Empresa empresa){
       empresaService.crearEmpresa (empresa);
       return empresaService.consultarEmpresas();
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    // Consulta una empresa en particular segun id_empresa
    @GetMapping("/enterprises/{id_empresa}")
    public Empresa consultarEmpresa (@PathVariable ("id_empresa") Long id_empresa){
        return empresaService.consultarEmpresa(id_empresa);
    }

    // Actualiza nit Empresa
    @PatchMapping("/enterprises/{id_empresa}/{nitEmpresa}")
    public Empresa editarNitEmpresa (@PathVariable ("id_empresa") Long id, @PathVariable ("nitEmpresa") String nitEmpresa){
        empresaService.editarNitEmpresa(id, nitEmpresa);
        return empresaService.consultarEmpresa(id);
    }

    @DeleteMapping("/enterprises/{id_empresa}")
    public List<Empresa> borrarEmpresa (@PathVariable ("id_empresa") Long id_empresa) {
        empresaService.borrarEmpresa(id_empresa);
        return empresaService.consultarEmpresas();
    }
}