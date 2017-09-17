package com.tool.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static String replaceSlash(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\\\|/");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }



    /**
     * 截取自定义长度     *
     * @param value
     * @param maxLength
     * @return
     */
    public static String daGetLimitedLengthStr(String value, int maxLength) {
        if (value == null)
            return null;
        if (maxLength > 0 && value.length() > maxLength)
            return value.substring(0, maxLength);
        return value;
    }

    /**
     * 判断String长度    (判断是否为空) *
     * @param value
     * @param minLength
     * @param maxLength
     * @return boolean
     */
    public static boolean isOverLengthAndEmpty(Object value,int minLength, int maxLength) {
        if(isEmpty(value)) return false;
        if (minLength >= 0 && String.valueOf(value).length() >=minLength && String.valueOf(value).length()<=maxLength)
            return true;
        return false;
    }
    /**
     * 判断String长度   *
     * @param value
     * @param minLength
     * @param maxLength
     * @return boolean
     */
    public static boolean isOverLength(Object value,int minLength, int maxLength) {
        if (minLength >= 0 && String.valueOf(value).length() >=minLength && String.valueOf(value).length()<=maxLength)
            return true;
        return false;
    }
    /**
     * 判断是否为空    *
     * @param obj
     * @return
     */
    public static Boolean isEmpty(Object obj) {
    	if(null==obj){
    		return true;
    	}
    	return StringUtils.isEmpty(String.valueOf(obj).trim())?true:false;
    }
    /**
     * 转换数字（必须确认是否能转换！提供为空检测）
     * @param obj
     * @return
     */
    public static int parseToInt(Object obj) {
    	if(null==obj||"".equals(obj)){
    		return 0;
    	}
    	return Integer.valueOf(String.valueOf(obj));
    }
    

    public static String replaceByBlank(String str) {
        if (null == str) {
            return str;
        }
        return str.replaceAll("\\s", "");
    }


    public static String removeReturnLine(String s) {
        if (s == null)
            return null;
        String rtnChars = "\n";
        if (s.contains("\r\n")) {
            rtnChars = "\r\n";
        }
        String[] ss = s.split(rtnChars);
        String rtnStr = "";
        for (String str : ss) {
            rtnStr += str + " ";
        }
        return rtnStr.trim();
    }

    /**
     * Return fixed length string, if value.len < len, use c as prefix
     *
     * @param value
     * @param len
     * @param c
     * @return
     */
    public static String getFixLengthStr(String value, int len, char c) {
        if (value == null)
            value = "";
        if (value.length() > len)
            return daGetLimitedLengthStr(value, len);
        String s = "";
        for (int i = 0; i < len - value.length(); i++)
            s += c;
        s += value;
        return s;
    }

    /**
     * 判断字符串是否为空
     * null或空值返回 null
     * 非空值返回原值
     *
     * @param str
     * @return
     */
    public static String emptyStringToNull(String str) {
        if (null != str) {
            if ("".equals(str.trim())) {
                return null;
            }
        }
        return str;
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符
     *
     * @param str
     * @return
     */
    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
            dest = replaceSlash(dest);
        }
        return dest;
    }

    public static String formatMoney(Double money) {
        if (null == money) {
            money = 0.0;
        }
        return String.format("%3.2f", money);
    }

    public static String formatMoney(Double money, int floatNbr) {
        if (null == money) {
            money = 0.0;
        }
        return String.format("%3." + floatNbr + "f", money);
    }

    public static Integer doubleToInt(Double dval) {
        if (dval == null)
            return 0;
        return dval.intValue();
    }

    public static String noMoreThan(String str, int length) {
        if (str == null) return str;

        if (str.length() > length) {
            return str.substring(0, length);
        }

        return str;
    }
}
