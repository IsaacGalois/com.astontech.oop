package com.astontech.dao;

import com.astontech.bo.ReviewData;

import java.util.List;

public interface ReviewDataDAO {

    //notes: GET methods
    public ReviewData getReviewDataById(int reviewDataId);
    public List<ReviewData> getReviewDataList();

    //notes: EXECUTE methods
    public int insertReviewData(ReviewData reviewData);
    public boolean updateReviewData(ReviewData reviewData);
    public boolean deleteReviewData(int reviewDataId);
}
