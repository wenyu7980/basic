package com.wenyu7980.basic.config.response;

/**
 *
 * @author wenyu
 * @date 2020-03-01 
 */
public class ResponseBody {
    private int code = 200;
    private Object data;
    private String message;

    public ResponseBody(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public ResponseBody(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
