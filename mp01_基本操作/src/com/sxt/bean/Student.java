package com.sxt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author 黄药师
 * @date 2020-08-21 9:37
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   默认 对象的名称和表的名称一致
 *   解决 @TableName("t_student") 把对象和 数据库的表进行映射
 */
public class Student {

    // 用在主键 上面  IdType.AUTO 是数据库主键自增   value (和数据库主键 映射 如果和数据库主键一样 可以 省略)
    private Integer sid;

    // 这个注解可以 把 属性名称 和表的自动进行映射
    @TableField("s_name")
    private String sName;

    private Integer sage;

    private String ssex;

    private String sphone;

    //属性
    @TableField(exist =  false)
    private String info;


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

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
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

    public Student(Integer sid, String sName, Integer sage, String ssex, String sphone) {
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
