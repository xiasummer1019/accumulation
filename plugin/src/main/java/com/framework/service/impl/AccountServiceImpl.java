package com.framework.service.impl;

import com.framework.dao.IAccountDao;
import com.framework.service.IAccountService;
import com.tool.cfg.exception.PromptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录实现
 * 2017-9-14 15:10:39
 */
@Service(value = "ccountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    IAccountDao IAccountDao;

    public boolean login(String name, String password) {
        if(!IAccountDao.isExist(name, password)) throw new PromptException("该用户不存在！");
        return true;
    }
}
