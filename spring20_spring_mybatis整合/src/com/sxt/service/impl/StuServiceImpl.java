package com.sxt.service.impl;

import com.sxt.bean.Stu;
import com.sxt.dao.StuMapper;
import com.sxt.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄药师
 * @date 2020-08-17 15:24
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    spring和mybatis进行整合 mapper 创建交个spring处理
 *
 *     通过spring 来创建sqlsessionFactory
 *
 *    有mybatis和spring的整合包 : 这里以后创建 sqlSession的对应的类型:
 *       SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory>,
 *
 *       bean的对象创建的几种 方式?
 *         1. 构造创建
 *         2. 静态工厂
 *         3. 工厂方法
 *         4. 继承 FactoryBean 创建对象 (好多第三方的整合框架都是实现 FactoryBean)
 *               getBean() 返回我们的对象 给注入到ioc中
 *
 *      创建sqlSessionFactroy:
 *         1. sqlSessionFactroyBuilder().build("mybatis-config.xml");
 *          需要: config的配置:
 *             1.数据库配置 :  <properties resource="db.properties"></properties>
 *               给spring管理
 *             2. 环境的配置(连接池的配置):   <environments default="development">
         *         <environment id="development">
         *             <transactionManager type="JDBC"/>
         *             <dataSource type="POOLED">
         *                 <property name="driver" value="${jdbc.driverClassName}"/>
         *                 <property name="url" value="${jdbc.url}"/>
         *                 <property name="username" value="${jdbc.username}"/>
         *                 <property name="password" value="${jdbc.password}"/>
         *             </dataSource>
         *         </environment>
         *     </environments>
 *                  交个spring 管理
 *            3. xml配置
 *          <mappers>
 *                  <resouce class="com/sxt/mapper/UserMapper.xml"/>
 *           </mappers>
         *
 *
 *
 */
@Service
public class StuServiceImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    @Override
    public List<Stu> findStuAll() {

        // 简单的获取mapper

        // sqlSessionFactory sesion   工厂
        // sqlSessionFactory.getSession()   通过工厂拿到session

        // session 拿到 mapper
        //调用方法


        return stuMapper.findStuAll();
    }

    @Override
    public Stu findStuById(Integer id) {

        return stuMapper.findStuById(id);
    }

    @Override
    public int deleteStu(Integer id) {
        return stuMapper.deleteStu(id);
    }
}
