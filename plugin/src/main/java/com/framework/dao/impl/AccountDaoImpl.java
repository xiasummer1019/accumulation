package com.framework.dao.impl;

import com.framework.dao.IAccountDao;
import com.tool.cfg.service.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by XM on 2017/9/14.
 */
@Repository
public class AccountDaoImpl extends AbstractDao implements IAccountDao {

    public boolean isExist(String name, String pwd) {
        String sql="select * from hpl_base_t_account where login_name = ? and login_password = ?";
        List list  = this.daoUtil.queryForList(sql,new Object[]{name,pwd});
        return list.size()!=0?true:false;
    }
}
