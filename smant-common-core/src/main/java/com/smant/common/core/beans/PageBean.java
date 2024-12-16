package com.smant.common.core.beans;

import java.io.Serializable;

public class PageBean implements Serializable {

    private int pageNo = 1;//页码
    private int pageSize = 20;//每页大小
    private int startIndex;//起始索引
    private int endIndex;//截止索引

    public PageBean() {
        this.pageNo = 1;
        this.pageSize = 20;
        this.startIndex = (this.pageNo - 1) * pageSize;
        this.endIndex = startIndex + (pageSize - 1);
    }

    public PageBean(int pageNo, int pageSize) {
        if (pageNo > 0) {
            this.pageNo = pageNo;
        }
        if (pageSize > 0) {
            this.pageSize = pageSize;
        }
        this.startIndex = (this.pageNo - 1) * pageSize;
        this.endIndex = startIndex + (pageSize - 1);
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
//    public static void main(String[] args) throws ScriptException {
//        String a = "\"0.75\"-\"0.05\"-0";
//        System.out.println(jsegn.eval(a));
//
//        System.out.println(jsegn.eval(a));
//    }
}
