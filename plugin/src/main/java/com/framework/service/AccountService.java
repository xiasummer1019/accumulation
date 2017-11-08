package com.framework.service;

import java.util.Map;

/**
 * 登录业务接口
 * service
 */
public interface AccountService {
    Map login(String name, String password) ;
    void logout(String name, String token);
    void register(Map  account);
    Map getAuth(String token);
}
