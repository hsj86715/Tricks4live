package com.tricks4live.entries;

public class Page<T extends Object> {
    private Integer pageIndex = 0;
    private Integer pageTotal = 0;
    private Long totalCount = 0L;
    private T pageData;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public T getPageData() {
        return pageData;
    }

    public void setPageData(T pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageIndex=" + pageIndex +
                ", pageTotal=" + pageTotal +
                ", totalCount=" + totalCount +
                ", pageData=" + pageData +
                '}';
    }
}
