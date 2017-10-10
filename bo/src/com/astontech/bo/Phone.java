package com.astontech.bo;

public class Phone extends BaseBO {
    private int PhoneId;
    private EntityType PhoneType;
    private int ClientId;
    private int PersonId;
    private int AreaCode;
    private int PhoneNumber;
    private int PhoneNumberPost;

    public Phone() {
        PhoneType = new EntityType();
    }

    public Phone(int PhoneNumber)
    {
        PhoneType = new EntityType();
        this.PhoneNumber = PhoneNumber;
    }

    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public EntityType getPhoneType() {
        return this.PhoneType;
    }

    public void setPhoneType(EntityType PhoneType) {
        this.PhoneType = PhoneType;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    //helper functions
    public String getFullPhoneNumber() {
        return this.AreaCode+"-"+this.PhoneNumber;
    }
}
