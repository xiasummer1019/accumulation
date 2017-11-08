package com.framework.controller;

import com.tool.cfg.base.data.Entity.AjaxResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Api(value = "用户服务",description = "提供RESTful风格API的用户的增删改查服务")
@Controller
@RequestMapping("/user")
public class UserController {

private final static Logger logger = LoggerFactory.getLogger(UserController.class);


@ApiOperation(value = "新增", notes = "新增用户")
@RequestMapping(value = "/add/userVo", method = RequestMethod.GET)
@ResponseBody
public AjaxResponse add() {
    
    logger.info("add method start,the parameter is :");
    return AjaxResponse.success();
}

}