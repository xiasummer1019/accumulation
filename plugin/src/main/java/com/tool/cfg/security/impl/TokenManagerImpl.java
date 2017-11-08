package com.tool.cfg.security.impl;


import com.tool.cfg.base.data.Entity.Constants;
import com.tool.cfg.base.data.cache.RedisHandler;
import com.tool.cfg.security.TokenManager;
import com.tool.cfg.security.entity.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * 通过Redis存储和验证token的实现类
 */
@Component("tokenManager")
public class TokenManagerImpl implements TokenManager {

    @Autowired
    @Qualifier("redisHandler")
    private RedisHandler<TokenModel> redis ;

    public TokenModel createToken(Map account) {
        String token ="TOKEN:"+ UUID.randomUUID().toString().replace("-", "");//使用uuid作为源token
        TokenModel model = new TokenModel.Builder(account.get("ACCOUNT_ID").toString(),account.get("LOGIN_NAME").toString(),token)
                .IP(account.get("IP").toString())
                .dateStamp(System.currentTimeMillis()).build();
        redis.setCacheObject("account:"+account.get("ACCOUNT_ID").toString(), token, Constants.Max_TIME_OUT);
        redis.setCacheObject(token, model,Constants.Max_TIME_OUT);
        return model;
    }

    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        //查看userid - token 是否存在
        String token = redis.getCacheObject(model.getUserId());
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //查看token - 对象是否存在
        if (!redis.hasKey(token)) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.keepExpire(model.getUserId(),Constants.Max_TIME_OUT);
        return true;
    }

    public boolean checkToken(String key) {
        return redis.hasKey(key)?true:false;
    }

    //切割字符串获取token
    public TokenModel getToken(String authentication) {
      /*  if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("||");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施*/
        return null;
    }

    public TokenModel getTokenByrCache(String userId) {
        return null;
    }

    public void deleteToken(String key) {
        String token = redis.getCacheObject(key);
        redis.deleteByKey(key);
        redis.deleteByKey(token);
    }
}
