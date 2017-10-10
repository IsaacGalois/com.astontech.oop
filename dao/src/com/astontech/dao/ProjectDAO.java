package com.astontech.dao;

import com.astontech.bo.Project;

import java.util.List;

public interface ProjectDAO {
    //notes: GET methods
    public Project getProjectById(int projectId);
    public List<Project> getProjectList();

    //notes: EXECUTE methods
    public int insertProject(Project project);
    public boolean updateProject(Project project);
    public boolean deleteProject(int projectId);
}
