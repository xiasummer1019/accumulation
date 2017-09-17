package com.tool.cfg.service;

import com.tool.cfg.base.data.db.IDaoUtil;

/**
 * Created by XM on 2017/9/15.
 */
public interface IDao {

     void setDaoUtil(IDaoUtil daoUtil) ;

     IDaoUtil getDaoUtil() ;
}
