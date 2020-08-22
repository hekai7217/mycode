package com.sxt.test;

import com.sxt.mapper.StudentMapper;
import com.sxt.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-22 18:55
 * @desc 百战程序员 http://www.itbaizhan.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMp02 {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void demo01(){

        List<Student> students = studentMapper.selectList(null);
        System.out.println("students = " + students);

    }

}
