package com.tool.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by XM on 2017/9/26.
 */
public class RegexUtil {

    public static boolean isLogin(String str) {
        return match("/v[1-9]\\d*/account/session",str);
    }

    public static boolean isLegalName(String str) {
        return match("^[\\u4e00-\\u9fa5_a-zA-Z0-9.]+$",str);
    }

    public static boolean isLegalName(String str,int minLength,int maxLength) {
        return match("[\\u4e00-\\u9fa5_a-zA-Z0-9_\\]{"+minLength+","+maxLength+"}",str);
    }

    public static int getApiVersion(String str) {
        Pattern pattern = Pattern.compile("/v(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            return  Integer.valueOf(matcher.group(1));
        }
        return -1;
    }

    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

}
