package com.astontech.bo;

import java.util.Date;

public class Review extends BaseBO {
    private int ReviewId;
    private String ReviewName;
    private Date ReviewDate;
    private int EmployeeId;
    private ReviewData ReviewData;

    public Review() {
        this.setReviewData(new ReviewData());}
    public Review(String ReviewName) {
        this.setReviewData(new ReviewData());
        this.ReviewName = ReviewName;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public String getReviewName() {
        return ReviewName;
    }

    public void setReviewName(String reviewName) {
        ReviewName = reviewName;
    }

    public Date getReviewDate() {
        return ReviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        ReviewDate = reviewDate;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public com.astontech.bo.ReviewData getReviewData() {
        return ReviewData;
    }

    public void setReviewData(com.astontech.bo.ReviewData reviewData) {
        ReviewData = reviewData;
    }
}
