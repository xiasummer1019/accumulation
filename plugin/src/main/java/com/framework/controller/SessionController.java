package com.framework.controller;

import com.framework.service.AccountService;
import com.tool.cfg.base.data.Entity.AjaxResponse;
import com.tool.cfg.base.data.Entity.Constants;
import com.tool.cfg.exception.PromptException;
import com.tool.cfg.security.DecryptParse;
import com.tool.cfg.security.entity.RSACoder;
import com.tool.utils.CookieUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by XM on 2017/9/27.
 */
@Controller
@RequestMapping("/")
public class SessionController {
    private Logger logger = LogManager.getLogger(SessionController.class);

    @Autowired
    AccountService accountService;

    //登录页
    @RequestMapping("/login")
    public String login() { return "login"; }

    //首页
    @RequestMapping("/main")
    public String index() {
        return "main";
    }

    @GetMapping("/rsa")
    @ResponseBody
    public AjaxResponse RSA(HttpSession httpSession){
        try {
            Map<String, Object> temp = RSACoder.initKey();
            httpSession.setAttribute("RSAPublicKey", RSACoder.getPublicKey(temp));
            httpSession.setAttribute("RSAPrivateKey", RSACoder.getPrivateKey(temp));
            return AjaxResponse.success("查询成功",RSACoder.getPublicKey(temp));
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PromptException("获取服务端公钥失败，请刷新后重试！");
        }

    }


    //登陆
    @PostMapping( "/session")
    @ResponseBody
    public AjaxResponse login(@RequestParam String name,
                              @RequestParam String password,
                              @RequestParam String publicKey,
                              HttpSession httpSession,
                              HttpServletResponse response
    ) {
        try {
            publicKey = publicKey.replace("\n", "\r\n");
            logger.debug("\n加密后：" + password + "\n长度：" + password.length());
            String RSAPublicKey = String.valueOf(httpSession.getAttribute("RSAPublicKey"));
            if (!publicKey.equals(RSAPublicKey)) {
                logger.info("公钥不匹配");
                throw new PromptException("服务端验证失败，请刷新页面重试！");
            }
            logger.debug("\n公钥：" + publicKey);
            String RSAPrivateKey = String.valueOf(httpSession.getAttribute("RSAPrivateKey"));
            logger.debug("\n私钥：" + RSAPrivateKey);
            String pwd = DecryptParse.getFromRSAWithJs(password,RSAPrivateKey);
            String token = accountService.login(name, pwd).get("TOKEN").toString();
            CookieUtils.addCookie(response, Constants.AUTHORIZATION, token, null);
            return AjaxResponse.success("登录成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new PromptException(e.getMessage());
        }
    }

    //注销
    @DeleteMapping( "/session")
    @ResponseBody
    public AjaxResponse logout(@RequestParam String name, @RequestParam String token) {
        //TODO 注销的业务逻辑
        // accountService.logout(token);
        return AjaxResponse.success("退出成功");
    }


    //获取权限
    @GetMapping( "/session")
    @ResponseBody
    public AjaxResponse auth(@RequestParam String token,
                             @RequestParam(value = "redirectUrl", required = false) String redirectUrl) {


        return AjaxResponse.success("登陆成功！", accountService.getAuth(token));
    }
}
