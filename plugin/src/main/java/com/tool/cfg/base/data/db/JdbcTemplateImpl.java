/**
 *
 */
package com.tool.cfg.base.data.db;

import com.tool.cfg.base.data.Entity.PageData;
import com.tool.utils.FormatUtil;
import oracle.jdbc.OracleTypes;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>JdbcTempletImpl</p>
 * <p>描述:</p>
 */
@SuppressWarnings("unchecked")
public class JdbcTemplateImpl implements IDaoUtil{

	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/* (non-Javadoc)
	 * @see Web.Application.Base.Data.DataBase.IDaoUtil#call(java.lang.Object[])
	 */
	public void call(final String procedureName,final Object[] args) {
		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");
		this.jdbcTemplate.execute(
				new CallableStatementCreator() {
					public CallableStatement createCallableStatement(Connection con) throws SQLException {
						String storedProc = "{call "+procedureName+"(";
						if(args != null)
						{
							for(int i=0;i<args.length;i++)
							{
								if( storedProc.endsWith("(") ) storedProc = storedProc + "?";
								else storedProc = storedProc + ",?";
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
						}

						return cs;
					}
				},new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
						cs.execute();
						//return cs.getString(2);// 获取输出参数的值
						return null;
					}
				}
		);
	}

	/* (non-Javadoc)
	 * @see Web.Application.Base.Data.DataBase.IDaoUtil#callForList(java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	public List<Map> callForList(final String procedureName,final Object[] args) {
		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");

		final FormatUtil util = new FormatUtil();
		List<Map> result = (List<Map>)this.jdbcTemplate.execute(
				new CallableStatementCreator() {
					public CallableStatement createCallableStatement(Connection con) throws SQLException {
						String storedProc = "{call "+procedureName+"(?";
						if(args != null)
						{
							for(int i=0;i<args.length;i++)
							{
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
							cs.registerOutParameter(args.length+1, OracleTypes.CURSOR);
						}
						else{cs.registerOutParameter(1, OracleTypes.CURSOR);}
						return cs;
					}
				},new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
						cs.execute();
						List<Map> resultsMap = new ArrayList();
						ResultSet rs = null;
						if(args != null)
						{
							rs = (ResultSet) cs.getObject(args.length+1);// 获取游标一行的值
						}
						else {rs = (ResultSet) cs.getObject(1);}
						while (rs.next()) {// 转换每行的返回值到Map中
							Map rowMap = util.formatResultSet(rs);
							resultsMap.add(rowMap);
						}
						rs.close();
						return resultsMap;
					}
				}
		);
		return result;
	}

	/* (non-Javadoc)
	 * @see Web.Application.Base.Data.DataBase.IDaoUtil#execute(java.lang.String, java.lang.Object[])
	 */
	public void execute(String sql, Object[] args) {
		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");

		this.jdbcTemplate.update(sql, args);
	}

	/* (non-Javadoc)
	 * @see Web.Application.Base.Data.DataBase.IDaoUtil#queryForList(java.lang.String, java.lang.Object[])
	 */
	public List<Map<String, Object>> queryForList(String sql, Object[] args) {

		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");

		return this.jdbcTemplate.queryForList(sql, args);
	}
	public PageData callForPageList(final String procedureName, final Object[] args) {
		// TODO Auto-generated method stub
		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");

		final FormatUtil util = new FormatUtil();
		PageData result = (PageData)this.jdbcTemplate.execute(
				new CallableStatementCreator() {
					public CallableStatement createCallableStatement(Connection con) throws SQLException {
						String storedProc = "{call "+procedureName+"(?,?";
						if(args != null)
						{
							for(int i=0;i<args.length;i++)
							{
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
							cs.registerOutParameter(args.length+1, OracleTypes.INTEGER);
							cs.registerOutParameter(args.length+2, OracleTypes.CURSOR);
						}
						else{
							cs.registerOutParameter(1, OracleTypes.INTEGER);
							cs.registerOutParameter(2, OracleTypes.CURSOR);
						}
						return cs;
					}
				},new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
						cs.execute();
						PageData pagedata=new PageData();
						ResultSet rs = null;
						if(args != null)
						{
							pagedata.RowCount=((Integer)cs.getObject(args.length+1));
							rs = (ResultSet) cs.getObject(args.length+2);// 获取游标一行的值
						}
						else {
							pagedata.RowCount = ((Integer)cs.getObject(1));
							rs = (ResultSet) cs.getObject(2);}
						while (rs.next()) {// 转换每行的返回值到Map中
							Map rowMap = util.formatResultSet(rs);
							pagedata.PageRow.add(rowMap);
						}
						rs.close();
						return pagedata;
					}
				}
		);
		return result;
	}
	public String callForString(final String procedureName,final Object[] args) {
		if(this.jdbcTemplate == null) throw new RuntimeException("JdbcTemplate is null");

		final FormatUtil util = new FormatUtil();
		String result = (String)this.jdbcTemplate.execute(
				new CallableStatementCreator() {
					public CallableStatement createCallableStatement(Connection con) throws SQLException {
						String storedProc = "{call "+procedureName+"(?";
						if(args != null)
						{
							for(int i=0;i<args.length;i++)
							{
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
							cs.registerOutParameter(args.length+1, OracleTypes.VARCHAR);
						}
						else{cs.registerOutParameter(1, OracleTypes.VARCHAR);}
						return cs;
					}
				},new CallableStatementCallback() {
					public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
						cs.execute();
						String resultsStr = null;
						if(args != null)
						{
							resultsStr = (String) cs.getObject(args.length+1);// 获取游标一行的值
						}
						else {resultsStr = (String) cs.getObject(1);}

						return resultsStr;
					}
				}
		);
		return result;
	}

}
