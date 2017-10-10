package com.astontech.dao.mysql;

import com.astontech.bo.Email;
import com.astontech.dao.EmailDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_Email;
import static com.astontech.dao.mysql.Procedures.GET_Email;

public class EmailDAOImpl extends MySQL implements EmailDAO {
    @Override
    public Email getEmailById(int emailId) {
        Connect();
        Email Email = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Email;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, emailId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Email = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return Email;
    }

    @Override
    public List<Email> getEmailList() {
        Connect();
        List<Email> EmailList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Email;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EmailList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EmailList;
    }

    @Override
    public int insertEmail(Email Email) {
        Connect();
        int id = 0;

        try {                    //(QueryID, EmailId, EmailAddress, EmployeeId, EntityTypeId)
            String sp = EXEC_Email;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, Email.getEmailAddress());
            cStmt.setInt(4, Email.getEmployeeId());
            cStmt.setInt(5, Email.getEmailType().getEntityTypeId());
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
    public boolean updateEmail(Email Email) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryID, EmailId, EmailAddress, EmployeeId, EntityTypeId)
            String sp = EXEC_Email;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, Email.getEmailId());
            cStmt.setString(3, Email.getEmailAddress());
            cStmt.setInt(4, Email.getEmployeeId());
            cStmt.setInt(5, Email.getEmailType().getEntityTypeId());
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                didUpdate = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didUpdate;
    }

    @Override
    public boolean deleteEmail(int EmailId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryID, EmailId, EmailAddress, EmployeeId, EntityTypeId)
            String sp = EXEC_Email;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, EmailId);
            cStmt.setString(3, "");
            cStmt.setInt(4, 0);
            cStmt.setInt(5, 0);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0)
                didDelete = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didDelete;
    }
    
    public Email HydrateObject(ResultSet rs) throws SQLException{
        /*  private int EmailId;
            private String EmailAddress;
            private int EmployeeId;
            private EntityType EmailType;
        */

        //notes:    HYDRATING AN OBJECT
        Email Email = new Email();
        Email.setEmailId(rs.getInt(1));
        Email.setEmailAddress(rs.getString(2));
        Email.setEmployeeId(rs.getInt(3));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        Email.setEmailType(bridge.getEntityTypeById(rs.getInt(4)));

        return Email;
    }
}
