package com.framework.service.impl;

import com.framework.dao.AccountDao;
import com.framework.service.AccountService;
import com.tool.cfg.base.system.SystemConfig;
import com.tool.cfg.exception.ParamException;
import com.tool.cfg.exception.PromptException;
import com.tool.cfg.security.DecryptParse;
import com.tool.cfg.security.TokenManager;
import com.tool.cfg.security.entity.TokenModel;
import com.tool.utils.RegexUtil;
import com.tool.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录实现
 * 2017-9-14 15:10:39
 */
@Service(value = "acountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountDao AccountDao;
    @Autowired
    SystemConfig systemConfig;
    @Autowired
    TokenManager tokenManager;
    //登陆
    public Map login(String name, String password) {
        //判断参数
        if(StringUtil.isEmpty(name)||StringUtil.isEmpty(password))
            throw new ParamException("用户名或密码不能为空！");
        if(!RegexUtil.isLegalName(name))
            throw new ParamException("用户名非法，只能包含字母数字中文或者符号‘_’,'.'！");
        //todo 其他验证
        //验证账户信息
        List<Map> list =  AccountDao.isExist(name);
        if(list.size()!=1|| StringUtil.isEmpty(list.get(0).get("ACCOUNT_ID"))) throw new PromptException("该用户不存在！");
        Map account = list.get(0);
        if(!DecryptParse.checkFromBCrypt(password,account.get("LOGIN_PASSWORD").toString())) throw new PromptException("密码不正确！请确认！");

        //todo 查询是否已登录，已经登录用户剔除
        String account_id ="account#"+account.get("ACCOUNT_ID");
        if(tokenManager.checkToken(account_id)){
            tokenManager.deleteToken(account_id);
        }
        account.put("IP",systemConfig.getIpAddr());
        //创建token
        TokenModel model = tokenManager.createToken(account);

        //返回的map对象
        Map back = new HashMap();
        back.put("TOKEN",model.getToken());
        return back;
    }

    public void logout(String name, String token) {

    }

    public void register(Map account) {

    }

    public Map getAuth(String token) {
        AccountDao.text();
        return null;
    }
}
