package com.astontech.dao;

import com.astontech.bo.ClientContact;

import java.util.List;

public interface ClientContactDAO {
    //notes: GET methods
    public ClientContact getClientContactById(int ClientContactId);
    public List<ClientContact> getClientContactList();

    //notes: EXECUTE methods
    public int insertClientContact(ClientContact clientContact);
    public boolean updateClientContact(ClientContact clientContact);
    public boolean deleteClientContact(int clientContactId);
}
