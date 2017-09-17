package com.tool.cfg.service;

import com.tool.cfg.base.data.db.IDaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by XM on 2017/9/15.
 */
public class AbstractDao implements IDao {

    @Autowired
    @Qualifier(value = "dao")
    protected IDaoUtil daoUtil;

    public void setDaoUtil(IDaoUtil daoUtil) {
        this.daoUtil = daoUtil;
    }

    public IDaoUtil getDaoUtil() {
        return daoUtil;
    }
}
