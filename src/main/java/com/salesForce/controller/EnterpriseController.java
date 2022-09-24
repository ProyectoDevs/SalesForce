package com.salesForce.controller;

import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EnterpriseService;
import com.salesForce.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    // El sistema devuelve responses 200 en la ruta /enterprises con los siguientes verbos: |GET|POST|

    // Consulta todas las empresas
    @GetMapping("/enterprises")
    public List<Enterprise> findEnterprises (){
        List<Enterprise> enterprises = new ArrayList<Enterprise>();
        return enterpriseService.findEnterprises();
    }

    // Crea una empresa
    @PostMapping("/enterprises")
    public RedirectView createEmpresa (@ModelAttribute Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.enterpriseService.createEnterprise(enterprise);
        return new RedirectView("/empresas");
    }

    // El sistema devuelve responses 200 en la ruta /enterprises/[id] con los siguientes verbos: |GET|PATCH|DELETE|

    // Consulta una empresa en particular segun id_empresa
    @GetMapping("/enterprises/{id_enterprise}")
    public Enterprise findEnterprise (@PathVariable ("id_enterprise") Long id_enterprise){
        return enterpriseService.findEnterprise(id_enterprise);
    }

    // Actualiza nit Empresa
    @PatchMapping("/enterprises/{id_enterprise}/{document}")
    public Enterprise editDocument (@PathVariable ("id_enterprise") Long id, @PathVariable ("document") String document){
        enterpriseService.editDocument(id, document);
        return enterpriseService.findEnterprise(id);
    }

    @DeleteMapping("/enterprises/{id_enterprise}")
    public List<Enterprise> deleteEnterprise (@PathVariable ("id_enterprise") Long id_enterprise) {
        enterpriseService.deleteEnterprise(id_enterprise);
        return enterpriseService.findEnterprises();
    }

    /*@GetMapping ("/enterprises_movements/{id_enterprise}")
    public List<MovimientoDinero> findMovements (@PathVariable ("id_enterprise") Long id_enterprise) {
        return enterpriseService.findMovements(id_enterprise);
    }

     */


}