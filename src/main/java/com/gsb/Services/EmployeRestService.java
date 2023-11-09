package com.gsb.Services;

import com.gsb.Metier.EmployeMetier;
import com.gsb.dao.entities.Client;
import com.gsb.dao.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeRestService {
    @Autowired
    private EmployeMetier employeMetier;
    @RequestMapping(value="/employes",method=RequestMethod.POST)
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
}