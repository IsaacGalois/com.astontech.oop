package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Person {

    //region PARAMETERS
    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;
    private Date BirthDate;
    private Date CreateDate;
    private List<LoyaltyAccount> LoyaltyAccountList;
    private List<EmployeeProject> EmployeeProjectList;
    private List<Review> ReviewList;
    private List<Training> TrainingList;
    //endregion

    //region CONSTRUCTORS
    public Employee() {
        this.setLoyaltyAccountList(new ArrayList<>());
        this.setEmployeeProjectList(new ArrayList<>());
        this.setReviewList(new ArrayList<>());
        this.setTrainingList(new ArrayList<>());
    }

    public Employee(String firstName, String lastName) {
        this.setLoyaltyAccountList(new ArrayList<>());
        this.setEmployeeProjectList(new ArrayList<>());
        this.setReviewList(new ArrayList<>());
        this.setTrainingList(new ArrayList<>());
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }
    //endregion

    //region GETTERS AND SETTERS
    public Employee(String firstName) {
        this.setFirstName(firstName);
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date hireDate) {
        HireDate = hireDate;
    }

    public Date getTermDate() {
        return TermDate;
    }

    public void setTermDate(Date termDate) {
        TermDate = termDate;
    }

    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public List<LoyaltyAccount> getLoyaltyAccountList() {
        return LoyaltyAccountList;
    }

    public void setLoyaltyAccountList(List<LoyaltyAccount> loyaltyAccountList) {
        LoyaltyAccountList = loyaltyAccountList;
    }

    public List<EmployeeProject> getEmployeeProjectList() {
        return EmployeeProjectList;
    }

    public void setEmployeeProjectList(List<EmployeeProject> employeeProjectList) {
        EmployeeProjectList = employeeProjectList;
    }

    public List<Review> getReviewList() {
        return ReviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        ReviewList = reviewList;
    }

    public List<Training> getTrainingList() {
        return TrainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        TrainingList = trainingList;
    }
    //endregion

    //region HELPER METHODS
    public String getAge() {
        Date now = new Date();
        Date age = new Date(now.getTime() - this.BirthDate.getTime());
        return age.toString();
    }
    //endregion

}
