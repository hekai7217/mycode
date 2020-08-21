package com.sxt.bean;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 黄药师
 * @date 2020-08-21 9:37
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   默认 对象的名称和表的名称一致
 *   解决 @TableName("t_student") 把对象和 数据库的表进行映射
 *
 */
@TableName("t_student")
public class Student {

    private Integer sid;

    private String sName;

    private String sage;

    private String ssex;

    private String sphone;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getSage() {
        return sage;
    }

    public void setSage(String sage) {
        this.sage = sage;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public Student() {
    }

    public Student(Integer sid, String sName, String sage, String ssex, String sphone) {
        this.sid = sid;
        this.sName = sName;
        this.sage = sage;
        this.ssex = ssex;
        this.sphone = sphone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", sage='" + sage + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sphone='" + sphone + '\'' +
                '}';
    }
}
