package com.astontech.dao;

import com.astontech.bo.LoyaltyCompany;

import java.util.List;

public interface LoyaltyCompanyDAO {
    //notes: GET methods
    public LoyaltyCompany getLoyaltyCompanyById(int loyaltyCompanyId);
    public List<LoyaltyCompany> getLoyaltyCompanyList();

    //notes: EXECUTE methods
    public int insertLoyaltyCompany(LoyaltyCompany loyaltyCompany);
    public boolean updateLoyaltyCompany(LoyaltyCompany loyaltyCompany);
    public boolean deleteLoyaltyCompany(int loyaltyCompanyId);
}
