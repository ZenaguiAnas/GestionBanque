package com.gsb.Metier;

import com.gsb.dao.entities.Employe;

import java.util.List;
public interface EmployeMetier {
    public Employe saveEmploye(Employe e);
    public List<Employe> listEmployes();
}