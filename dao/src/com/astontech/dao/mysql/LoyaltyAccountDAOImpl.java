package com.astontech.dao.mysql;

import com.astontech.bo.LoyaltyAccount;
import com.astontech.dao.LoyaltyAccountDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyAccountDAOImpl extends MySQL implements LoyaltyAccountDAO {
    @Override
    public LoyaltyAccount getLoyaltyAccountById(int loyaltyAccountId) {
        Connect();
        LoyaltyAccount loyaltyAccount = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetLoyaltyAccount(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, loyaltyAccountId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                loyaltyAccount = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return loyaltyAccount;
    }

    @Override
    public List<LoyaltyAccount> getLoyaltyAccountList() {
        Connect();
        List<LoyaltyAccount> LoyaltyAccountList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetLoyaltyAccount(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                LoyaltyAccountList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return LoyaltyAccountList;
    }

    @Override
    public int insertLoyaltyAccount(LoyaltyAccount loyaltyAccount) {
        return 0;
    }

    @Override
    public boolean updateLoyaltyAccount(LoyaltyAccount loyaltyAccount) {
        return false;
    }

    @Override
    public boolean deleteLoyaltyAccount(int loyaltyAccountId) {
        return false;
    }

    private static LoyaltyAccount HydrateObject(ResultSet rs) throws SQLException {
        /*  private int LoyaltyAccountId;
            private int EmployeeId;
            private LoyaltyCompany LoyaltyCompany;
            private int MemberNumber;
        */

        //notes:    HYDRATING AN OBJECT
        LoyaltyAccount LoyaltyAccount = new LoyaltyAccount();
        LoyaltyAccount.setLoyaltyAccountId(rs.getInt(1));
        LoyaltyAccount.setEmployeeId(rs.getInt(2));

        LoyaltyCompanyDAOImpl bridge = new LoyaltyCompanyDAOImpl();

        LoyaltyAccount.setLoyaltyCompany(bridge.getLoyaltyCompanyById(rs.getInt(3)));
        LoyaltyAccount.setMemberNumber(rs.getInt(4));

        return LoyaltyAccount;
    }
}
