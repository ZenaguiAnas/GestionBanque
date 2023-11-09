package com.gsb.Metier;

import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Groupe;
import com.gsb.dao.repository.EmployeRepository;
import com.gsb.dao.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeMetierImpl implements EmployeMetier {
    @Autowired
    private EmployeRepository employeRepository;
    private GroupeRepository groupeRepository;

    @Override
    public Employe saveEmploye(Employe e) {
    // TODO Auto-generated method stub
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listEmployes() {
// TODO Auto-generated method stub
        return employeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long codeEmploye) {
        employeRepository.deleteById(codeEmploye);
    }

    @Override
    public Groupe groupOfEmp(Long codeGroupe, Collection<Employe> employes) {
        Groupe groupe = groupeRepository.findByCodeGroupe(codeGroupe);
        groupe.setEmploye(employes);

//        employes.forEach(employe -> {});

        return groupeRepository.save(groupe);
    }
}

