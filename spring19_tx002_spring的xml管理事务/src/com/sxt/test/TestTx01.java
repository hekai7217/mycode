package com.sxt.test;

import com.sxt.service.AccountService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黄药师
 * @date 2020-08-17 9:45
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *     spring管理事务的操作:
 *       1. 导入包
 *            spring的核心包  4个
 *            spring的aop包   3个
 *                 aop包 aspect 包 织入包
 *            日志包  commons-loggin
 *            事务的包:
 *                spring-jdbc包
 *                spring-tx的事务包
 *            数据库的包:
 *               数据库连接池
 *               数据库驱动包
 *      2. 配置
 *          1. 引入 aop / tx事务的命令空间
 *
 *          2. 配置事务管理器
 *
 *             jdbc/mybatis
 *             <bean class="DataSoruceTransactionManager"></bean>
 *                  配置事务管理器
 *          <bean id="dataSourceTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
 *               注入 数据库连接
 *           <property name="dataSource" ref="dataSource"></property>
 *           </bean>
 *
 *          3. aop配置事务
 *
 *            <aop:config>
 *        切点的配置
 *         <aop:pointcut id="pc" expression="execution(* com.sxt.service.impl..*.*(..))"/>
 *              配置通知
 *          aop:advisor
 *          advice-ref 引入通知
 *          pointcut-ref 切点
 *          aop:advisor 切面的配置( 通知 + 切点 )
 *          aop:aspect  切面的配置( 通知 + 切点 )
 *
 *          通知有另外的一个写法:
 *           01  aop:advisor  为实现接口  Advice 进行配置 切面
 *               aop:aspect   没有是实现接口 用aspect 配置
 *           02   应用场景:
 *                事务的管理 用这个 aop:advisor
 *         <aop:advisor advice-ref="tx" pointcut-ref="pc"></aop:advisor>
 *     </aop:config>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTx01 {

    @Autowired
    private AccountService accountService;

    /**
     *
     *    加了 spring管理事务
     *       方法中如果出现了 异常  进行事务管理  数据库的数据安全

     */
    @Test
    public void trano1(){
        accountService.transfer("aa","bb",100);
    }

}
