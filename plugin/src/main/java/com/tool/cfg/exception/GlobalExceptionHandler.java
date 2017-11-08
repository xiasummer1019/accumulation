package com.tool.cfg.exception;

import com.tool.cfg.base.data.Entity.AjaxResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AjaxResponse errorHandler(Exception ex) {
        return AjaxResponse.error(ex.getMessage());
    }

    /**
     * 自定义异常处理类
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(PromptException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public AjaxResponse handlePromptException(HttpServletRequest request, Exception ex) {
        return AjaxResponse.warning(ex.getMessage());
    }


}
