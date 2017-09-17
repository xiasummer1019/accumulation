package com.tool.cfg.exception;

/**
 * 参数化错误
 */
public class ParamException extends RuntimeException {
    public ParamException(String message)
    {
        super(message);
    }
}
