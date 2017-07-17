package com.czy.common.constant;

/**
 * Created by jacky on 2017/7/17.
 */
public enum  MessageCode {

    INVALID_PARAM(1001,"参数无效"),
    METHOD_NOT_ALLOWED(1002,"请求方法错误"),
    LACK_PARAM(1004,"参数缺省"),


    GOODS_NOT_EXISTS(1005,"商品不存在"),


    SUCCESS(200,"成功"),
    SERVER_ERROR(500,"服务器内部错误");

    private  int msgCode;
    private String msg;

    MessageCode(int msgCode, String msg) {
        this.msgCode = msgCode;
        this.msg = msg;
    }

    public int msgCode(){
        return this.getMsgCode();
    }

    public String msg(){
        return this.getMsg();
    }

    public int getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
