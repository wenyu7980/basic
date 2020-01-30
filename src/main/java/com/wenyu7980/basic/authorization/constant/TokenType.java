package com.wenyu7980.basic.authorization.constant;

/**
 * token类型
 * @author wenyu
 * @date 2020-01-28 
 */
public enum TokenType {
    /** 头部参数token */
    HEADER,
    /** 查询参数token */
    QUERY,
    /** 头部和查询都可以 */
    ALL;

}
