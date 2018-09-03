package com.tricks4live.entries;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.List;

@JsonSerialize
public class Page<T> implements Serializable {
    private Long pageNum;
    private Integer pageSize;
    private List<T> contentResults;
    private Long totalCount;

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getContentResults() {
        return contentResults;
    }

    public void setContentResults(List<T> contentResults) {
        this.contentResults = contentResults;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getTotalPages() {
        if (totalCount == null || totalCount == 0) {
            return 0L;
        } else {
            Integer more = Math.toIntExact(totalCount % pageSize);
            Long totalPage = totalCount / pageSize;
            if (more > 0) {
                totalPage++;
            }
            return totalPage;
        }
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", contentResults=" + contentResults +
                ", totalCount=" + totalCount +
                ", totalPages=" + getTotalPages() +
                '}';
    }
}
