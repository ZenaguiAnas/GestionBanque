package com.gsb.Services;

import com.gsb.Metier.CompteMetier;
import com.gsb.dao.entities.Compte;
import com.gsb.dao.entities.CompteCourant;
import com.gsb.dao.entities.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CompteRestService {

    @Autowired
    private CompteMetier compteMetier;


    @RequestMapping(value="/add-compte",method= RequestMethod.POST)
    public Compte createCompte(@RequestBody Map<String, Object> requestData) {
        String typeOfCompte = (String) requestData.get("typeOfCompte");
        Integer codeClient = (Integer) requestData.get("codeClient");
        Integer codeEmploye = (Integer) requestData.get("codeEmploye");
        String codeCompte = (String) requestData.get("codeCompte");

        if (typeOfCompte.equals("E")) {
            return compteMetier.addCompte(new CompteEpargne(), codeClient.longValue(), codeEmploye.longValue(), codeCompte);
        }
        return compteMetier.addCompte(new CompteCourant(), codeClient.longValue(), codeEmploye.longValue(), codeCompte);
    }

    @RequestMapping(value="/get-compte/{codeCompte}",method= RequestMethod.GET)
    public Compte getCompte(@PathVariable String codeCompte) {
//        String codeCompte = (String) requestData.get("codeCompte");

        System.out.println("codeCompte, " + codeCompte );
        return compteMetier.getCompte(codeCompte);
    }

    @RequestMapping(value="/delete-compte/{codeCompte}",method=RequestMethod.DELETE)
    public void deleteCompte(@PathVariable String codeCompte) {
        compteMetier.deleteCompte(codeCompte);
    }

    @RequestMapping(value="/comptes",method=RequestMethod.GET)
    public List<Compte> listCompte() {
        return compteMetier.allComptes();
    }

    @RequestMapping(value="/comptes-client/{codeClient}",method=RequestMethod.GET)
    public List<Compte> listCompteClient(@PathVariable Long codeClient) {
        return compteMetier.comptesClient(codeClient);
    }

    @RequestMapping(value="/comptes-employe/{codeEmploye}",method=RequestMethod.GET)
    public List<Compte> listCompteEmploye(@PathVariable Long codeEmploye) {
        return compteMetier.comptesEmployees(codeEmploye);
    }



}
