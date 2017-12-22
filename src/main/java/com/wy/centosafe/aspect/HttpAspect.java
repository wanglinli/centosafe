package com.wy.centosafe.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * author wy
 * date 17-12-21
 * time 下午12:49
 */
@Aspect
@Component
public class HttpAspect {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Pointcut("execution(public * com.wy.centosafe.controller.PageController.*(..)))")
    public void check(){
    }


    @Around("check()")
    public String doBefore(ProceedingJoinPoint pjo){
        HttpSession session = httpServletRequest.getSession();
        if(session.getAttribute("name") == null){
            return "redirect:/forbidden";
        }else {
            return null;
        }
    }

}

