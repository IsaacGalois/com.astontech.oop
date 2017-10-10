package com.astontech.bo;

import java.util.Date;

public class ProjectStatus extends BaseBO {
    private int ProjectStatusId;
    private int ProjectId;
    private EntityType ProjectStatusType;
    private String Notes;
    private int PercentComplete;
    private Date StartDate;
    private Date EndDate;

    public ProjectStatus() {
        this.ProjectStatusType = new EntityType();
    }
    public ProjectStatus(int ProjectId) {
        this.ProjectStatusType = new EntityType();
        this.ProjectId = ProjectId;
    }

    public int getProjectStatusId() {
        return ProjectStatusId;
    }

    public void setProjectStatusId(int projectStatusId) {
        ProjectStatusId = projectStatusId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public EntityType getProjectStatusType() {
        return this.ProjectStatusType;
    }

    public void setProjectStatusType(EntityType projectStatusType) {
        this.ProjectStatusType = projectStatusType;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
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
}
