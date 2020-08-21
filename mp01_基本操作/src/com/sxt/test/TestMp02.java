package com.sxt.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sxt.bean.Student;
import com.sxt.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 黄药师
 * @date 2020-08-21 10:22
 * @desc 百战程序员 http://www.itbaizhan.com
 * 测试 crud
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp02 {

    @Autowired
    private StudentMapper studentMapper;

    /**
     *  添加
     *     insert 插入一个对象
     *     返回  一个相应的行数
     *
     *  @TableName("t_student") 可以 设置 对象和表的映射
     *  @TableId(type = IdType.AUTO)  可以设置 id的主键自增
     *  @TableField("s_name")  可以设置 对象的属性和 表的字段进行映射
     *
     *  添加的时候: 会对象 对象 进行判null
     *    如果你是null sql拼接的时候回 不会插入null的字段
     */
    @Test
    public void Insert(){

        // 添加方法
        Student stu = new Student();

        //如果没有 id  推荐是使用 数据库表的自增主键

//        stu.setSid(11);
//        stu.setSage(60);
        stu.setsName("天山童姥");
        stu.setSphone("1234");
        stu.setSsex("女");
        int insert = studentMapper.insert(stu);
        System.out.println("insert = " + insert);

    }
    /**
     *  修改的的方法:  通过id修改
     *    1. 一定要有id
     *    2. 如果对象的值为null 不会修改
     */
    @Test
    public void update(){

        Student stu = new Student();
        stu.setSid(5);
        stu.setSage(30);
        stu.setsName("阿朱");
        stu.setSphone("111");

        int i = studentMapper.updateById(stu);
        System.out.println("i = " + i);

//        studentMapper.update();
    }

    @Test
    public void query01(){

        // 通过id查询
//        Student student = studentMapper.selectById(1);
//        System.out.println("student = " + student);

        // 查询所有
        List<Student> students = studentMapper.selectList(null);
        System.out.println("students = " + students);

    }

    @Test
    public void query02(){

        //批量查询

        List<Integer> list =new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        // 把id为 3 的都查询出来
        // SELECT sid,s_name,sage,ssex,sphone FROM t_student WHERE sid IN ( ? , ? , ? )
//        List<Student> students = studentMapper.selectBatchIds(list);
//        System.out.println("students = " + students);

        // 通过字段集合查询  字段 封装到一个map中
        Map<String,Object> map = new HashMap<>();

        // map的key 是表的字段
        map.put("sage",20);
        map.put("ssex","女");
        List<Student> students = studentMapper.selectByMap(map);
        System.out.println("students = " + students);
    }

    @Test
    public void  query03(){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        // 查询指定的列
        queryWrapper.select("sage","s_name");
        List<Student> students = studentMapper.selectList(queryWrapper);
        System.out.println("students = " + students);
    }

    @Test
    public void delete01(){

        //通过id删除
//        int i = studentMapper.deleteById(13);
//        System.out.println(i);

        // 通过制定的列删除

        Map<String,Object> map = new HashMap<>();

        // map的key 是表的字段
        map.put("sage",20);
        map.put("ssex","女");
//        int i = studentMapper.deleteByMap(map);
//        System.out.println("i = " + i);
        
        // 批量删除 
        List<Integer> list =new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        int i = studentMapper.deleteBatchIds(list);
        System.out.println("i = " + i);

    }
}
