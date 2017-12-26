package com.wy.centosafe.exceptions;

import com.wy.centosafe.enums.ResultEnum;

/**
 * author wy
 * date 17-12-22
 * time 下午8:14
 */
public class LogException extends RuntimeException {
    private Integer code;
    private ResultEnum resultEnum;

    public LogException(ResultEnum resultEnum) {
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
