package com.gsb.Metier;

import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Groupe;

import java.util.Collection;
import java.util.List;
public interface EmployeMetier {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();

    public void deleteEmployee(Long codeEmploye);

    public Groupe groupOfEmp(Long codeGroupe, Collection<Employe> employes);
}