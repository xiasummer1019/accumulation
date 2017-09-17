/**
 * 
 */
package com.tool.cfg.base.data.db;


import com.tool.cfg.base.data.Entity.PageData;

import java.util.List;
import java.util.Map;

/**
 * <p>IDaoUtil</p>
 * <p>描述:</p>
 */
public interface IDaoUtil {
	
	/**
	 * 
	 * <p>函数:queryForList</p>
	 * <p>描述:通过SQL语句查询结果集</p>
	 * <p></p>
	 * <p>参数:@param sql
	 * <p>参数:@param args</p>
	 * <p>参数:@return</p>
	 */
	  List<Map<String, Object>> queryForList(String sql, Object[] args);

	/**
	 *
	 * <p>函数:execute</p>
	 * <p>描述:执行SQL语句</p>
	 * <p></p>
	 * <p>参数:@param sql
	 * <p>参数:@param args</p>
	 */
	 void execute(String sql, Object[] args);

	/**
	 *
	 * <p>函数:call</p>
	 * <p>描述:执行存储过程</p>
	 * <p></p>
	 * <p>参数:@param procedureName  存储过程名</p>
	 * <p>参数:@param args  入参</p>
	 */
	 void call(String procedureName, Object[] args);
	/**
	 *
	 * <p>函数:callForList</p>
	 * <p>描述:执行有结果集返回的存储过程</p>
	 * <p></p>
	 * <p>参数:@param procedureName  存储过程名</p>
	 * <p>参数:@param args  入参</p>
	 * <p>参数:@return  结果集</p>
	 */
	 List<Map> callForList(String procedureName, Object[] args);
	//public int callForInt(Object[] args);

	 PageData callForPageList(String procedureName, Object[] args);

	 String callForString(String procedureName, Object[] args);
	
}
