package com.salesForce.service;

import com.salesForce.entity.Enterprise;
import com.salesForce.entity.MovimientoDinero;
import com.salesForce.repository.EnterpriseRepository;
import com.salesForce.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EnterpriseService {

    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    TransactionRepository repository;

    public Enterprise findEnterprise(Long id_enterprise) {
        return this.enterpriseRepository.findById(id_enterprise).get();
    }

    public void createEnterprise(Enterprise enterprise) {
        enterpriseRepository.save(enterprise);
    }

    public List<Enterprise> findEnterprises() {
        return new ArrayList<Enterprise>(enterpriseRepository.findAll());
    }

    public Enterprise editDocument(Long id, String document) {
        Enterprise enterprise = enterpriseRepository.findById(id).get();
        enterprise.setDocument(document);
        return enterpriseRepository.save(enterprise);
    }

    public void deleteEnterprise (Long id_enterprise){
        enterpriseRepository.deleteById(id_enterprise);
        }

    public Integer cantidadEmpresas() {
        return Math.toIntExact(enterpriseRepository.count());
    }

}