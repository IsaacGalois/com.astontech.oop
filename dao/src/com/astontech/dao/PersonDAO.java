package com.astontech.dao;

import com.astontech.bo.Person;
import java.util.List;

public interface PersonDAO {

    //notes: GET methods
    public Person getPersonById(int personId);
    public List<Person> getPersonList();

    //notes: EXECUTE methods
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int PersonId);

}
