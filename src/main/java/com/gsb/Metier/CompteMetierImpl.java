package com.gsb.Metier;

import com.gsb.dao.entities.Compte;
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
        return compteRepository.save(c);
    }

    @Override
    public Compte updateCompte(String code_cmpt, Compte c) {
        Compte compte = compteRepository.findByCodeCompte(code_cmpt);
        //TODO: Updating the fields of compte
//        return compteRepository.save();
        return null;
    }

    @Override
    public void deleteCompte(String code_cmpt) {
        compteRepository.deleteById(code_cmpt);
    }

    @Override
    public Compte getCompte(String code_cmpt) {
        Compte compte = compteRepository.findByCodeCompte(code_cmpt);
        if (compte == null) throw new RuntimeException("Compte introuvable");
        return compte;
    }

    @Override
    public List<Compte> comptesClient(Long code_cli) {
        return compteRepository.findByCodeCli(code_cli);
    }

    @Override
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @Override
    public void verser(String code_cmpt, double montant) {
        Compte compte = compteRepository.findByCodeCompte(code_cmpt);
        compte.setSolde(compte.getSolde() + montant);
    }

    @Override
    public void retrait(String code_cmpt, double montant) {
        Compte compte = compteRepository.findByCodeCompte(code_cmpt);

        double currentSolde = compte.getSolde();
        if (currentSolde > 0) compte.setSolde(compte.getSolde() - montant);

        System.out.println("Votre solde est insufisante!");
    }

    @Override
    public void virement(String code_sendCmpt, String code_receiveCmpt, double montant) {
        Compte compte1 = compteRepository.findByCodeCompte(code_sendCmpt);
        Compte compte2 = compteRepository.findByCodeCompte(code_receiveCmpt);

        if (compte1.getSolde() > 0) {
            verser(code_receiveCmpt, montant);
            retrait(code_sendCmpt, montant);
        }

        System.out.println("Votre solde est insufisante!");

    }


}
