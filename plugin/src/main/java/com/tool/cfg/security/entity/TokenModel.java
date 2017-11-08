package com.tool.cfg.security.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by XM on 2017/9/15.
 */
public class TokenModel implements Serializable{
    //上次的登陆ip
    private String ip;
    private int accountId;
    //账户名
    private String accountName;
    //用户id
    private String userId;
    //单位时间内登陆次数
    private int count;
    //随机生成的uuid
    private String token;
    //时间戳
    private long dateStamp;
    //其他参数
    private Map var1;

    public static class Builder implements  Serializable{
        //上次的登陆ip
        private String ip;
        private String accountId;
        //账户名
        private String accountName;
        //用户id
        private String userId;
        //单位时间内登陆次数
        private int count;
        //随机生成的uuid
        private String token;
        //时间戳
        private long dateStamp;
        //其他参数
        private Map var1;

        public Builder(String accountId,String accountName, String token) {
            this.accountId = accountId;
            this.accountName = accountName;
            this.token = token;
        }

        public Builder dateStamp(long va1) {
            dateStamp = va1;
            return this;
        }
        public Builder IP(String va1) {
            this.ip = va1;
            return this;
        }

        public Builder Others(Map va1) {
            this.var1 = va1;
            return this;
        }
        public TokenModel build() {
            return new TokenModel(this);
        }
    }

    public TokenModel(Builder builder) {
        this.accountName = builder.accountName;
        this.token = builder.token;
        this.dateStamp = builder.dateStamp;
        this.ip = builder.ip;
        this.var1 = builder.var1;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public long getDateStamp() {
        return dateStamp;
    }

    public String getIp() {
        return ip;
    }

    public Map getVar1() {
        return var1;
    }
}
