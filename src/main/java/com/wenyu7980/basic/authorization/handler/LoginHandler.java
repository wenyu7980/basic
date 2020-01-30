package com.wenyu7980.basic.authorization.handler;

import com.wenyu7980.basic.authorization.domain.Login;
import com.wenyu7980.basic.authorization.domain.LoginResult;

/**
 * 登录
 * @author wenyu
 * @date 2020-01-28 
 */
public interface LoginHandler {
    /**
     * 登录
     * @param login
     * @return
     */
    LoginResult login(Login login);
}
