package com.sxt.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * @author 黄药师
 * @date 2020-08-21 9:37
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   默认 对象的名称和表的名称一致
 *   解决 @TableName("t_student") 把对象和 数据库的表进行映射
 */
@TableName("t_student")
public class Student  extends Model<Student> {

    @TableId(type=IdType.AUTO)
    private Integer sid;

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

    // 重写 pkVal方法  返回时 主键
    @Override
    protected Serializable pkVal() {
        return this.sid;
    }
}
