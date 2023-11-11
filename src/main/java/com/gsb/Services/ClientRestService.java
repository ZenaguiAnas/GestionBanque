package com.gsb.Services;

import com.gsb.Metier.ClientMetier;
import com.gsb.dao.entities.Client;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;

    @RequestMapping(value="/create-client",method=RequestMethod.POST)
    public Client saveClient(@RequestBody Client c) {
        return clientMetier.saveClient(c);
    }

    @GetMapping("/client/{codeClient}")
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

    @PostMapping("/authentifierClient")
    public String authentifierClient(@ModelAttribute("client") Client client,Model model  , HttpSession httpSession) {

        Client clientX = new Client();
        clientX.setCodeClient((Long) client.getCodeClient());
        clientX.setNomClient((String) client.getNomClient());
        model.addAttribute("Client",clientX);

        httpSession.setAttribute("Client", clientX);
        Client client2 = (Client) httpSession.getAttribute("Client");
        System.out.println(client2.getNomClient());
        clientMetier.authentifierClient(clientX);
        return "redirect:/authentifierClient";
    }
    @GetMapping("/auth")
    public ModelAndView authentifierClient() {
        ModelAndView modelAndView= new ModelAndView("authentifierClient");

    return modelAndView;
    }



}