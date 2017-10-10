package com.astontech.bo;

import java.util.Date;

public class EmployeeProject extends BaseBO{
    private int EmployeeProjectId;
    private Project Project;
    private int EmployeeId;
    private EntityType EmployeeProjectType;
    private Vehicle ProjectVehicle;
    private Date StartDate;
    private Date EndDate;
    private String Notes;

    public EmployeeProject() {
        this.Project = new Project();
        this.EmployeeProjectType = new EntityType();
        this.ProjectVehicle = new Vehicle();
    }
    public EmployeeProject(Project Project) {
        this.Project = Project;
        this.EmployeeProjectType = new EntityType();
        this.ProjectVehicle = new Vehicle();
    }

    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public Project getProject() {
        return this.Project;
    }

    public void setProject(Project project) {
        this.Project = project;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public EntityType getEmployeeProjectType() {
        return this.EmployeeProjectType;
    }

    public void setEmployeeProjectType(EntityType employeeProjectType) {
        this.EmployeeProjectType = employeeProjectType;
    }

    public Vehicle getProjectVehicle() {
        return this.ProjectVehicle;
    }

    public void setProjectVehicle(Vehicle projectVehicle) {
        this.ProjectVehicle = projectVehicle;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

}
