package com.sxt.pojo;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-22 14:41
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class PageResult <T>{

    private long total;

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public PageResult() {
    }

    public PageResult(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
