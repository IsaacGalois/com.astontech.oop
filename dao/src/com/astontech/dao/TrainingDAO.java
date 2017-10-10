package com.astontech.dao;

import com.astontech.bo.Training;

import java.util.List;

public interface TrainingDAO {
    //notes: GET methods
    public Training getTrainingById(int trainingId);
    public List<Training> getTrainingList();

    //notes: EXECUTE methods
    public int insertTraining(Training training);
    public boolean updateTraining(Training training);
    public boolean deleteTraining(int trainingId);
}
