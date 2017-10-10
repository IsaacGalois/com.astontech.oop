package com.astontech.bo;

import common.helpers.StringHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person extends BaseBO implements Comparable, Serializable {

    //region FIELDS
    //PersonId
    private int PersonId;
    //Title
    private String Title;
    //FirstName
    private String FirstName;
    //LastName
    private String LastName;
    //DisplayFirstName
    private String DisplayFirstName;
    //Gender
    private String Gender;
    //list of Email objects
    private List<Email> EmailList;
    //list of Address objects
    private transient List<Address> AddressList; //<--make AddressList unserializable with transient
    //list of Phone objects
    private List<Phone> PhoneList;
    //list of ClientContact objects
    private List<ClientContact> ClientContactList;
    //endregion

    //region CONSTRUCTORS
    public Person() {
        this.setEmailList(new ArrayList<>());
        this.setAddressList(new ArrayList<>());
        this.setPhoneList(new ArrayList<>());
        this.setClientContactList(new ArrayList<>());
    }
    public Person(String FirstName) {
        this.setEmailList(new ArrayList<>());
        this.setAddressList(new ArrayList<>());
        this.setPhoneList(new ArrayList<>());
        this.setClientContactList(new ArrayList<>());
        this.FirstName = FirstName;
    }
    //endregion

    //region GETTERS AND SETTERS
    public void setPersonId(int newId) {
        this.PersonId = newId;
    }

    public int getPersonId() {
        return this.PersonId;
    }

    public void setTitle(String newTitle) {
        this.Title = newTitle;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setFirstName(String newFN) {
        this.FirstName = newFN;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String newLN) {
        this.LastName = newLN;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setDisplayFirstName(String newDFN) {
        this.DisplayFirstName = newDFN;
    }

    public String getDisplayFirstName() {
        return this.DisplayFirstName;
    }

    public void setGender(String newGender) {
        this.Gender = newGender;
    }

    public String getGender() {
        return this.Gender;
    }

    public void setEmailList(List<Email> emailList) {
        EmailList = emailList;
    }

    public List<Email> getEmailList() {
        return EmailList;
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

    public List<ClientContact> getClientContactList() {
        return ClientContactList;
    }

    public void setClientContactList(List<ClientContact> clientContactList) {
        ClientContactList = clientContactList;
    }
    //endregion

    //region CUSTOM METHODS
    public String GetFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No Name Set";
        else {
            if(StringHelper.isNullOrEmpty(this.FirstName))
                return this.LastName;
            else if(StringHelper.isNullOrEmpty(this.LastName))
                return this.FirstName;
            else
                return this.FirstName+" "+this.LastName;
        }
    }

    @Override
    public int compareTo(Object other) {
        Person otherPerson = (Person) other;
        int retVal;
        if(((Character)this.LastName.charAt(0)).compareTo((otherPerson.LastName.charAt(0))) > 0)
            retVal = 1;
        else if(((Character)this.LastName.charAt(0)).compareTo((otherPerson.LastName.charAt(0))) < 0)
            retVal = -1;
        else
            retVal = 0;
        return retVal;
    }

    @Override
    public String toString() {
        return "PersonId="+this.PersonId+" FullName="+this.GetFullName()+" Gender="+this.Gender;
    }

    //endregion
}
