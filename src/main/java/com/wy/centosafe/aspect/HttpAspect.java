package com.wy.centosafe.aspect;

import com.wy.centosafe.enums.ResultEnum;
import com.wy.centosafe.exceptions.AuthException;
import com.wy.centosafe.utils.ResultUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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


    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired

    //记录所有h ttp请求
    @Pointcut("execution(public * com.wy.centosafe.controller.*.*(..))")
    public void log(){}


    @Pointcut("execution(public * com.wy.centosafe.controller.PageController.*(..)))")
    public void check(){
    }

    @Pointcut("execution(public * com.wy.centosafe.controller.PageController.userManage(..)))")
    public void checkU(){}


    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        //url

        logger.info("url={}", httpServletRequest.getRequestURI());

        //method
        logger.info("method={}", httpServletRequest.getMethod());

        //ip
        logger.info("ip={}", httpServletRequest.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());
    }


//        @Around("check()")
//        public String doBefore(ProceedingJoinPoint pjo){
//            HttpSession session = httpServletRequest.getSession();
//            if(session.getAttribute("name") == null){
//                return "redirect:/forbidden";
//            }else {
//                return null;
//            }
//        }

    @Around("checkU()")
    public void doBefore(ProceedingJoinPoint pjo) throws Exception{

    }
}

