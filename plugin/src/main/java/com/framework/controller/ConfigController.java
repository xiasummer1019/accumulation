package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XM on 2017/10/17.
 */
@Controller
@RequestMapping("/config")
public class ConfigController {
    //登录页
    @RequestMapping("/pageEdit")
    public String page() {
        return "config/pageEdit";
    }

    //登录页
    @RequestMapping("/home")
    public String index() {
        return "config/indexEdit";
    }
}
