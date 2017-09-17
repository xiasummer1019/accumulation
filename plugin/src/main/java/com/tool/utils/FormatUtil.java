package com.tool.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormatUtil {
	
	public String formatList2HtmlTable(List<?> list)
	{
		String result = null;
		
		if(list != null)
		{
			result = "";
			for(int i=0;i<list.size();i++)
			{
				Map map = (Map)list.get(i);
				Object[] keys = map.keySet().toArray();
				if(i==0)
				{
					result = result + "<thead><tr><th><input type='checkbox' id='title-checkbox' name='title-checkbox' /></th>\r";
					for(int h=0;h<keys.length;h++)
					{
						result = result + "<th>";
						result = result + keys[h].toString();
						result = result + "</th>";
					}
					result = result + "</tr></thead>";
				}
				
				result = result + "<tbody style='font-size:12px;'><tr><td><input type='checkbox' /></td>";
				for(int j=0;j<keys.length;j++)
				{
					result = result + "<td>";
					Object value = map.get(keys[j]);
					if(value != null && !value.toString().trim().equals(""))
					{
						result = result + value.toString().trim();
					}
					else
					{
						result = result + "-";
					}
					result = result + "</td>";
				}
				result = result + "</tr></tbody>";
			}
		}

		return result;
	}
	
	
	public Map formatResultSet(ResultSet rs) throws SQLException
	{
		Map<String, Object> hm = new HashMap<String, Object>();  
        ResultSetMetaData rsmd = rs.getMetaData();  
        int count = rsmd.getColumnCount();  
        for (int i = 1; i <= count; i++) {  
            String key = rsmd.getColumnLabel(i);  
            Object value = rs.getObject(i);
            hm.put(key, value);  
        }  
        return hm;
	}
	
}
