package com.gsb.Services;

import com.gsb.Metier.GroupeMetier;
import com.gsb.dao.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupeRestService {

    @Autowired
    GroupeMetier groupeMetier;

    @RequestMapping(value="/add-groupe",method= RequestMethod.POST)
    public Groupe addGroupe(@RequestBody Groupe c) {
        return groupeMetier.addGroupe(c);
    }
}
