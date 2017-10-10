package com.astontech.dao.mysql;

import com.astontech.bo.Training;
import com.astontech.dao.TrainingDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingDAOImpl extends MySQL implements TrainingDAO {
    @Override
    public Training getTrainingById(int trainingId) {
        Connect();
        Training training = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetTraining(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, trainingId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                training = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return training;
    }

    @Override
    public List<Training> getTrainingList() {
        Connect();
        List<Training> TrainingList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetTraining(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                TrainingList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return TrainingList;
    }

    @Override
    public int insertTraining(Training training) {
        return 0;
    }

    @Override
    public boolean updateTraining(Training training) {
        return false;
    }

    @Override
    public boolean deleteTraining(int trainingId) {
        return false;
    }

    private static Training HydrateObject(ResultSet rs) throws SQLException {
        /*  private int TrainingId;
            private int EmployeeId;
            private String TrainingName;
            private Date CreateDate;
            private TrainingData TrainingData;
        */

        //notes:    HYDRATING AN OBJECT
        Training training = new Training();
        training.setTrainingId(rs.getInt(1));
        training.setEmployeeId(rs.getInt(2));
        training.setTrainingName(rs.getString(3));
        training.setCreateDate(rs.getDate(4));

        TrainingDataDAOImpl bridge = new TrainingDataDAOImpl();

        training.setTrainingData(bridge.getTrainingDataById(rs.getInt(5)));

        return training;
    }
}
