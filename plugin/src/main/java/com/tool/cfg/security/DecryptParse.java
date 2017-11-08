package com.tool.cfg.security;

import com.tool.cfg.security.entity.BCrypt;
import com.tool.cfg.security.entity.Base64;
import com.tool.cfg.security.entity.RSACoder;

/**
 * Created by XM on 2017/9/18.
 */
public class DecryptParse {
    // 解密
    public static String getFromBase64(String s) {
        return Base64.decryt(s);
    }

    public static boolean checkFromBCrypt(String password,String hashed){
        return BCrypt.checkpw(password, hashed);
    }

    public static String getFromRSAWithJs(String data,String privateKey) throws Exception {
        return  RSACoder.decryptByPrivateKey(data,privateKey);
    }
}
