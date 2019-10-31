package com.qfedu.vo;

import java.util.List;

/**
 * Created by Administrator on 2019/6/4.
 */
public class VPageInfo<T> {
    private int currentPage;
    private int totalPage;
    private List<T> pageList;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "VPageInfo{" +
                "currentPage=" + currentPage +
                ", totalPage=" + totalPage +
                ", pageList=" + pageList +
                '}';
    }
}
