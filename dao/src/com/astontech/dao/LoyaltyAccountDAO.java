package com.astontech.dao;

import com.astontech.bo.LoyaltyAccount;

import java.util.List;

public interface LoyaltyAccountDAO {
    //notes: GET methods
    public LoyaltyAccount getLoyaltyAccountById(int loyaltyAccountId);
    public List<LoyaltyAccount> getLoyaltyAccountList();

    //notes: EXECUTE methods
    public int insertLoyaltyAccount(LoyaltyAccount loyaltyAccount);
    public boolean updateLoyaltyAccount(LoyaltyAccount loyaltyAccount);
    public boolean deleteLoyaltyAccount(int loyaltyAccountId);
}
