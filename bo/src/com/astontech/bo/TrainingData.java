package com.astontech.bo;

import java.util.Date;

public class TrainingData extends BaseBO {
    private int TrainingDataId;
    private int TrainingId;
    private EntityType TrainingDataType;
    private int TrainingDataValue;
    private Date CreateDate;

    public TrainingData() {
        this.TrainingDataType = new EntityType();
    }
    public TrainingData(int TrainingId) {
        this.TrainingDataType = new EntityType();
        this.TrainingId = TrainingId;
    }

    public int getTrainingDataId() {
        return TrainingDataId;
    }

    public void setTrainingDataId(int trainingDataId) {
        TrainingDataId = trainingDataId;
    }

    public int getTrainingId() {
        return TrainingId;
    }

    public void setTrainingId(int trainingId) {
        TrainingId = trainingId;
    }

    public EntityType getTrainingDataType() {
        return this.TrainingDataType;
    }

    public void setTrainingDataType(EntityType trainingDataType) {
        this.TrainingDataType = trainingDataType;
    }

    public int getTrainingDataValue() {
        return TrainingDataValue;
    }

    public void setTrainingDataValue(int trainingDataValue) {
        TrainingDataValue = trainingDataValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
