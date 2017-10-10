package com.astontech.bo;

import java.util.Date;

public class Project extends BaseBO {
    private int ProjectId;
    private int ClientId;
    private EntityType ProjectType;
    private int Rate;
    private Date StartDate;
    private Date EndDate;
    private String ProjectName;
    private ProjectStatus ProjectStatus;

    public Project() {
        this.ProjectType = new EntityType();
        this.setProjectStatus(new ProjectStatus());
    }
    public Project(int ClientId) {
        this.ProjectType = new EntityType();
        this.setProjectStatus(new ProjectStatus());
        this.ClientId = ClientId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public EntityType getProjectType() {
        return this.ProjectType;
    }

    public void setProjectType(EntityType projectType) {
        this.ProjectType = projectType;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public com.astontech.bo.ProjectStatus getProjectStatus() {
        return ProjectStatus;
    }

    public void setProjectStatus(com.astontech.bo.ProjectStatus projectStatus) {
        ProjectStatus = projectStatus;
    }

    //helper methods
    public String getDuration() {
        Date duration = new Date(this.EndDate.getTime()-this.StartDate.getTime());
        return duration.toString();
    }
}
