package com.framework.controller;

import com.framework.service.AccountService;
import com.tool.cfg.annotation.Authorization;
import com.tool.cfg.base.data.Entity.AjaxResponse;
import com.tool.cfg.security.DecryptParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * 版本号V1
 * <p>
 * GET（SELECT）：从服务器取出资源（一项或多项）。
 * POST（CREATE）：在服务器新建一个资源。
 * PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
 * PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
 * DELETE（DELETE）：从服务器删除资源。
 * ?limit=10：指定返回记录的数量
 * ?offset=10：指定返回记录的开始位置。
 * ?page=2&per_page=100：指定第几页，以及每页的记录数。
 * ?sortby=name&order=asc：指定返回结果按照哪个属性排序，以及排序顺序。
 * ?animal_type_id=1：指定筛选条件
 */


@Controller
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    @RequestMapping("/index")
    public String index() {
        //返回一个index.jsp这个视图
        return "/login.jsp";
    }

    //新增账户
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @Authorization("")
    public AjaxResponse login(@RequestParam String name,
                              @RequestParam String password,
                              @RequestParam(value="redirectUrl", required = false)String redirectUrl) {
        return AjaxResponse.success("登陆成功！",accountService.login(name, DecryptParse.getFromBase64(password)));
    }




}
