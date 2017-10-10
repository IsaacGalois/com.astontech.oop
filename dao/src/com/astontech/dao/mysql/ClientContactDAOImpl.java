package com.astontech.dao.mysql;

import com.astontech.bo.ClientContact;
import com.astontech.dao.ClientContactDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientContactDAOImpl extends MySQL implements ClientContactDAO {
    @Override
    public ClientContact getClientContactById(int ClientContactId) {
        Connect();
        ClientContact clientContact = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetClientContact(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, ClientContactId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                clientContact = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return clientContact;
    }

    @Override
    public List<ClientContact> getClientContactList() {
        Connect();
        List<ClientContact> ClientContactList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetClientContact(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ClientContactList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ClientContactList;
    }

    @Override
    public int insertClientContact(ClientContact clientContact) {
        return 0;
    }

    @Override
    public boolean updateClientContact(ClientContact clientContact) {
        return false;
    }

    @Override
    public boolean deleteClientContact(int clientContactId) {
        return false;
    }

    private static ClientContact HydrateObject(ResultSet rs) throws SQLException{
        /*  private int ClientContactId;
            private Client Client;
            private EntityType ContactType;
            private int PersonId;
        */

        //notes:    HYDRATING AN OBJECT
        ClientContact clientContact = new ClientContact();
        clientContact.setClientContactId(rs.getInt(1));

        ClientDAOImpl bridge1 = new ClientDAOImpl();

        clientContact.setClient(bridge1.getClientById(rs.getInt(1)));

        EntityTypeDAOImpl bridge2 = new EntityTypeDAOImpl();

        clientContact.setContactType(bridge2.getEntityTypeById(rs.getInt(3)));
        clientContact.setPersonId(rs.getInt(4));

        return clientContact;
    }
}
