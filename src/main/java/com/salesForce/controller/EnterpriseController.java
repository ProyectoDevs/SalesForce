package com.salesForce.controller;

import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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

}