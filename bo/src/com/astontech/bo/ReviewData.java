package com.astontech.bo;

import java.util.Date;

public class ReviewData extends BaseBO {
    private int ReviewDataId;
    private int ReviewId;
    private EntityType ReviewDataType;
    private int ReviewDateValue;
    private Date CreateDate;

    public ReviewData() {
        this.ReviewDataType = new EntityType();
    }
    public ReviewData(int ReviewId) {
        this.ReviewDataType = new EntityType();
        this.ReviewId = ReviewId;
    }

    public int getReviewDataId() {
        return ReviewDataId;
    }

    public void setReviewDataId(int reviewDataId) {
        ReviewDataId = reviewDataId;
    }

    public int getReviewId() {
        return ReviewId;
    }

    public void setReviewId(int reviewId) {
        ReviewId = reviewId;
    }

    public EntityType getReviewDataType() {
        return ReviewDataType;
    }

    public void setReviewDataType(EntityType reviewDataType) {
        this.ReviewDataType = reviewDataType;
    }

    public int getReviewDateValue() {
        return ReviewDateValue;
    }

    public void setReviewDateValue(int reviewDateValue) {
        ReviewDateValue = reviewDateValue;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
}
