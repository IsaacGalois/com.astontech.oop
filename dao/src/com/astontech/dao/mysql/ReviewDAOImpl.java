package com.astontech.dao.mysql;

import com.astontech.bo.Review;
import com.astontech.dao.ReviewDAO;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAOImpl extends MySQL implements ReviewDAO {
    @Override
    public Review getReviewById(int reviewId) {
        Connect();
        Review review = null; //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetReview(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, reviewId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                review = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return review;
    }

    @Override
    public List<Review> getReviewList() {
        Connect();
        List<Review> ReviewList = new ArrayList<>(); //not instantiated because if no records are returned we don't want to allocate memory

        try {
            String sp = "{call usp_GetReview(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);

            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()) {
                ReviewList.add(HydrateObject(rs));
            }


        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return ReviewList;
    }

    @Override
    public int insertReview(Review review) {
        return 0;
    }

    @Override
    public boolean updateReview(Review review) {
        return false;
    }

    @Override
    public boolean deleteReview(int reviewId) {
        return false;
    }

    private static Review HydrateObject(ResultSet rs) throws SQLException {
        /*  private int ReviewId;
            private String ReviewName;
            private Date ReviewDate;
            private int EmployeeId;
            private ReviewData ReviewData;
        */

        //notes:    HYDRATING AN OBJECT
        Review review = new Review();
        review.setReviewId(rs.getInt(1));
        review.setReviewName(rs.getString(2));
        review.setReviewDate(rs.getDate(3));
        review.setEmployeeId(rs.getInt(4));

        ReviewDataDAOImpl bridge = new ReviewDataDAOImpl();

        review.setReviewData(bridge.getReviewDataById(rs.getInt(5)));

        return review;
    }
}
