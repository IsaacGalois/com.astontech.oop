package com.astontech.bo;

import java.util.Date;

public class Training extends BaseBO {
    private int TrainingId;
    private int EmployeeId;
    private String TrainingName;
    private Date CreateDate;
    private TrainingData TrainingData;

    public Training() {
        this.setTrainingData(new TrainingData());
    }
    public Training(String TrainingName) {
        this.setTrainingData(new TrainingData());
        this.TrainingName = TrainingName;
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public String getTrainingName() {
        return TrainingName;
    }

    public void setTrainingName(String trainingName) {
        TrainingName = trainingName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public TrainingData getTrainingData() {
        return TrainingData;
    }

    public void setTrainingData(TrainingData trainingData) {
        TrainingData = trainingData;
    }
}
