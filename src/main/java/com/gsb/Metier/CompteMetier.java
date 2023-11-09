package com.gsb.Metier;

import com.gsb.dao.entities.Client;
import com.gsb.dao.entities.Compte;

import java.util.List;

public interface CompteMetier {

    public Compte saveCompte(Compte c);
//    public Compte updateCompte(String code_cmpt);

//    Compte updateCompte(String code_cmpt, Compte c);

    public void deleteCompte(String code_cmpt);
    public Compte getCompte(String code_cmpt);
    public List<Compte> comptesClient(Client client);
    public List<Compte> allComptes();

    // The operations on the account
    public void verser(String code_cmpt, double montant);
    public void retrait(String code_cmpt, double montant);
    public void virement(String code_sendCmpt, String code_receiveCmpt, double montant);

    // Link the group of employees


}
