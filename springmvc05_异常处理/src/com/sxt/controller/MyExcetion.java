package com.sxt.controller;

/**
 * @author 黄药师
 * @date 2020-08-19 14:24
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class MyExcetion extends Exception {

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public MyExcetion(String msg) {
        this.msg = msg;
    }

    public MyExcetion(String message, String msg) {
        super(message);
        this.msg = msg;
    }

    public MyExcetion(String message, Throwable cause, String msg) {
        super(message, cause);
        this.msg = msg;
    }

    public MyExcetion(Throwable cause, String msg) {
        super(cause);
        this.msg = msg;
    }

    public MyExcetion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String msg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.msg = msg;
    }
}
