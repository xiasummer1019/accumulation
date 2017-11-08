package com.tool.cfg.aop;

import com.tool.cfg.annotation.Authorization;
import com.tool.cfg.base.data.Entity.Constants;
import com.tool.cfg.base.system.SystemConfig;
import com.tool.cfg.security.TokenManager;
import com.tool.cfg.security.entity.TokenModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by XM on 2017/9/19.
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    protected Logger log = LogManager.getLogger(AuthorityInterceptor.class);
    @Autowired
    protected SystemConfig systemConfig;
    @Autowired
    TokenManager manager;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //如果不是映射到方法直接通过
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) o;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String authorization = httpServletRequest.getHeader(Constants.AUTHORIZATION);
        //验证token
        TokenModel model = manager.getToken(authorization);
        if (manager.checkToken(model)) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            httpServletRequest.setAttribute(Constants.CURRENT_USER_ID, model.getUserId());
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Authorization.class) != null) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
