package com.sxt.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 黄药师
 * @date 2020-08-15 15:16
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *  事务管理器( 增强类 通知 )
 */
public class TransactionManager {

    /**
     *    事务的开始     配置前置通知
     *    事务的提交     后置通知
     *    事务的回滚      异常通知
     *    资源释放        最终通知
     */

    public void begin(){
        System.out.println("事务的开启...");
    }

    public void commit(){
        System.out.println("事务的提交...");
    }

    public void rollback(){
        System.out.println("事务的回滚...");
    }

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
