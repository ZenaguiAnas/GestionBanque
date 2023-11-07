package com.gsb.Services;

import com.gsb.Metier.ClientMetier;
import com.gsb.dao.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;
    @RequestMapping(value="/clients",method=RequestMethod.POST)
    public Client saveClient(@RequestBody Client c) {
        return clientMetier.saveClient(c);
    }

    @RequestMapping(value="/clientsTest",method=RequestMethod.GET)
    public String saveClient() {
        return "Hello";
    }
    @RequestMapping(value="/clients",method=RequestMethod.GET)
    public List<Client> listClient() {
        return clientMetier.listClient();
    }
}