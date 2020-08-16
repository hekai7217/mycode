package com.sxt.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sxt.bean.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @author 黄药师
 * @date 2020-08-14 14:20
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   创建一个 spring的配置类 替代  applicationcontext.xml
 *
 *     @Configuration 告诉 ioc容器  使用这个 SpringConfig 替代  applicationContext.xml
 *
 *     @ComponentScan  这个注解是  xml中配置的包扫描
 *
 *
 *     // 数据库连接池
 *
 *     xml 可以直接在 文件中进行配置
 *
 *     config文件必须要用 dataSource的配置
 *      spring解决方案:
 *          @bean 注解
 *              该注解只能写在方法上，使用此方法创建一个对象，并且放入spring容器。
 *
 *       在从纯注解开发中使用 dataSource ?
 *
 *          1.导入 数据库连接池jar
 *          2. 添加配置文件 (数据库配置文件)
 *          3. 用注解 @Value() 读取配置文件
 *          4. 使用@bean注解 把DataSource 添加到 ioc容器中
 */
@Configuration  //替代xml
@ComponentScan("com.sxt")  // 包扫描
@PropertySource(value={"classpath:person.properties","classpath:db.properties"})
//    <context:property-placeholder location="classpath:person.properties"></context:property-placeholder>
public class SpringConfig {

    // 创建一个对象 使用@bean注解
    // 创建 一个  user对象 注入到 ioc容器中
    //   默认ico容器中的 name/id 是 方法的名称
    //   如果需要给指定的名称 可以可以使用  name属性 给指定的名称

    @Bean(name="user")
    public User u(){
        User user = new User();

        user.setName("乔峰");
        user.setAge("40");
        return user;
    }
    /**
     *  使用注解 读取 db.properties文件 复制给属性
     */
    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean(name = "dataSource",initMethod = "init",destroyMethod = "close")  // 创建对象 添加到ioc容器中
    public DataSource dataSource(){
        // 创建datasource
        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

}
