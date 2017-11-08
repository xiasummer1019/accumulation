package com.tool.cfg.service;

import com.tool.cfg.base.data.db.IDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 注入dao对象
 */
public class AbstractDao{
    @Autowired
    @Qualifier(value = "dao")
    protected IDaoUtil daoUtil;
    public IDaoUtil getDaoUtil() {
        return daoUtil;
    }
}
