package com.tool.cfg.base.data.db;

import com.tool.cfg.base.data.Entity.PageData;
import com.tool.utils.FormatUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by XM on 2017/10/26.
 */
public class JdbcWithMySql implements IDaoUtil {

    @Override
    public void execute(String sql, Object[] args) {
        isLegal();
        this.jdbcTemplate.update(sql, args);
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object[] args) {
        isLegal();
        return this.jdbcTemplate.queryForList(sql, args);
    }


    @Override
    public void call(final String procedureName, final Object[] args) {
        isLegal();
        this.jdbcTemplate.execute(new CallableStatementCreator() {
              public CallableStatement createCallableStatement(Connection con) throws SQLException {
                  String proc = "{call " + procedureName + "(";
                  if (args != null && args.length != 0) {
                      proc += "?";
                      for (int i = 1; i < args.length; i++) {
                          proc += ",?";
                      }
                  }
                  proc += ")}";
                  CallableStatement cs = con.prepareCall(proc);
                  if (args != null) {
                      for (int i = 0; i < args.length; i++) {
                          cs.setObject(i + 1, args[i]);
                      }
                  }
                  return cs;
              }
          }, new CallableStatementCallback() {
              public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                  cs.execute();
                  return null;
              }
          }
        );
    }

    @Override
    public List<Map> callForList(final String procedureName, final Object[] args) {
        isLegal();
        final FormatUtil util = new FormatUtil();
        List<Map> result = (List<Map>)this.jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String storedProc = "{ call " + procedureName + "(";
                        if (args != null && args.length != 0) {
                            storedProc += "?";
                            for (int i = 1; i < args.length; i++) {
                                storedProc += ",?";
                            }
                        }
                        storedProc += ")}";
                        CallableStatement cs = con.prepareCall(storedProc);
                        if(args != null){
                            for(int i=0;i<args.length;i++){
                                cs.setObject(i+1, args[i]);
                            }
                        }
                        return cs;
                    }
                },new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        boolean exist = cs.execute();
                        List<Map> resultsMap = new ArrayList();
                        ResultSet rs = null;
                        if(exist){
                            rs = cs.getResultSet();
                            while (rs.next()) {// 转换每行的返回值到Map中
                                Map rowMap = util.formatResultSet(rs);
                                resultsMap.add(rowMap);
                            }
                            rs.close();
                        }
                        return resultsMap;
                    }
                }

        );
        return result;
    }

    @Override
    public PageData callForPageList(final String procedureName, final Object[] args) {
        isLegal();
        final FormatUtil util = new FormatUtil();
        List<Map> result = (List<Map>)this.jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String storedProc = "{call "+procedureName+"(?";
                        if(args != null){
                            for(int i=0;i<args.length;i++){
                                storedProc = storedProc + ",?";
                            }
                        }
                        storedProc = storedProc + ")}";
                        CallableStatement cs = con.prepareCall(storedProc);
                        if(args != null)
                        {
                            for(int i=0;i<args.length;i++)
                            {
                                cs.setObject(i+1, args[i]);
                            }
                            cs.registerOutParameter(args.length+1,Types.INTEGER);
                        }
                        else{cs.registerOutParameter(1, Types.INTEGER);}
                        return cs;
                    }
                },new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        boolean exist = cs.execute();
                        PageData pagedata=new PageData();
                        List<Map> resultsMap = new ArrayList();
                        ResultSet rs = null;
                        if(exist){
                            if(args != null){

                                pagedata.RowCount=((Integer)cs.getObject(args.length+1));
                            }
                            else {
                                pagedata.RowCount = ((Integer)cs.getObject(1));
                            }
                            rs = cs.getResultSet();
                            while (rs.next()) {// 转换每行的返回值到Map中
                                Map rowMap = util.formatResultSet(rs);
                                resultsMap.add(rowMap);
                            }
                            rs.close();
                        }
                        return pagedata;
                    }
                }
        );
        return null;
    }

    @Override
    public String callForString(final String procedureName, final Object[] args) {
        isLegal();
        this.jdbcTemplate.execute(new CallableStatementCreator() {
              public CallableStatement createCallableStatement(Connection con) throws SQLException {
                  String storedProc = "{call "+procedureName+"(?";
                  if(args != null){
                      for(int i=0;i<args.length;i++){
                          storedProc = storedProc + ",?";
                      }
                  }
                  storedProc = storedProc + ")}";
                  CallableStatement cs = con.prepareCall(storedProc);
                  if(args != null)
                  {
                      for(int i=0;i<args.length;i++)
                      {
                          cs.setObject(i+1, args[i]);
                      }
                      cs.registerOutParameter(args.length+1, Types.VARCHAR);
                  }
                  else{cs.registerOutParameter(1, Types.VARCHAR);}
                  return cs;
              }
          }, new CallableStatementCallback() {
              public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                  cs.execute();
                  return null;
              }
          }
        );
        return null;
    }

    private void isLegal() {
        if (this.jdbcTemplate == null) throw new RuntimeException("JdbcWithMySql is null");
    }

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
