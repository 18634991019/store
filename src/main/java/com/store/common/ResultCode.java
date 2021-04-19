package com.store.common;

/**
 * 作者：MaWeiZe
 * 2021/4/16
 */
public enum  ResultCode {

    SUCCESS(0,"成功"),
    FAILURE(1,"失败");

    private long code;
    private String msg;

    ResultCode(long code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public ResultCode setCode(long code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultCode setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
