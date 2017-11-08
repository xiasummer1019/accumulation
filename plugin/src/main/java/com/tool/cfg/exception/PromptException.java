package com.tool.cfg.exception;

/**
 * <p>PromptException</p>
 * <p>描述:自定义的提示性的异常</p>
 */
public class PromptException extends RuntimeException {

    private static final long serialVersionUID = -1931819107621905468L;

    public PromptException(String message)
	{
		super(message);
	}
	public PromptException()
	{
		super();
	}
}