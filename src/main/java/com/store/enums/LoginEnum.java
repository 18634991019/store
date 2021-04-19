package com.store.enums;

/**
 * 作者：MaWeiZe
 * 2021/4/16
 */
public enum  LoginEnum {

    PASSWORD_DIFFERENT(1,"两次密码输入不一致,请重新输入"),
    PASSWORD_ISNULL(2,"密码不可为空,请输入密码"),
    USER_INSERT_FAILURE(3,"操作失败,请重新操作"),
    USER_ISNOTNULL(4,"该手机号已经注册,请重试"),
    USER_LOGIN_NOT(5,"账号或密码错误,请重新登录"),
    USER_IDENTITY_NULL(6,"身份信息为空"),
    USER_EMAIL_ERROR(7,"邮箱验证失败，请重新输入");
    private long code;
    private String msg;

    LoginEnum(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public long getCode() {
        return code;
    }

    public LoginEnum setCode(long code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public LoginEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
