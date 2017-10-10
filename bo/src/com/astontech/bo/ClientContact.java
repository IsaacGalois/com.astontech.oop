package com.astontech.bo;

public class ClientContact extends BaseBO {
    private int ClientContactId;
    private Client Client;
    private EntityType ContactType;
    private int PersonId;

    public ClientContact() {
        this.ContactType = new EntityType();
    }
    public ClientContact(Client client) {
        this.ContactType = new EntityType();
        this.Client = client;
    }

    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContractId) {
        ClientContactId = clientContractId;
    }

    public Client getClient() {
        return this.Client;
    }

    public void setClient(Client client) {
        this.Client = client;
    }

    public EntityType getContactType() {
        return ContactType;
    }

    public void setContactType(EntityType contractType) {
        this.ContactType = contractType;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }
}
