package com.astontech.bo;

public class Email extends BaseBO {
    private int EmailId;
    private String EmailAddress;
    private int EmployeeId;
    private EntityType EmailType;

    public Email() {
        this.EmailType = new EntityType();
    }
    public Email(String EmailAddress) {
        this.EmailType = new EntityType();
        this.EmailAddress = EmailAddress;
    }

    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public EntityType getEmailType() {
        return this.EmailType;
    }

    public void setEmailType(EntityType entityType) {
        EmailType = entityType;
    }
}
