package com.astontech.dao;

import com.astontech.bo.Address;

import java.util.List;

public interface AddressDAO {
    //notes: GET methods
    public Address getAddressById(int addressId);
    public List<Address> getAddressList();

    //notes: EXECUTE methods
    public int insertAddress(Address address);
    public boolean updateAddress(Address address);
    public boolean deleteAddress(int addressId);
}
