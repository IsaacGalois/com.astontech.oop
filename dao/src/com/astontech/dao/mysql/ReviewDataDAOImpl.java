package com.astontech.dao.mysql;

import com.astontech.bo.ReviewData;
import com.astontech.dao.ReviewDataDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDataDAOImpl extends MySQL implements ReviewDataDAO {
    @Override
    public ReviewData getReviewDataById(int reviewDataId) {
        Connect();
        ReviewData reviewData = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetReviewData(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, reviewDataId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                reviewData = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return reviewData;
    }

    @Override
    public List<ReviewData> getReviewDataList() {
        Connect();
        List<ReviewData> ReviewDataList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetReviewData(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ReviewDataList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ReviewDataList;
    }

    @Override
    public int insertReviewData(ReviewData reviewData) {
        return 0;
    }

    @Override
    public boolean updateReviewData(ReviewData reviewData) {
        return false;
    }

    @Override
    public boolean deleteReviewData(int reviewDataId) {
        return false;
    }

    private static ReviewData HydrateObject(ResultSet rs) throws SQLException {
        /*  private int ReviewDataId;
            private int ReviewId;
            private EntityType ReviewDataType;
            private int ReviewDateValue;
            private Date CreateDate;
        */

        //notes:    HYDRATING AN OBJECT
        ReviewData ReviewData = new ReviewData();
        ReviewData.setReviewDataId(rs.getInt(1));
        ReviewData.setReviewId(rs.getInt(2));

        EntityTypeDAOImpl bridge = new EntityTypeDAOImpl();

        ReviewData.setReviewDataType(bridge.getEntityTypeById(rs.getInt(3)));
        ReviewData.setReviewDateValue(rs.getInt(4));
        ReviewData.setCreateDate(rs.getDate(5));

        return ReviewData;
    }
}
