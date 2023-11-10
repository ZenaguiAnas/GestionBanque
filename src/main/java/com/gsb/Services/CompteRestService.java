package com.gsb.Services;

import com.gsb.Metier.CompteMetier;
import com.gsb.dao.entities.Compte;
import com.gsb.dao.entities.CompteCourant;
import com.gsb.dao.entities.CompteEpargne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        if (typeOfCompte.equals("E")) {
            return compteMetier.addCompte(new CompteEpargne(), codeClient.longValue(), codeEmploye.longValue());
        }
        return compteMetier.addCompte(new CompteCourant(), codeClient.longValue(), codeEmploye.longValue());
    }

//    @RequestMapping(value="/get-compte",method= RequestMethod.GET)
//    public Compte getCompte(@RequestBody Map<String, Object> requestData) {
//        String codeCompte = (String) requestData.get("codeCompte");
//
//        System.out.println("codeCompte, " + codeCompte );
//        return compteMetier.getCompte(codeCompte);
//    }
}
