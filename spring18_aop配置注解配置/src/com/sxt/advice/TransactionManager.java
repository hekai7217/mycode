package com.sxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 黄药师
 * @date 2020-08-15 15:16
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  事务管理器( 增强类 通知 )
 */
@Component  // 组件创建添加到 ioc容器中
@Aspect    //切面类   ( 连接点 + 通知)
public class TransactionManager {


    // 配置一个切点
    //    <aop:pointcut id="pc" expression="execution(* com.sxt.service.impl.*.*(..))"/>
    //    和上面的xml的配置一个意思
    @Pointcut("execution(* com.sxt.service.impl.*.*(..))")
    public void pointcut(){}


    /**
     *    事务的开始     配置前置通知
     *    事务的提交     后置通知
     *    事务的回滚      异常通知
     *    资源释放        最终通知
     */

    // Before 这个方法是  前置通知  内部需要给一个切点   @Pointcut标记的方法
    // <aop:before method="begin" pointcut-ref="pc"></aop:before>
    //和上面的注解配置一样
    @Before("pointcut()")
    public void begin(){
        System.out.println("事务的开启...");
    }

    @After("pointcut()")
    public void commit(){
        System.out.println("事务的提交...");
    }

    @AfterThrowing("pointcut()")
    public void rollback(){
        System.out.println("事务的回滚...");
    }

    @After("pointcut()")
    public void close(){
        System.out.println("资源的释放 ...");
    }

    /**
     * ProceedingJoinPoint 连接
     * @param pjp
     */
    public void around(ProceedingJoinPoint pjp){

        //调用具体的方法
        try {
            begin(); // 开启事务
            pjp.proceed();
            commit(); // 提交事务
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            rollback();
        }finally {
            close();
        }
    }


}
