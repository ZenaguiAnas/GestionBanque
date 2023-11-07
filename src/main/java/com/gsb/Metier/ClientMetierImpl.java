package com.gsb.Metier;

import com.gsb.dao.entities.Client;
import com.gsb.dao.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientMetierImpl implements ClientMetier {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public Client saveClient(Client c) {
// TODO Auto-generated method stub
        return clientRepository.save(c);
    }
    @Override
    public List<Client> listClient() {
// TODO Auto-generated method stub
        return clientRepository.findAll();
    }
}