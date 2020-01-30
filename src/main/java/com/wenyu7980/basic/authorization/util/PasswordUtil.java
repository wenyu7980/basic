package com.wenyu7980.basic.authorization.util;

import org.springframework.util.DigestUtils;

/**
 *
 * @author wenyu
 * @date 2020-01-28 
 */
public class PasswordUtil {
    private PasswordUtil() {
    }

    /**
     * 加密
     * @param code
     * @return
     */
    public static String encode(String code) {
        return DigestUtils.md5DigestAsHex(code.getBytes());
    }
}
