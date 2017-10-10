package com.astontech.bo;

public class LoyaltyAccount extends BaseBO{
    private int LoyaltyAccountId;
    private int EmployeeId;
    private LoyaltyCompany LoyaltyCompany;
    private int MemberNumber;

    public LoyaltyAccount() {this.LoyaltyCompany = new LoyaltyCompany();}
    public LoyaltyAccount(int EmployeeId) {
        this.LoyaltyCompany = new LoyaltyCompany();
        this.EmployeeId = EmployeeId;
    }

    public int getLoyaltyAccountId() {
        return LoyaltyAccountId;
    }

    public void setLoyaltyAccountId(int loyaltyAccountId) {
        LoyaltyAccountId = loyaltyAccountId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public LoyaltyCompany getLoyaltyCompany() {
        return this.LoyaltyCompany;
    }

    public void setLoyaltyCompany(LoyaltyCompany loyaltyCompany) {
        this.LoyaltyCompany = loyaltyCompany;
    }

    public int getMemberNumber() {
        return MemberNumber;
    }

    public void setMemberNumber(int memberNumber) {
        MemberNumber = memberNumber;
    }
}
