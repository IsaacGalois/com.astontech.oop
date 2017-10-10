package com.astontech.dao;

import com.astontech.bo.EmployeeProject;

import java.util.List;

public interface EmployeeProjectDAO {
    //notes: GET methods
    public EmployeeProject getEmployeeProjectById(int employeeProjectId);
    public List<EmployeeProject> getEmployeeProjectList();

    //notes: EXECUTE methods
    public int insertEmployeeProject(EmployeeProject employeeProject);
    public boolean updateEmployeeProject(EmployeeProject employeeProject);
    public boolean deleteEmployeeProject(int employeeProjectId);
}
