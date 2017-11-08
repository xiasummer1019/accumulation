package com.tool.cfg.base.data.Entity;

public class Constants {

    /**
     * 存储当前登录账户id的字段名
     */
    public static final String CURRENT_ACCOUNT_ID = "CURRENT_ACCOUNT_ID";

    /**
     * 存储当前登录用户id的字段名
     */
    public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

    /**
     * 存放Authorization的header字段
     */
    public static final String AUTHORIZATION = "TOKEN_AUTHORIZATION";
    /**
     * token有效期30分钟
     */
    public static final long Max_TIME_OUT = 60 * 30;
    /**
     * cookie的有效期默认为30天
     */

    public final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 30;
}
