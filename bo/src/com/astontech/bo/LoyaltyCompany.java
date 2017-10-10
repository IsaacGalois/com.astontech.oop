package com.astontech.bo;

public class LoyaltyCompany extends BaseBO {
    private int LoyaltyCompanyId;
    private String CompanyName;
    private EntityType LoyaltyCompanyType;

    public LoyaltyCompany() {
        this.LoyaltyCompanyType = new EntityType();
    }
    public LoyaltyCompany(String CompanyName) {
        this.LoyaltyCompanyType = new EntityType();
        this.CompanyName = CompanyName;
    }

    public int getLoyaltyCompanyId() {
        return LoyaltyCompanyId;
    }

    public void setLoyaltyCompanyId(int loyaltyCompanyId) {
        LoyaltyCompanyId = loyaltyCompanyId;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public EntityType getLoyaltyCompanyType() {
        return LoyaltyCompanyType;
    }

    public void setLoyaltyCompanyType(EntityType loyaltyCompanyType) {
        this.LoyaltyCompanyType = loyaltyCompanyType;
    }
}
