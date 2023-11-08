package com.gsb.Metier;

import com.gsb.dao.entities.Client;
import com.gsb.dao.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
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

    @Override
    public Client consulterClient(Long code_client) {
        return clientRepository.findByCodeClient(code_client);
    }

    @Override
    public Client updateClient(Long code_client) {
        return null;
    }

    @Override
    public void deleteClient(Long code_client) {
        clientRepository.deleteById(code_client);
    }
}