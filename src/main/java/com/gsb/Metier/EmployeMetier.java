package com.gsb.Metier;

import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Groupe;
import com.gsb.dao.entities.Operation;

import java.util.List;
public interface EmployeMetier {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();

    public void deleteEmployee(Long codeEmploye);

    public Groupe groupOfEmp(Long codeGroupe, Long codeEmploye);

    // Operations
    public Operation addOperation(Operation operation, String codeCompte, Long codeEmploye);
    public List<Operation> listOperations(String codeCompte);

}