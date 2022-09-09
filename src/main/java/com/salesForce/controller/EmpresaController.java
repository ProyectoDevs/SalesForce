package com.salesForce.controller;

import com.salesForce.entity.Empresa;
import com.salesForce.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos: |GET|POST|

    @GetMapping("/enterprises")
    public List<Empresa> consultarEmpresas (){
        List<Empresa> empresas = new ArrayList<Empresa>();
        return empresaService.consultarEmpresas();
    }

    @PostMapping("/enterprises")
    public void crearEmpresa (@RequestBody Empresa empresa){
       empresaService.crearEmpresa (empresa);
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    @GetMapping("/enterprises/{id_empresa}")
    public Empresa consultarEmpresa (@PathVariable ("id_empresa") Long id_empresa){
        return empresaService.consultarEmpresa(id_empresa);
    }

    @PatchMapping("/enterprises/{id_empresa}")
    public void editarEmpresa (@PathVariable ("id_empresa") Long id, String nitEmpresa){
        empresaService.editarNitEmpresa(id, nitEmpresa);
    }

    @DeleteMapping("/enterprises/{id_empresa}")
    public void borrarEmpresa (@PathVariable ("id_empresa") Long id_empresa) {
        empresaService.borrarEmpresa(id_empresa);
    }

}