package com.wy.centosafe.handle;

import com.wy.centosafe.domain.Result;
import com.wy.centosafe.exceptions.AuthException;
import com.wy.centosafe.exceptions.LogException;
import com.wy.centosafe.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author wy
 * date 17-12-22
 * time 下午5:50
 */
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof AuthException){
            AuthException authException = (AuthException) e;
            return ResultUtil.error(authException.getCode(), authException.getMessage());
        }else if(e instanceof LogException){
            LogException logException = (LogException) e;
            return ResultUtil.error(logException.getCode(),logException.getMessage());
        } else {
            return ResultUtil.error(-1,"未知错误");
        }
    }
}
