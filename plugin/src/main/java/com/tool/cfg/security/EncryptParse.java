package com.tool.cfg.security;

import com.tool.cfg.security.entity.BCrypt;
import com.tool.cfg.security.entity.Base64;
import com.tool.cfg.security.entity.MD5;
import com.tool.cfg.security.entity.RSACoder;

/**
 * Created by XM on 2017/9/18.
 */
public class EncryptParse {
    // 加密
    public static String getBase64(String str) {
        return Base64.encryt(str);
    }

    public static String getFromMd5(String data){
        String _KEY = "rsa";
        return MD5.parseStrToMd5U16(MD5.parseStrToMd5U16(data+_KEY)+_KEY);
    }

    public static String getFromBCrypt(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(4));
    }

    public static byte[] getFromRSA(String data,String key) throws Exception {
       return RSACoder.encryptByPublicKey(data.getBytes("utf-8"),key) ;
    }
}
