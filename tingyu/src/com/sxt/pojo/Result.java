package com.sxt.pojo;

/**
 * @author 黄药师
 * @date 2020-08-25 14:39
 * @desc 百战程序员 http://www.itbaizhan.com
 */
public class Result
{
    private String msg;

    private boolean success;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Result() {
    }

    public Result(boolean success,String msg) {
        this.msg = msg;
        this.success = success;
    }
}
