package com.sxt.service.impl;

import com.sxt.bean.Stu;
import com.sxt.service.StuService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-14 10:26
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class StuServiceImpl implements StuService {

    // 使用 spring 提供的jdbc模板
    private JdbcTemplate jdbcTemplate;

    // update

    // query方法

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Stu> findAll() {

        List<Stu> stus = jdbcTemplate.query("select * from t_stu", new RowMapper<Stu>() {

            //  mapRow 每一行的数据 可以进行映射
            // resultSet  查询的结果集
            //   resultSet 把数据从结果集中获取  封装到  Stu 中返回
            @Override
            public Stu mapRow(ResultSet resultSet, int i) throws SQLException {

                Stu stu = new Stu();

                stu.setName(resultSet.getString("name"));
                stu.setAge(resultSet.getInt("age"));

                return stu;
            }
        });

        return stus;
    }

    @Override
    public void insetStu(Stu s) {
        jdbcTemplate.update("insert into t_stu(id,name,age) values(default ,?,?) ",
                s.getName(),s.getAge());
    }

    @Override
    public void updateStu(Stu stu) {
        jdbcTemplate.update("update t_stu set name = ?,age = ? where id = ? ",
                stu.getName(),stu.getAge(),stu.getId());
    }

    @Override
    public void deleteStu(Integer id) {

        // 参数 1 sql
        // 参数 2 sql需要的数据
        jdbcTemplate.update("delete from t_stu where id = ? ",id);
    }
}
