package com.gsb.Metier;

import com.gsb.dao.entities.Compte;
import com.gsb.dao.entities.Groupe;
import com.gsb.dao.repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class CompteMetierImpl implements CompteMetier {

    @Autowired
    CompteRepository compteRepository;
    @Override
    public Compte addCompte(Compte c) {
        return null;
    }

    @Override
    public Compte updateCompte(Long code_cmpt) {
        return null;
    }

    @Override
    public void deleteCompte(Long code_cmpt) {

    }

    @Override
    public Compte getCompte(String code_cmpt) {
        Compte compte = compteRepository.findByCodeCompte(code_cmpt);
        if (compte == null) throw new RuntimeException("Compte introuvable");
        return compte;
    }

    @Override
    public List<Compte> comptesClient(Long code_cmpt) {
        return null;
    }

    @Override
    public List<Compte> allComptes() {
        return null;
    }

    @Override
    public void verser(Long code_cmpt, double montant) {

    }

    @Override
    public void retrait(Long code_cmpt, double montant) {

    }

    @Override
    public void retrait(Long code_sendCmpt, Long code_receiveCmpt, double montant) {

    }

    @Override
    public Groupe groupOfEmp(Long codeGroupe, Long codeEmp) {
        return null;
    }
}
