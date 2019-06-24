package com.muyu.zhibo.bean.liguiBean;

import android.support.annotation.NonNull;

import java.util.List;

public class ListBean{
    private String cursor;
    private int size;
    private int page;
    private String preCursor;
    private String nextCursor;
    private int count;
    private int totalCount;
    private boolean hasnext;
    private int totalPage;
    private List<List<DataBean>> data;

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getPreCursor() {
        return preCursor;
    }

    public void setPreCursor(String preCursor) {
        this.preCursor = preCursor;
    }

    public String getNextCursor() {
        return nextCursor;
    }

    public void setNextCursor(String nextCursor) {
        this.nextCursor = nextCursor;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public boolean isHasnext() {
        return hasnext;
    }

    public void setHasnext(boolean hasnext) {
        this.hasnext = hasnext;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }



    @Override
    public String toString() {
        return "ListBean{" +
                "cursor='" + cursor + '\'' +
                ", size=" + size +
                ", page=" + page +
                ", preCursor='" + preCursor + '\'' +
                ", nextCursor='" + nextCursor + '\'' +
                ", count=" + count +
                ", totalCount=" + totalCount +
                ", hasnext=" + hasnext +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}
