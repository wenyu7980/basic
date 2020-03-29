package com.wenyu7980.basic.authorization.handler;

/**
 *
 * @author wenyu
 * @date 2020-02-11 
 */
public interface LogoutHandler {
    /**
     * 退出
     * @param token
     */
    void logout(String token);
}
