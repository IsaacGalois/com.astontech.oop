package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Client extends BaseBO {
    private int ClientId;
    private String ClientName;
    private Date CreateDate;
    private List<Address> AddressList;
    private List<Phone> PhoneList;
    private List<Project> ProjectList;

    public Client() {
        this.setAddressList(new ArrayList<>());
        this.setPhoneList(new ArrayList<>());
        this.PhoneList = new ArrayList<>();
    }
    public Client(String ClientName) {
        this.setAddressList(new ArrayList<>());
        this.setPhoneList(new ArrayList<>());
        this.setProjectList(new ArrayList<>());
        this.ClientName = ClientName;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public List<Address> getAddressList() {
        return AddressList;
    }

    public void setAddressList(List<Address> addressList) {
        AddressList = addressList;
    }

    public List<Phone> getPhoneList() {
        return PhoneList;
    }

    public void setPhoneList(List<Phone> phoneList) {
        PhoneList = phoneList;
    }

    public List<Project> getProjectList() {
        return ProjectList;
    }

    public void setProjectList(List<Project> projectList) {
        ProjectList = projectList;
    }
}
