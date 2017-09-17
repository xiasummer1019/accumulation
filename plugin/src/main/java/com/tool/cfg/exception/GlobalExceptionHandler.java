package com.tool.cfg.exception;

import com.tool.cfg.base.data.Entity.AjaxResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
   /* @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AjaxResponse errorHandler(Exception ex) {
        return AjaxResponse.warning(HttpStatus.OK.value(), ex.getMessage());
    }
*/
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex, WebRequest request) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", ex);
        return mav;
    }

    @ExceptionHandler(PromptException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AjaxResponse handlePromptException(HttpServletRequest request, Exception ex) {
        return AjaxResponse.warning(HttpStatus.OK.value(), ex.getMessage());
    }


}
