package com.sxt.pojo;

/**
 * @author 黄药师
 * @date 2020-08-25 15:35
 * @desc 百战程序员 http://www.itbaizhan.com
 *   host 条件查询的数据封装
 */
public class HostCondition {

    // 条件 项目查询
    private String hname;
    // 条件 状态
    private String status;
    // 条件 权重
    private String strong;
    // 条件 星推荐
    private String hpstar;
    // 条件 折扣
    private String hpdiscount;

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }

    public String getHpstar() {
        return hpstar;
    }

    public void setHpstar(String hpstar) {
        this.hpstar = hpstar;
    }

    public String getHpdiscount() {
        return hpdiscount;
    }

    public void setHpdiscount(String hpdiscount) {
        this.hpdiscount = hpdiscount;
    }

    public HostCondition(String hname, String status, String strong, String hpstar, String hpdiscount) {
        this.hname = hname;
        this.status = status;
        this.strong = strong;
        this.hpstar = hpstar;
        this.hpdiscount = hpdiscount;
    }

    public HostCondition() {
    }
}
