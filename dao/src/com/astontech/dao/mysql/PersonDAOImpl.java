package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImpl extends MySQL implements PersonDAO{
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                person = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                personList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        Connect();
        int id = 0;

        try {                    //(QueryID, PersonId, Title, FirstName,LastName, DisplayFirstName, isDeleted, Gender)
            String sp = "{call usp_ExecutePerson(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getLastName());
            cStmt.setString(6, person.getDisplayFirstName());
            cStmt.setInt(7, 0);
            cStmt.setString(8, person.getGender());
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
    public boolean updatePerson(Person person) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryID, PersonId, Title, FirstName,LastName, DisplayFirstName, isDeleted, Gender)
            String sp = "{call usp_ExecutePerson(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, person.getPersonId());
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getLastName());
            cStmt.setString(6, person.getDisplayFirstName());
            cStmt.setInt(7, 0);
            cStmt.setString(8, person.getGender());
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                didUpdate = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didUpdate;
    }

    @Override
    public boolean deletePerson(int personId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryID, PersonId, Title, FirstName,LastName, DisplayFirstName, isDeleted, Gender)
            String sp = "{call usp_ExecutePerson(?, ?, ?, ?, ?, ?, ?, ?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, personId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setInt(7, 0);
            cStmt.setString(8, "");
            ResultSet rs = cStmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0)
                didDelete = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didDelete;
    }

    private static Person HydrateObject(ResultSet rs) throws SQLException{
        /*  private int PersonId;
            private String Title;
            private String FirstName;
            private String LastName;
            private String DisplayFirstName;
            private String Gender;

            private List<Email> EmailList;
            private List<Address> AddressList;
            private List<Phone> PhoneList;
            private List<ClientContact> ClientContactList;
        */

        //notes:    HYDRATING AN OBJECT
        Person person = new Person();
        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setLastName(rs.getString(4));
        person.setDisplayFirstName(rs.getString(5));
        person.setGender(rs.getString(6));

        return person;
    }
}
