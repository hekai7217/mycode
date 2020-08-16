package com.sxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 黄药师
 * @date 2020-08-15 14:22
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *     通知类
 *         aop 方法的增强类型
 */
public class MyAdvice {

    /**
     *   aop中的通知(方法增强)

     前置通知    在方法当前前面进行增强的通知
     后置通知    在方法的后面进行增强的通知 (如果有异常不会执行)
     环绕通知    在方法的前面 进行增强的通知
     异常通知    有异常才会执行的通知
     最终通知     必须会执行的通知
     */
    public void before(){
        System.out.println("我是前置通知");
    }

    public void afterReturn(){
        System.out.println(" 后置通知 ");
    }

    /**
     *   有异常的时候 才会执行
     * @param t
     */
    public void throwEx(Throwable t){
        System.out.println("我是异常 ...通知");
    }

    public void afterFianl(){
        System.out.println("我是最终通知...");
    }

    /**
     *  环绕通知的配置
     *   ProceedingJoinPoint 传入一个参数进来 连接点
     */
    public void around(ProceedingJoinPoint pjp){

        // 调用  调用具体的方法insert
        System.out.println("我是前置操作");
        try {
            pjp.proceed();
            System.out.println("我是后置操作");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("我是异常操作");
        }finally {

        System.out.println("我是最终操作 ");
        }
    }
}
