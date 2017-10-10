package com.astontech.dao.mysql;

import com.astontech.bo.Phone;
import com.astontech.dao.PhoneDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_Phone;
import static com.astontech.dao.mysql.Procedures.GET_Phone;

public class PhoneDAOImpl extends MySQL implements PhoneDAO {
    @Override
    public Phone getPhoneById(int phoneId) {
        Connect();
        Phone Phone = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Phone;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, phoneId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Phone = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return Phone;
    }

    @Override
    public List<Phone> getPhoneList() {
        Connect();
        List<Phone> PhoneList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Phone;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                PhoneList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return PhoneList;
    }

    @Override
    public int insertPhone(Phone Phone) {
        Connect();
        int id = 0;

        try {                    //(QueryId, PhoneId, EntityTypeId, ClientId, PersonId, AreaCode, PhoneNumber, PhoneNumberPost)
            String sp = EXEC_Phone;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setInt(3, Phone.getPhoneType().getEntityTypeId());
            cStmt.setInt(4, Phone.getClientId());
            cStmt.setInt(5, Phone.getPersonId());
            cStmt.setInt(6, Phone.getAreaCode());
            cStmt.setInt(7, Phone.getPhoneNumber());
            cStmt.setInt(8, Phone.getPhoneNumberPost());
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                id = rs.getInt(1);
            else
                id = -1;


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return id;
    }

    @Override
    public boolean updatePhone(Phone Phone) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryId, PhoneId, EntityTypeId, ClientId, PersonId, AreaCode, PhoneNumber, PhoneNumberPost)
            String sp = EXEC_Phone;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, Phone.getPhoneId());
            cStmt.setInt(3, Phone.getPhoneType().getEntityTypeId());
            cStmt.setInt(4, Phone.getClientId());
            cStmt.setInt(5, Phone.getPersonId());
            cStmt.setInt(6, Phone.getAreaCode());
            cStmt.setInt(7, Phone.getPhoneNumber());
            cStmt.setInt(8, Phone.getPhoneNumberPost());
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                didUpdate = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didUpdate;
    }

    @Override
    public boolean deletePhone(int PhoneId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryId, PhoneId, EntityTypeId, ClientId, PersonId, AreaCode, PhoneNumber, PhoneNumberPost)
            String sp = EXEC_Phone;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, PhoneId);
            cStmt.setInt(3, 0);
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);
            cStmt.setInt(6, 0);
            cStmt.setInt(7, 0);
            cStmt.setInt(8, 0);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0)
                didDelete = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didDelete;
    }
    
    public Phone HydrateObject(ResultSet rs) throws SQLException{
        /*  private int PhoneId;
            private EntityType PhoneType;
            private int ClientId;
            private int PhoneId;
            private int AreaCode;
            private int PhoneNumber;
            private int PhoneNumberPost;
        */

            //notes:    HYDRATING AN OBJECT
            Phone Phone = new Phone();
            Phone.setPhoneId(rs.getInt(1));

            EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

            Phone.setPhoneType(bridge.getEntityTypeById(rs.getInt(2)));
            Phone.setClientId(rs.getInt(3));
            Phone.setPersonId(rs.getInt(4));
            Phone.setAreaCode(rs.getInt(5));
            Phone.setPhoneNumber(rs.getInt(6));
            Phone.setPhoneNumberPost(rs.getInt(7));

            return Phone;
    }
}
