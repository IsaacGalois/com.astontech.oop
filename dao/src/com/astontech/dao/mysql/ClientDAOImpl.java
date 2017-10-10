package com.astontech.dao.mysql;

import com.astontech.bo.Client;
import com.astontech.dao.ClientDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl extends MySQL implements ClientDAO {
    @Override
    public Client getClientById(int clientId) {
        Connect();
        Client client = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetClient(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, clientId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                client = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return client;
    }

    @Override
    public List<Client> getClientList() {
        Connect();
        List<Client> ClientList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetClient(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ClientList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ClientList;
    }

    @Override
    public int insertClient(Client client) {
        return 0;
    }

    @Override
    public boolean updateClient(Client client) {
        return false;
    }

    @Override
    public boolean deleteClient(int clientId) {
        return false;
    }

    private static Client HydrateObject(ResultSet rs) throws SQLException{
        /*  private int ClientId;
            private String ClientName;
            private Date CreateDate;
            private List<Address> AddressList;
            private List<Phone> PhoneList;
            private List<Project> ProjectList;
        */

        //notes:    HYDRATING AN OBJECT
        Client Client = new Client();
        Client.setClientId(rs.getInt(1));
        Client.setClientName(rs.getString(2));
        Client.setCreateDate(rs.getDate(3));

        //finish populating lists

        return Client;
    }
}
