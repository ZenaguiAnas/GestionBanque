package com.gsb.Services;

import com.gsb.Metier.ClientMetier;
import com.gsb.dao.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;

    @GetMapping("/consulterClient/{codeClient}")
    public Client getClient(@PathVariable Long codeClient) {
        return clientMetier.consulterClient(codeClient);
    }

    @RequestMapping(value="/create-client",method=RequestMethod.POST)
    public Client saveClient(@RequestBody Client c) {
        return clientMetier.saveClient(c);
    }

    @RequestMapping(value="/clients",method=RequestMethod.GET)
    public List<Client> listClient() {
        return clientMetier.listClient();
    }



    @RequestMapping(value="/delete-client/{codeClient}",method=RequestMethod.DELETE)
    public void deleteClient(@PathVariable Long codeClient) {
        clientMetier.deleteClient(codeClient);
    }

    @RequestMapping(value="/authentifierClient",method=RequestMethod.POST)
    public Client authentifierClient( @RequestBody Client client) {
        return clientMetier.authentifierClient( client);
    }
}