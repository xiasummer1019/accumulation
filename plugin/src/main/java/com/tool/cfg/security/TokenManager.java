package com.tool.cfg.security;

import com.tool.cfg.security.entity.TokenModel;

import java.util.Map;

/**
 * 对token进行操作的接口
 * Created by XM on 2017/9/18.
 */
public interface TokenManager {
    /**
     * 创建一个token关联上指定用户
     * @param account 指定用户信息
     * @return 生成的token
     */
     TokenModel createToken(Map account);

    /**
     * 检查token是否有效
     * @param  model
     * @return 是否有效
     */
     boolean checkToken(TokenModel model);
    /**
     * 检查token是否有效
     * @param  userId
     * @return 是否有效
     */
    boolean checkToken(String userId);

    /**
     * 从字符串中解析token
     * @param authentication 加密后的字符串
     * @return
     */
     TokenModel getToken(String authentication);

    /**
     * 从缓存中获取token
     * @return
     */
    TokenModel getTokenByrCache(String userId);

    /**
     * 清除token
     * @param token 登录用户
     */
     void deleteToken(String token);

}
