package com.sxt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 黄药师
 * @date 2020-08-26 16:29
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   公司的条件 查询对象
 */
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CompanyCondition {
    // 公司名称
    private String cname;
    // 公司的账号状态
    private String status;
    // 公司的订单
    private String ordernumber;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public CompanyCondition() {
    }

    public CompanyCondition(String cname, String status, String ordernumber) {
        this.cname = cname;
        this.status = status;
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        return "CompanyCondition{" +
                "cname='" + cname + '\'' +
                ", status='" + status + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                '}';
    }
}
