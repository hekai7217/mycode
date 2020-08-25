package com.sxt.pojo;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-25 9:46
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   封装 DataGrid 分页的数据
 *
 *    total  页面总数
 *    rows   页面展示的数据
 *
 *    rows:{json数据集}
 *
 *    PageResult 这里封装的是 total / rows 属性
 *
 */
public class PageResult<T> {

    private Long total;

    private List<T> rows;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
