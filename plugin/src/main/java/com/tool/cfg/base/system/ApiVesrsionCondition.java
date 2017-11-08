package com.tool.cfg.base.system;

import com.tool.utils.RegexUtil;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;

public class ApiVesrsionCondition implements RequestCondition<ApiVesrsionCondition> {


    private int apiVersion;

    public ApiVesrsionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }

    public ApiVesrsionCondition combine(ApiVesrsionCondition other) {
        // 采用最后定义优先原则，则方法上的定义覆盖类上面的定义
        return new ApiVesrsionCondition(other.getApiVersion());
    }

    public ApiVesrsionCondition getMatchingCondition(HttpServletRequest request) {
        Integer v = RegexUtil.getApiVersion(request.getRequestURI());
        if(v!=-1&&v >= this.apiVersion){
            return this;
        }
        return null;
    }

    public int compareTo(ApiVesrsionCondition other, HttpServletRequest request) {
        // 优先匹配最新的版本号
        return other.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }

}

