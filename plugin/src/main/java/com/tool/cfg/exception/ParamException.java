package com.tool.cfg.exception;

/**
 * 参数化错误
 */
public class ParamException extends RuntimeException {
    private static final long serialVersionUID = -7387441401458534727L;
    public ParamException() {
        super("参数非法！");
    }
    public ParamException(String message)
    {
        super(message);
    }
}
