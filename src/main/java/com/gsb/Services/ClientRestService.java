package com.gsb.Services;

import com.gsb.Metier.ClientMetier;
import com.gsb.dao.entities.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;

    @RequestMapping(value="/create-client",method=RequestMethod.POST)
    public Client saveClient(@RequestBody Client c) {
        return clientMetier.saveClient(c);
    }

    @GetMapping("/consulterClient/{codeClient}")
    public Client getClient(@PathVariable Long codeClient) {
        return clientMetier.consulterClient(codeClient);
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
    public Client authentifierClient(@RequestBody Client client, HttpSession httpSession) {
        httpSession.setAttribute("Client",client);
        Client client2= (Client) httpSession.getAttribute("Client");
        System.out.println(client2.getNomClient());
        return clientMetier.authentifierClient( client);
    }

}