package com.gsb.Services;

import com.gsb.Metier.CompteMetier;
import com.gsb.Metier.EmployeMetier;
import com.gsb.dao.entities.Client;
import com.gsb.dao.entities.Employe;
import com.gsb.dao.entities.Retrait;
import com.gsb.dao.entities.Versment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeRestService {
    @Autowired
    private EmployeMetier employeMetier;
    private CompteMetier compteMetier;

    @RequestMapping(value="/add-employe",method=RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe e) {
        return employeMetier.saveEmploye(e);
    }

    @RequestMapping(value="/employes",method=RequestMethod.GET)
    public List<Employe> listEmployes() {
        return employeMetier.listEmployes();
    }
    @RequestMapping(value="/authentifierEmploye",method=RequestMethod.POST)
    public Employe authentifierEmploye( @RequestBody Employe employe) {
        return employeMetier.authentifierEmploye( employe);
    }

    @RequestMapping(value="/delete-employe/{codeEmploye}",method=RequestMethod.DELETE)
    public void deleteEmploye(@PathVariable Long codeEmploye) {
        employeMetier.deleteEmployee(codeEmploye);
    }

    @RequestMapping(value = "/add-emp-groupe", method = RequestMethod.POST)
    public void ajouterEmpGroup(@RequestBody Map<String, Long> request) {
        Long codeGroupe = request.get("codeGroupe");
        Long codeEmploye = request.get("codeEmploye");

        System.out.println(codeGroupe + ", " + codeEmploye);

        employeMetier.addEmployeToGroupe(codeGroupe, codeEmploye);
    }

    @RequestMapping(value="/employes-per-groupe/{codeGroupe}",method=RequestMethod.GET)
    public List<Employe> employesPerGroupe(@PathVariable Long codeGroupe) {
        return employeMetier.getEmployeesByGroup(codeGroupe);
    }

    @RequestMapping(value="/versement",method=RequestMethod.PUT)
    public void verser(@RequestBody String code_cmpt, @RequestBody Long codeEmploye, @RequestBody double montant) {
        compteMetier.verser(code_cmpt, montant);
        employeMetier.addOperation(new Versment(), code_cmpt, codeEmploye);
    }

    @RequestMapping(value="/retrait",method=RequestMethod.PUT)
    public void retirer(@RequestBody String code_cmpt, @RequestBody Long codeEmploye, @RequestBody double montant) {
        compteMetier.retrait(code_cmpt, montant);
        employeMetier.addOperation(new Retrait(), code_cmpt, codeEmploye);
    }

//    @RequestMapping(value="/compte-operations",method=RequestMethod.GET)
//    public List<Operation> listOperationsOfCompte(@PathVariable String codeCompte){
//        return employeMetier.listOperations(codeCompte);
//    }



}