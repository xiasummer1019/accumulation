package com.test.redis;

import com.alibaba.fastjson.JSON;
import com.tool.utils.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by XM on 2017/9/15.
 */
public class Login {
    public static void main(String[] args) {
        try {
            Map map = new HashMap<String,String>();
            map.put("name","test");
            map.put("password","123456");
            HttpUtil.sendPost("http://localhost:8080/mvn/v1/account/session", JSON.toJSONString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
