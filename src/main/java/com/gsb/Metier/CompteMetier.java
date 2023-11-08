package com.gsb.Metier;

import com.gsb.dao.entities.Compte;
import com.gsb.dao.entities.Groupe;

import java.util.List;

public interface CompteMetier {

    public Compte addCompte(Compte c);
    public Compte updateCompte(Long code_cmpt);
    public void deleteCompte(Long code_cmpt);
    public Compte getCompte(String code_cmpt);
    public List<Compte> comptesClient(Long code_cmpt);
    public List<Compte> allComptes();

    // The operations on the account
    public void verser(Long code_cmpt, double montant);
    public void retrait(Long code_cmpt, double montant);
    public void retrait(Long code_sendCmpt, Long code_receiveCmpt, double montant);

    // Link the group of employees
    public Groupe groupOfEmp(Long codeGroupe, Long codeEmp);


}
