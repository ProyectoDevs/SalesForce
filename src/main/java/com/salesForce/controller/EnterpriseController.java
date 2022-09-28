package com.salesForce.controller;

import com.salesForce.entity.Enterprise;
import com.salesForce.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping ("/")
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @PostMapping("/crearEmpresa")
    public RedirectView newEnterprise (Model model, Enterprise enterprise) {
        enterpriseService.createEnterprise(enterprise);
        return new RedirectView("/empresas");
    }

    @GetMapping("eliminarEmpresa/{id_enterprise}" )
    public RedirectView deleteEnterprise (@PathVariable ("id_enterprise") Long id){
        enterpriseService.deleteEnterprise(id);
        return new RedirectView ("/empresas");
    }

    @GetMapping("actualizarEmpresa/{id_enterprise}" )
    public RedirectView updateEnterprise (@PathVariable ("id_enterprise") Long id, Enterprise enterprise){
        enterpriseService.createEnterprise(enterprise);
        return new RedirectView ("/empresas");
    }

}