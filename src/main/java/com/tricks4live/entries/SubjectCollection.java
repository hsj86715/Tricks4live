package com.tricks4live.entries;

/**
 * 用户收藏，MySQL存储
 */
public class SubjectCollection extends BaseDBEntry {
    private Long userId;
    private Long subjectId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }


    @Override
    public String toString() {
        return "SubjectCollection{" + super.toString() +
                ", userId=" + userId +
                ", subjectId=" + subjectId +
                '}';
    }
}
