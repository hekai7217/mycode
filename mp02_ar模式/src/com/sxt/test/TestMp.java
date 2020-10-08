package com.sxt.test;

import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-21 9:29
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  ar模式：
 *     通过对象操作  数据库的数据
 *     底层 还是通过 mapper操作数据库数据
 *  特点: 开发更简洁 提升效率
 *
 *  实现ar模式:
 *    1. 实体类 继承 Model 类型   重写pkVal方法
 *    2. StudentMapper 继承 BaseMapper
 *    3. 还是需要 ioc容器扫描 mapper 低层的实例化
 *
 */
public class TestMp {

    /**
     * 测试ar模式
     */
    @Test
    public void arInsert(){

        // 1 拿到 ioc容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // insert操作

        Student stu = new Student();
        stu.setsName("殷素素");
        stu.setSphone("111");
        stu.setSage(34);
        stu.setSsex("女");
        stu.setSid(15);

        // 插入
        // ar 模式 可以直接用对象操作数据
//        boolean insert = stu.insert();
//        System.out.println("insert = " + insert);
        // 先判断 id  15 数据是否存在 ,不存在 插入 存在 更新
        boolean b = stu.insertOrUpdate();
        System.out.println("b = " + b);
    }

    // ar模式的更新测试
    @Test
    public void arUpdate(){

        // 1 拿到 ioc容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // updateById 更新

        Student stu = new Student();
        stu.setsName("郭靖");
        stu.setSsex("男");
        stu.setSid(15);

        boolean b = stu.updateById();
        System.out.println("b = " + b);
    }

    /**
     * ar的删除 
     */
    @Test
    public void arDelete(){

        // 1 拿到 ioc容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // updateById 更新

        Student stu = new Student();
        stu.setSid(15);

        boolean b = stu.deleteById();
        System.out.println("b = " + b);

    }

    /**
     * ar的查询
     */
    @Test
    public void arQuery(){

        // 1 拿到 ioc容器
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // updateById 更新

        Student stu = new Student();
        stu.setSid(7);

        Student student = stu.selectById();
        System.out.println("student = " + student);
    }
}
