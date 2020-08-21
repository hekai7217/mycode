package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-21 10:22
 * @desc 百战程序员 http://www.itbaizhan.com
 * 测试 条件查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp04 {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void query01() {

        // 条件查询
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        // eq  参数1 给的是表的字段   参2 值
//        queryWrapper.eq("sid",4);
//        queryWrapper.eq("sage",40);

        // queryWrapper 支持链式编程
        queryWrapper.eq("sid", 4)
                .eq("sage", 40);


        // 条件包装类 会自动完成  sql的条件 拼接
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE (sid = ? AND sage = ?)

        Student student = studentMapper.selectOne(queryWrapper);
        System.out.println("student = " + student);

    }

    @Test
    public void query02() {

        // 条件查询
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        // eq  参数1 给的是表的字段   参2 值
//        queryWrapper.eq("sid",4);
//        queryWrapper.eq("sage",40);

        // 模式 条件是and
//        queryWrapper.eq("sid",4)
//                .or()
//                .eq("sage",40);


        // 条件包装类 会自动完成  sql的条件 拼接
        //SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE (sid = ? OR sage = ?)

//        List<Student> students = studentMapper.selectList(queryWrapper);
//        System.out.println("students = " + students);

        // age > 20 小于 30

//        queryWrapper.gt("sage",20)
//                .lt("sage",30);

        // between and

        queryWrapper.between("sage", 20, 30);
        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println("students = " + students);

    }

    @Test
    public void query03() {

        // 条件查询
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        //模糊查询
        queryWrapper.like("s_name", "李");
        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println("students = " + students);
    }

    @Test
    public void update() {

        // update 的条件修改
        // stu 设置sql 的set
        Student stu = new Student();
        stu.setsName("黄药师");
        stu.setSphone("111");
        // queryWrapper 设置sql 的where
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sid", 7).
                eq("sage", 22);

        // 拼接的sql :
        //  UPDATE t_student SET s_name=?, sphone=? WHERE (sid = ? AND sage = ?)
        // stu 设置的值
        // queryWrapper where条件
        int update = studentMapper.update(stu, queryWrapper);
        System.out.println("update = " + update);
    }

    @Test
    public void delete() {
        // 条件删除
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        // 大于 50 删除
        queryWrapper.gt("sage",50);
        int delete = studentMapper.delete(queryWrapper);
        System.out.println("delete = " + delete);

    }

//    其他的方法
    @Test
    public void query04(){
        // 统计   selectCount
        // 条件删除
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();

        //年龄小于 30
        queryWrapper.lt("sage",30);
        int count = studentMapper.selectCount(queryWrapper);
        System.out.println("count = " + count);
        // 返回第一个字段的值
        QueryWrapper<Student> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lt("sage",40);
        List<Object> objects = studentMapper.selectObjs(queryWrapper2);

        System.out.println("objects = " + objects);
    }
}

