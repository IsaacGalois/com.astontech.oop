package com.astontech.dao;

import com.astontech.bo.Review;

import java.util.List;

public interface ReviewDAO {
    //notes: GET methods
    public Review getReviewById(int reviewId);
    public List<Review> getReviewList();

    //notes: EXECUTE methods
    public int insertReview(Review review);
    public boolean updateReview(Review review);
    public boolean deleteReview(int reviewId);
}
