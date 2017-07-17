package com.czy.common.core;

/**
 * 基本返回体
 */
public class CommonResponse {

    /**
     * 返回码，详见MessageCode.java
     */
    private int code;

    /**
     * 业务内容
     */
    private Object data;

    /**
     * 错误提示
     */
    private String msg;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CommonResponse() {
    }

    public CommonResponse(int code, Object data, String msg) {
        super();
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

}
