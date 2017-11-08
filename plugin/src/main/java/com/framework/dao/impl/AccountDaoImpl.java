package com.framework.dao.impl;

import com.framework.dao.AccountDao;
import com.tool.cfg.service.AbstractDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * AbstractDao 获取dao对象
 * AccountDao 定义改模块下的方法
 */
@Repository
public class AccountDaoImpl extends AbstractDao implements AccountDao {

    public List<Map<String, Object>> isExist(String name) {
        String sql="SELECT ACCOUNT_ID,LOGIN_NAME,USER_ID,LOGIN_PASSWORD FROM COM_BASE_T_ACCOUNT WHERE LOGIN_NAME = ?";
        List<Map<String, Object>>  list  = daoUtil.queryForList(sql,new Object[]{});
        return list;
    }

    @Override
    public void text() {
        String sql="selectmsg";
        List<Map>  list  = daoUtil.callForList(sql,new Object[]{});
    }

    public <Integer>Map findOne(Integer id) {
        Map obj= new HashMap();
        String sql = "select distinct d.*\n" + "from hpl_base_t_role a\n"
                + "inner join hpl_base_t_account_role b  on a.role_id = b.role_id\n"
                + "inner join hpl_base_t_role_function c on a.role_id = c.role_id\n"
                + "inner join hpl_base_t_function d on c.function_id = d.function_id where account_id = ? and function_type in(1,2) order by d.function_id";
        List<Map<String, Object>> functions = this.getDaoUtil().queryForList(sql,new Object[] { id });
        obj.put("privilege", functions);
        sql = "select distinct d.*\n" + "from hpl_base_t_role a\n"
                + "inner join hpl_base_t_account_role b  on a.role_id = b.role_id\n"
                + "inner join hpl_base_t_role_function c on a.role_id = c.role_id\n"
                + "inner join hpl_base_t_function d on c.function_id = d.function_id where account_id = ? and function_type =3 order by d.function_id";
        List<Map<String, Object>> actions = this.getDaoUtil().queryForList(sql,new Object[] { id });
        obj.put("actions", actions);
        sql = "select distinct d.*\n" + "from hpl_base_t_role a\n"
                + "inner join hpl_base_t_account_role b  on a.role_id = b.role_id\n"
                + "inner join hpl_base_t_role_function c on a.role_id = c.role_id\n"
                + "inner join hpl_base_t_function d on c.function_id = d.function_id where account_id = ? and function_type =4 order by d.function_id";
        List<Map<String, Object>> innerJsp = this.getDaoUtil().queryForList(sql,new Object[] { id });
        obj.put("innerJsp", innerJsp);
        return obj;
    }

}
