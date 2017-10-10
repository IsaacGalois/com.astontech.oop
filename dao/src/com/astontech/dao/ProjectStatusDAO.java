package com.astontech.dao;

import com.astontech.bo.ProjectStatus;

import java.util.List;

public interface ProjectStatusDAO {
    //notes: GET methods
    public ProjectStatus getProjectStatusById(int projectStatusId);
    public List<ProjectStatus> getProjectStatusList();

    //notes: EXECUTE methods
    public int insertProjectStatus(ProjectStatus projectStatus);
    public boolean updateProjectStatus(ProjectStatus projectStatus);
    public boolean deleteProjectStatus(int projectStatusId);
}
