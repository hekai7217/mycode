package com.sxt.test;

/**
 * @author 黄药师
 * @date 2020-08-17 14:34
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *    事务 纯注解的配置 :
 *
 *   @Configuration 标记这个类是 ioc容器的配置类
 *  *
 *  *   下面 就是把application.xml的配置改成注解:
 *  *
 *  *   @ComponentScan   <context:component-scan base-package="com.sxt"></context:component-scan>
 *  *
 *  *   @PropertySource 导入 db.properties文件
 *  *
 *  *   @EnableTransactionManagement //等价于 <tx:annotation-driven transaction-manager="transactionManager"/>
 *  *
 *  *    需要把第三方 jar 提供的类型进行配置
 *  *       DataSource 连接池
 *  *       @Bean   把第三方的 java类型 创建对象 注入到ioc容器中
 *  *       public DataSource dataSource(){
 *  *           return dataSource
 *  *       }
 *  *      DataSourceTransactionManager 事务管理器
 *  *
 *  *      @Bean
 *  *      public DataSourceTransactionManager dataSource(){
 *  *  *           return dataSource
 *  *  *    }
 *  *
 *
 *       springboot 纯注解 更简洁
 */
public class TestTx02 {
}
