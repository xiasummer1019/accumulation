package com.framework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by XM on 2017/10/17.
 */
@Controller
@RequestMapping("/develop")
public class DevelopController {
    //登录页
    @RequestMapping("/authority")
    public String index() {
        return "develop/authority";
    }
}
