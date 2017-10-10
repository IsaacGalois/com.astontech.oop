package com.astontech.dao;

import com.astontech.bo.Client;

import java.util.List;

public interface ClientDAO {
    //notes: GET methods
    public Client getClientById(int clientId);
    public List<Client> getClientList();

    //notes: EXECUTE methods
    public int insertClient(Client client);
    public boolean updateClient(Client client);
    public boolean deleteClient(int clientId);
}
