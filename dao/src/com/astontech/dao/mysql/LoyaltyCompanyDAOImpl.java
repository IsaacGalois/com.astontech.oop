package com.astontech.dao.mysql;

import com.astontech.bo.LoyaltyCompany;
import com.astontech.dao.LoyaltyCompanyDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoyaltyCompanyDAOImpl extends MySQL implements LoyaltyCompanyDAO {
    @Override
    public LoyaltyCompany getLoyaltyCompanyById(int loyaltyCompanyId) {
        Connect();
        LoyaltyCompany loyaltyCompany = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetLoyaltyCompany(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, loyaltyCompanyId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                loyaltyCompany = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return loyaltyCompany;
    }

    @Override
    public List<LoyaltyCompany> getLoyaltyCompanyList() {
        Connect();
        List<LoyaltyCompany> LoyaltyCompanyList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetLoyaltyCompany(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                LoyaltyCompanyList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return LoyaltyCompanyList;
    }

    @Override
    public int insertLoyaltyCompany(LoyaltyCompany loyaltyCompany) {
        return 0;
    }

    @Override
    public boolean updateLoyaltyCompany(LoyaltyCompany loyaltyCompany) {
        return false;
    }

    @Override
    public boolean deleteLoyaltyCompany(int loyaltyCompanyId) {
        return false;
    }

    private static LoyaltyCompany HydrateObject(ResultSet rs) throws SQLException {
        /*  private int LoyaltyCompanyId;
            private String CompanyName;
            private EntityType LoyaltyCompanyType;
        */

        //notes:    HYDRATING AN OBJECT
        LoyaltyCompany loyaltyCompany = new LoyaltyCompany();
        loyaltyCompany.setLoyaltyCompanyId(rs.getInt(1));
        loyaltyCompany.setCompanyName(rs.getString(2));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        loyaltyCompany.setLoyaltyCompanyType(bridge.getEntityTypeById(rs.getInt(3)));

        return loyaltyCompany;
    }
}
