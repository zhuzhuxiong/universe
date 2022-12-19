package com.universe.spring.exception;

import lombok.Data;

/**
 * 异常类
 * @author lx
 */

@Data
public class BizException extends RuntimeException{

    protected int errCode;
    protected String errMessage;
    protected Object data;

    public BizException(int errCode, String errMessage, Throwable cause) {
        super(errMessage, cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BizException(String errMessage) {
        this(0, errMessage, null);
    }

    public BizException(int errCode, String errMessage) {
        this(errCode, errMessage, null);
    }

    public BizException(int errCode, String errMessage, Object data) {
        this.errCode = errCode;
        this.errMessage = errMessage;
        this.data = data;
    }

}
