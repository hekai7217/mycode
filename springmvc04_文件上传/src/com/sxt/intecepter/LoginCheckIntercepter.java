package com.sxt.intecepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 黄药师
 * @date 2020-08-19 10:44
 * @desc 百战程序员 http://www.itbaizhan.com
 *
 *   注释 测试拦截器
 *   01  实现接口  HandlerInterceptor
 *        拦截权限  preHandle
 *        释放资源  afterCompletion
 *
 *   02  拦截器 需要在 springmvc中进行 配置
 *
 *
 *
 */
public class LoginCheckIntercepter implements HandlerInterceptor {

    /**
     *  在 handler方法之前执行
     *      (处理请求之前进行执行  )
     *
     *      返回true    放行
     *      返回false   拦截   (和过滤器很像 )
     *
     * @param req
     * @param resp
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {

        System.out.println("LoginCheckIntercepter.preHandle");

        // 校验    用户是否登录
        // 从session 获取用户是否登录
        HttpSession session = req.getSession();

        String name = ((String) session.getAttribute("name"));
        // 如果存在 放行
        if(name != null){
            // 放行
            return true;
        }else{
            // 拦截
            // 操作 重定向到 login页面
            resp.sendRedirect(req.getContextPath() + "/view/login.jsp");
            return false;
        }
    }

    /**
     *  在 handler 方法之后执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        System.out.println("LoginCheckIntercepter.postHandle");
    }

    /**
     *  在试图渲染 后 执行的方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

        System.out.println("LoginCheckIntercepter.afterCompletion");
    }
}
