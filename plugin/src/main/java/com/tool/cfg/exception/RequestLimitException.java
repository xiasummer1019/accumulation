package com.tool.cfg.exception;

public class RequestLimitException extends Exception {

    private static final long serialVersionUID = 8213919486252835749L;

    public RequestLimitException() {
        super("HTTP请求超出设定的限制");
    }

    public RequestLimitException(String message) {
        super(message);
    }

}