package com.sxt.jdk;

import com.sxt.service.UserService;
import com.sxt.service.impl.UserServiceImpl;
import com.sxt.utils.TrsactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 黄药师
 * @date 2020-08-15 10:35
 * @desc 百战程序员 http://www.itbaizhan.com
 *   创建动态代理的类型
 *     1. 把真实对象传入进来
 *     2. 引入通知类
 *     3. 创建动态代理
 *
 */
@Component
public class JdkProxyHandler {

    //  真实对象
    @Autowired
    private UserService userService;

    // 增强的 方法 对象引入进来 (通知类  动态代理的增强的方法类型)
    @Autowired
    private TrsactionManager tm;

    // 创建动态代理

    /**
     *    创建动态代理的方法
     *      创建动态代理的 类官方提供了:
     *        Proxy  提供了 静态方法 newProxyInstance()
     * @param cls   动态代理的真实对象
     * @param <T>
     * @return
     */
    public <T> T getJdkProxyObj(Class<T> cls){

        //创建动态代理

        /**
         * newProxyInstance 方法中 需要的操作
         *
         *  参数1 : 真实代理的的 类加载器   可以通过class的 getClassLoader 方法获取
         *  参数2:  获取 真实代理类的  接口参数列表 可以通过class的getInterfaces()
         */
        // 创建了动态代理对象
        Object o = Proxy.newProxyInstance(cls.getClassLoader(),
//                cls.getInterfaces(),
userService.getClass().getInterfaces(),
//               cls.getInterfaces(),
                new InvocationHandler() { // 代理类 具体的方法执行地方
                    /**
                     * @param proxy   代理类
                     * @param method   正式对象的方法
                     * @param args    args 方法的参数列表
                     * @return 把执行的方法结果返回
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 调用 真实对象的方法
                        //通过反射调用
                        // 可以在调用方法的时候 添加通知 (增强的方法)
                        Object result = null;
                        try {
                            tm.begin();

                            String name = method.getName();

                            // 可以在这个加判断 进行过滤 指定的方法

                            result = method.invoke(userService, args);
                            tm.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            tm.rollback();
                        } finally {
                            tm.close();
                        }
                        return result;
                    }
                });

        return (T) o;
    }

}
