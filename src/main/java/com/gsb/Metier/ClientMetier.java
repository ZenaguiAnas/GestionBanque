package com.gsb.Metier;

import com.gsb.dao.entities.Client;

import java.util.List;
public interface ClientMetier {
    public Client saveClient(Client c);
    public List<Client> listClient();
}