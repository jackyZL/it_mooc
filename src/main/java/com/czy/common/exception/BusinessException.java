package com.czy.common.exception;


import com.czy.common.constant.MessageCode;

/**
 * 自定义异常
 *
 * @author jacky
 */
public class BusinessException extends Exception {



    private static final long serialVersionUID = 6938844333768863665L;

    private String message;

    private MessageCode msgCode;

    public BusinessException(MessageCode msgCode, Object... args) {
        this.msgCode = msgCode;
        this.message = String.format(msgCode.msg(), args);
    }

    public String getMessage() {
        return this.message;
    }

    public MessageCode getMessageCode() {
        return this.msgCode;
    }
}
