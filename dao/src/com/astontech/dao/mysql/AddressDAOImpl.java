package com.astontech.dao.mysql;

import com.astontech.bo.Address;
import com.astontech.dao.AddressDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAOImpl extends MySQL implements AddressDAO {
    @Override
    public Address getAddressById(int addressId) {
        Connect();
        Address address = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetAddress(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, addressId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                address = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return address;
    }

    @Override
    public List<Address> getAddressList() {
        Connect();
        List<Address> AddressList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetAddress(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                AddressList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return AddressList;
    }

    @Override
    public int insertAddress(Address address) {
        return 0;
    }

    @Override
    public boolean updateAddress(Address address) {
        return false;
    }

    @Override
    public boolean deleteAddress(int addressId) {
        return false;
    }

    private static Address HydrateObject(ResultSet rs) throws SQLException {
        /*  private int AddressId;
            private int ClientId;
            private int PersonId;
            private EntityType AddressType;
            private int AddressNum;
            private String Street;
            private String Street02;
            private String City;
            private int StateId;
            private int CountryId;
            private Date DateCreate;
        */

        //notes:    HYDRATING AN OBJECT
        Address address = new Address();
        address.setAddressId(rs.getInt(1));
        address.setClientId(rs.getInt(2));
        address.setPersonId(rs.getInt(3));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        address.setAddressType(bridge.getEntityTypeById(rs.getInt(4)));
        address.setAddressNum(rs.getInt(5));
        address.setStreet(rs.getString(6));
        address.setStreet02(rs.getString(7));
        address.setCity(rs.getString(8));
        address.setStateId(rs.getInt(9));
        address.setCountryId(rs.getInt(10));
        address.setDateCreate(rs.getDate(11));

        return address;
    }
}
