package com.gsb.Metier;

import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Groupe;
import com.gsb.dao.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeMetierImpl implements EmployeMetier {
    @Autowired
    private EmployeRepository employeRepository;
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
    public Groupe groupOfEmp(Long codeGroupe, Long codeEmp) {



        return null;
    }
}