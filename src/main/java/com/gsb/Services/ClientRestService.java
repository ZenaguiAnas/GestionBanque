package com.gsb.Services;

import com.gsb.Metier.ClientMetier;
import com.gsb.Metier.CompteMetier;
import com.gsb.dao.entities.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ClientRestService {
    @Autowired
    private ClientMetier clientMetier;

    @Autowired
    private CompteMetier compteMetier;

//    @RequestMapping(value="/create-client",method=RequestMethod.POST)
//    public Client saveClient(@RequestBody Client c) {
//        return clientMetier.saveClient(c);
//    }

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


    // TODO : Templates
    @PostMapping("/authentifierClient")
    public ModelAndView authentifierClient(@ModelAttribute("client") Client client, Model model  , HttpSession httpSession) {
        ModelAndView modelAndView;
        Client clientX = new Client();
        clientX.setCodeClient((Long) client.getCodeClient());
        clientX.setNomClient((String) client.getNomClient());
        model.addAttribute("Client",clientX);


        System.out.println(clientX.getNomClient());
        Client client1 = clientMetier.authentifierClient(clientX);

        if (client1==null){
            modelAndView= new ModelAndView("authentifierClient");
            return modelAndView;
        }
        else {
            modelAndView= new ModelAndView("HomeClient");
            httpSession.setAttribute("Client", client1);
            return clientHome(model,httpSession);
        }
    }

    @GetMapping("/auth")
    public ModelAndView authentifierClient(Model model) {
        ModelAndView modelAndView= new ModelAndView("authentifierClient");
        Client client = new Client();
        model.addAttribute("client", client);

        return modelAndView;
    }

    @GetMapping("/clients-page")
    public ModelAndView getClientsPage(Model model) {
        ModelAndView modelAndView= new ModelAndView("Views/Clients");
        model.addAttribute("clients", clientMetier.listClient());

        return modelAndView;
    }

    @GetMapping("/add-client")
    public ModelAndView addClientsPage(Model model) {
        ModelAndView modelAndView= new ModelAndView("Components/AddClient");

        Client client = new Client();
        model.addAttribute("client", client);
        model.addAttribute("typeCpte", "");


        return modelAndView;
    }

    @PostMapping("/create-client")
    public String createClient(@ModelAttribute("client") Client client, @RequestParam("typeCpte") String typeCpte) {
        Client client1 = clientMetier.saveClient(client);

        String codeCompte = generateUniqueCodeCompte(typeCpte, client1.getCodeClient());

        try {
            saveCompte(typeCpte, client.getCodeClient(), 1L, codeCompte);
        } catch (Exception e) {
            throw new RuntimeException("There is an error!");
        }

        return "redirect:/clients-page";
    }

    private String generateUniqueCodeCompte(String typeCpte, Long codeClient) {
        int maxClientComptes = compteMetier.comptesClient(codeClient).size();
        return typeCpte.split(" ")[1].substring(0, 2).toUpperCase() + codeClient.toString() + maxClientComptes;
    }

    private void saveCompte(String typeCpte, Long codeClient, Long codeEmploye, String codeCompte) {
        if (typeCpte.equals("Compte Courant")) {
            compteMetier.addCompte(new CompteCourant(), codeClient, codeEmploye, codeCompte);
        } else {
            compteMetier.addCompte(new CompteEpargne(), codeClient, codeEmploye, codeCompte);
        }
    }
    @GetMapping("/clientHome")
    public  ModelAndView clientHome(Model model, HttpSession httpSession) {
        Client client = (Client) httpSession.getAttribute("Client");

        client.getComptes().forEach(compte -> {
            compte.getOperations().forEach(op -> {
                if (op instanceof Retrait) {
                    ((Retrait) op).setTypeOperation("Retrait");
                } else if (op instanceof Versment) {
                    ((Versment) op).setTypeOperation("Versment");
                }
                else if (op instanceof Virement) {
                    ((Virement) op).setTypeOperation("Virement");
                }
            });
            if (compte instanceof CompteCourant) {
                ((CompteCourant) compte).setTypeCompte("Compte Courant");
            } else if (compte instanceof CompteEpargne) {
                ((CompteEpargne) compte).setTypeCompte("Compte Epargne");
            }
        });

        model.addAttribute("client", client);


        ModelAndView modelAndView = new ModelAndView("HomeClient");
        return modelAndView;
    }







}