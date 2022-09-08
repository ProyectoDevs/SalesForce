package cd.salesForce.service;

import com.salesForce.entity.Empresa;
import com.salesForce.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;


    public void createAndUpdateEnterprise(Empresa empresa) {

        empresaRepository.save(empresa);
    }

    public List<Empresa> getEnterprise() {
        List<Empresa> enterprise = new ArrayList<Empresa>();
        empresas.addAll(empresaRepository.findAll())
        return empresas;
    }
}
