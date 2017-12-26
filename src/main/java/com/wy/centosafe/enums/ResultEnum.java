package com.wy.centosafe.enums;

/**
 * author wy
 * date 17-12-21
 * time 上午10:39
 */
public enum ResultEnum {
    AUTH_ERROR(-1,"无权限"),
    FILENOTEXIST_ERROR(1003,"文件不存在！"),
    SUCCESS(0,"成功"),
    ERROR(1,"失败"),
    UNKOWN_ERROR(1000,"未知错误"),
    USERNOTEXIST_ERROR(1001,"用户不存在！"),
    USERPASSWORD_ERROR(1002,"密码错误！"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
