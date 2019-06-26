package com.muyu.zhibo.bean.liguiBean;

public class BaseBean{
    /**
     * success : false
     * msg : 请重新登录
     * code : 400
     */

    protected boolean success=true;
    protected String msg;
    protected int code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
