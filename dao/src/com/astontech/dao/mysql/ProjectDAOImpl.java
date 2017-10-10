package com.astontech.dao.mysql;

import com.astontech.bo.Project;
import com.astontech.dao.ProjectDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl extends MySQL implements ProjectDAO{
    @Override
    public Project getProjectById(int projectId) {
        Connect();
        Project project = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetProject(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, projectId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                project = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return project;
    }

    @Override
    public List<Project> getProjectList() {
        Connect();
        List<Project> ProjectList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetProject(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ProjectList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ProjectList;
    }

    @Override
    public int insertProject(Project project) {
        return 0;
    }

    @Override
    public boolean updateProject(Project project) {
        return false;
    }

    @Override
    public boolean deleteProject(int projectId) {
        return false;
    }

    private static Project HydrateObject(ResultSet rs) throws SQLException{
        /*  private int ProjectId;
            private int ClientId;
            private EntityType ProjectType;
            private int Rate;
            private Date StartDate;
            private Date EndDate;
            private String ProjectName;
            private ProjectStatus ProjectStatus;
        */

        //notes:    HYDRATING AN OBJECT
        Project project = new Project();
        project.setProjectId(rs.getInt(1));
        project.setClientId(rs.getInt(2));

        EntityTypeDAOImpl bridge1 = new EntityTypeDAOImpl();

        project.setProjectType(bridge1.getEntityTypeById(rs.getInt(3)));
        project.setRate(rs.getInt(4));
        project.setStartDate(rs.getDate(5));
        project.setEndDate(rs.getDate(6));
        project.setProjectName(rs.getString(7));

        ProjectStatusDAOImpl bridge2 = new ProjectStatusDAOImpl();

        project.setProjectStatus(bridge2.getProjectStatusById(rs.getInt(8)));

        return project;
    }
}
