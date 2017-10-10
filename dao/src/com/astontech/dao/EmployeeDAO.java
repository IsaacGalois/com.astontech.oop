package com.astontech.dao;

import com.astontech.bo.Employee;
import java.util.List;

public interface EmployeeDAO {

    //notes: GET methods
    public Employee getEmployeeById(int employeeId);
    public List<Employee> getEmployeeList();

    //notes: EXECUTE methods
    public int insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(int employeeId);

}
