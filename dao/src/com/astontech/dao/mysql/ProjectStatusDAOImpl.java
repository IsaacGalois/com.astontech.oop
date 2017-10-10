package com.astontech.dao.mysql;

import com.astontech.bo.ProjectStatus;
import com.astontech.dao.ProjectStatusDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectStatusDAOImpl extends MySQL implements ProjectStatusDAO{
    @Override
    public ProjectStatus getProjectStatusById(int projectStatusId) {
        Connect();
        ProjectStatus projectStatus = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetProjectStatus(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, projectStatusId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                projectStatus = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return projectStatus;
    }

    @Override
    public List<ProjectStatus> getProjectStatusList() {
        Connect();
        List<ProjectStatus> ProjectStatusList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetProjectStatus(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ProjectStatusList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ProjectStatusList;
    }

    @Override
    public int insertProjectStatus(ProjectStatus projectStatus) {
        return 0;
    }

    @Override
    public boolean updateProjectStatus(ProjectStatus projectStatus) {
        return false;
    }

    @Override
    public boolean deleteProjectStatus(int projectStatusId) {
        return false;
    }

    private static ProjectStatus HydrateObject(ResultSet rs) throws SQLException {
        /*  private int ProjectStatusId;
            private int ProjectId;
            private EntityType ProjectStatusType;
            private String Notes;
            private int PercentComplete;
            private Date StartDate;
            private Date EndDate;
        */

        //notes:    HYDRATING AN OBJECT
        ProjectStatus projectStatus = new ProjectStatus();
        projectStatus.setProjectStatusId(rs.getInt(1));
        projectStatus.setProjectId(rs.getInt(2));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        projectStatus.setProjectStatusType(bridge.getEntityTypeById(rs.getInt(3)));
        projectStatus.setNotes(rs.getString(4));
        projectStatus.setPercentComplete(rs.getInt(5));
        projectStatus.setStartDate(rs.getDate(6));
        projectStatus.setEndDate(rs.getDate(7));

        return projectStatus;
    }
}
