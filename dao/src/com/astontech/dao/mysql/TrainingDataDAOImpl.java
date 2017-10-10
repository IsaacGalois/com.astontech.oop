package com.astontech.dao.mysql;

import com.astontech.bo.TrainingData;
import com.astontech.dao.TrainingDataDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainingDataDAOImpl extends MySQL implements TrainingDataDAO {
    @Override
    public TrainingData getTrainingDataById(int trainingDataId) {
        Connect();
        TrainingData trainingData = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetTrainingData(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, trainingDataId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                trainingData = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return trainingData;
    }

    @Override
    public List<TrainingData> getTrainingDataList() {
        Connect();
        List<TrainingData> TrainingDataList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetTrainingData(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                TrainingDataList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return TrainingDataList;
    }

    @Override
    public int insertTrainingData(TrainingData trainingData) {
        return 0;
    }

    @Override
    public boolean updateTrainingData(TrainingData trainingData) {
        return false;
    }

    @Override
    public boolean deleteTrainingData(int trainingDataId) {
        return false;
    }

    private static TrainingData HydrateObject(ResultSet rs) throws SQLException{
        /*  private int TrainingDataId;
            private int TrainingId;
            private EntityType TrainingDataType;
            private int TrainingDataValue;
            private Date CreateDate;
        */

        //notes:    HYDRATING AN OBJECT
        TrainingData trainingData = new TrainingData();
        trainingData.setTrainingDataId(rs.getInt(1));
        trainingData.setTrainingId(rs.getInt(2));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        trainingData.setTrainingDataType(bridge.getEntityTypeById(rs.getInt(3)));
        trainingData.setTrainingDataValue(rs.getInt(4));
        trainingData.setCreateDate(rs.getDate(5));

        return trainingData;
    }
}
