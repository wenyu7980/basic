package com.wenyu7980.basic.authorization.util;

import com.wenyu7980.basic.authorization.domain.RequestUser;

/**
 * 用户信息
 * @author wenyu
 * @date 2020-01-29 
 */
public class AuthorizationUtil {
    private static ThreadLocal<RequestUser> USERS = new InheritableThreadLocal<>();

    public static String getUserId() {
        return USERS.get().getUserId();
    }

    public static void set(RequestUser user) {
        USERS.set(user);
    }

    public static RequestUser get() {
        return USERS.get();
    }

    public static void remove() {
        USERS.remove();
    }

    public static boolean isPresent() {
        return USERS.get() != null;
    }
}
