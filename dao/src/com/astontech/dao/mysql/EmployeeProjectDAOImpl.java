package com.astontech.dao.mysql;

import com.astontech.bo.EmployeeProject;
import com.astontech.dao.EmployeeProjectDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectDAOImpl extends MySQL implements EmployeeProjectDAO {
    @Override
    public EmployeeProject getEmployeeProjectById(int employeeProjectId) {
        Connect();
        EmployeeProject employeeProject = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEmployeeProject(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, employeeProjectId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                employeeProject = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return employeeProject;
    }

    @Override
    public List<EmployeeProject> getEmployeeProjectList() {
        Connect();
        List<EmployeeProject> EmployeeProjectList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetEmployeeProject(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                EmployeeProjectList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return EmployeeProjectList;
    }

    @Override
    public int insertEmployeeProject(EmployeeProject employeeProject) {
        return 0;
    }

    @Override
    public boolean updateEmployeeProject(EmployeeProject employeeProject) {
        return false;
    }

    @Override
    public boolean deleteEmployeeProject(int employeeProjectId) {
        return false;
    }

    private static EmployeeProject HydrateObject(ResultSet rs) throws SQLException {
        /*  private int EmployeeProjectId;
            private Project Project;
            private int EmployeeId;
            private EntityType EmployeeProjectType;
            private Vehicle ProjectVehicle;
            private Date StartDate;
            private Date EndDate;
            private String Notes;
        */

        //notes:    HYDRATING AN OBJECT
        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployeeProjectId(rs.getInt(1));

        ProjectDAOImpl bridge1 = new ProjectDAOImpl();

        employeeProject.setProject(bridge1.getProjectById(rs.getInt(2)));
        employeeProject.setEmployeeId(rs.getInt(3));

        EntityTypeDAOImpl bridge2 = new EntityTypeDAOImpl();

        employeeProject.setEmployeeProjectType(bridge2.getEntityTypeById(rs.getInt(4)));

        VehicleDAOImpl bridge3 = new VehicleDAOImpl();

        employeeProject.setProjectVehicle(bridge3.getVehicleById(rs.getInt(5)));
        employeeProject.setStartDate(rs.getDate(6));
        employeeProject.setEndDate(rs.getDate(7));
        employeeProject.setNotes(rs.getString(8));

        return employeeProject;
    }
}
