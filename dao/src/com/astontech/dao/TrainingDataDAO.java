package com.astontech.dao;

import com.astontech.bo.TrainingData;

import java.util.List;

public interface TrainingDataDAO {
    //notes: GET methods
    public TrainingData getTrainingDataById(int trainingDataId);
    public List<TrainingData> getTrainingDataList();

    //notes: EXECUTE methods
    public int insertTrainingData(TrainingData trainingData);
    public boolean updateTrainingData(TrainingData trainingData);
    public boolean deleteTrainingData(int trainingDataId);
}
