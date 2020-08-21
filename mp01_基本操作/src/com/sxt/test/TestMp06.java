package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-21 14:40
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  mp的注解：
 *     注解 解决的是 bean和 数据库表的映射关系
 *     1.@TableName注解
         * 作用:表明实体类对应的数据库表
         * 使用:在类名上使用，值为对应的表的表名
 *
 *    2.@TableId
         * 作用:表明类中的某个属性为主键字段对应的属性
         * 使用:在为主键的属性上使用
 *
 *   3.@TableField
     * 作用:表明普通属性映射的表中的字段，值为字段名
     * 使用:在普通属性上使用
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp06 {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void query(){

        // SELECT sid,s_name,sage,ssex,sphone,info FROM t_student
        // bean对中有info 属性  数据库表中没有这个自动
        // mp  sql 自动拼接 (用对象的属性进行拼接 )

        // 解决      @TableField(exist =  false)  告诉mp 数据库中没有这个字段

        List<Student> students = studentMapper.selectList(null);
        System.out.println("students = " + students);
    }

    /**
     *  mp 获取 主键自增
     *   01 设置   @TableId(type = IdType.AUTO) 属性 这个
     *     返回的添加的对象中 自己有有返回的 自增的主键
     *
     */
    @Test
    public void key(){

        Student stu = new Student();
        stu.setsName("张无忌");
        stu.setSphone("111");
        stu.setSage(34);
        stu.setSsex("男");

        // 没有id
        System.out.println("stu = " + stu);
        int insert = studentMapper.insert(stu);
        // stu中  有返回的自增id
        System.out.println(stu);
    }

    /**
     * 测试 全局策略
     */
    @Test
    public void queryGlobalConfig(){

        List<Student> students = studentMapper.selectList(null);
        System.out.println("students = " + students);

    }
}