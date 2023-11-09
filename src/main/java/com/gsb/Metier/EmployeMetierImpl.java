package com.gsb.Metier;

import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Groupe;
import com.gsb.dao.entities.Operation;
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

    @Autowired
    private GroupeRepository groupeRepository;

    @Override
    public Employe saveEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long codeEmploye) {
        employeRepository.deleteById(codeEmploye);
    }

    @Override
    public Groupe groupOfEmp(Long codeGroupe, Long codeEmploye) {
        Groupe groupe = groupeRepository.findByCodeGroupe(codeGroupe);
//        Employe employe = employeRepository.findById(codeEmploye);
//        groupe.setEmploye(employe);

        return groupeRepository.save(groupe);
    }

    @Override
    public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye) {
        return null;
    }

    @Override
    public List<Operation> listOperations(String codeCompte) {
        return null;
    }

    @Override
    public Employe authentifierEmploye(Employe employe1) {
        Employe employe = employeRepository.findEmployeByCodeEmployeAndNomEmploye(employe1.getCodeEmploye(),employe1.getNomEmploye());

        if (employe != null) {
            return employe;
        } else {
            // Affichez un message d'erreur ou gérez l'authentification comme nécessaire
            return null;
        }
    }
}
