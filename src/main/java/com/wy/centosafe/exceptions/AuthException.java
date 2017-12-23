package com.wy.centosafe.exceptions;

import com.wy.centosafe.enums.ResultEnum;

/**
 * author wy
 * date 17-12-22
 * time 下午5:32
 * 权限异常
 */
public class AuthException extends RuntimeException {
    private Integer code;
    private ResultEnum resultEnum;

    public AuthException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
        this.resultEnum = resultEnum;
    }

    public Integer getCode() {
        return code;
    }

    public ResultEnum getResultEnum() {
        return resultEnum;
    }
}
