package com.astontech.dao.mysql;

import com.astontech.bo.Employee;
import com.astontech.dao.EmployeeDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.astontech.dao.mysql.Procedures.EXEC_Employee;
import static com.astontech.dao.mysql.Procedures.GET_Employee;

public class EmployeeDAOImpl extends MySQL implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(int employeeId) {
        Connect();
        Employee Employee = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Employee;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, employeeId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                Employee = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return Employee;
    }

    @Override
    public List<Employee> getEmployeeList() {
        Connect();
        List<Employee> EmployeeList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = GET_Employee;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EmployeeList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EmployeeList;
    }

    @Override
    public int insertEmployee(Employee Employee) {
        Connect();
        int id = 0;

        try {                    //(QueryId, EmployeeId, HireDate, TermDate, BirthDate, PersonId, CreateDate)
            String sp = EXEC_Employee;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setDate(3, DateHelper.utilDateToSqlDate(Employee.getHireDate()));
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(Employee.getTermDate()));
            cStmt.setDate(5, DateHelper.utilDateToSqlDate(Employee.getBirthDate()));
            cStmt.setInt(6, Employee.getPersonId());
            cStmt.setDate(7, DateHelper.utilDateToSqlDate(Employee.getCreateDate()));
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
    public boolean updateEmployee(Employee Employee) {
        Connect();
        boolean didUpdate = false;

        try {                    //(QueryId, EmployeeId, HireDate, TermDate, BirthDate, PersonId, CreateDate)
            String sp = EXEC_Employee;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, Employee.getEmployeeId());
            cStmt.setDate(3, DateHelper.utilDateToSqlDate(Employee.getHireDate()));
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(Employee.getTermDate()));
            cStmt.setDate(5, DateHelper.utilDateToSqlDate(Employee.getBirthDate()));
            cStmt.setInt(6, Employee.getPersonId());
            cStmt.setDate(7, DateHelper.utilDateToSqlDate(Employee.getCreateDate()));
            ResultSet rs = cStmt.executeQuery();

            if(rs.next())
                didUpdate = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didUpdate;
    }

    @Override
    public boolean deleteEmployee(int employeeId) {
        Connect();
        boolean didDelete = false;

        try {                    //(QueryId, EmployeeId, HireDate, TermDate, BirthDate, PersonId, CreateDate)
            String sp = EXEC_Employee;
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, employeeId);
            cStmt.setDate(3, new Date(0));
            cStmt.setDate(4, new Date(0));
            cStmt.setDate(5, new Date(0));
            cStmt.setInt(6, 0);
            cStmt.setDate(7, new Date(0));
            ResultSet rs = cStmt.executeQuery();

            if(rs.next() && rs.getInt(1) > 0)
                didDelete = true;

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return didDelete;
    }

    private static Employee HydrateObject(ResultSet rs) throws SQLException{
        /*  private int EmployeeId;
            private Date HireDate;
            private Date TermDate;
            private Date BirthDate;
            private Date CreateDate;
            private List<LoyaltyAccount> LoyaltyAccountList;
            private List<EmployeeProject> EmployeeProjectList;
            private List<Review> ReviewList;
            private List<Training> TrainingList;
        */

        //notes:    HYDRATING AN OBJECT
        Employee employee = new Employee();
        employee.setEmployeeId(rs.getInt(1));
        employee.setHireDate(rs.getDate(2));
        employee.setTermDate(rs.getDate(3));
        employee.setBirthDate(rs.getDate(4));
        employee.setEmployeeId(rs.getInt(5));
        employee.setCreateDate(rs.getDate(6));

        //finish populating lists

        return employee;
    }
}
