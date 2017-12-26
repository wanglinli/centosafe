package com.wy.centosafe.exceptions;

import com.wy.centosafe.enums.ResultEnum;

/**
 * author wy
 * date 17-12-22
 * time 下午11:06
 */
public class MemberException extends RuntimeException {
    private Integer code;
    private ResultEnum resultEnum;

    public MemberException(ResultEnum resultEnum) {
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
