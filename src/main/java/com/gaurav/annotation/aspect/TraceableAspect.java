package com.gaurav.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class TraceableAspect {

    @Around("@annotation(com.gaurav.annotation.Traceable)")
//    @Before()
//    @After()
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Input: \n "+joinPoint.getArgs()[0]);
        HttpServletRequest servletRequest = (HttpServletRequest) joinPoint.getArgs()[1];
        System.out.println(servletRequest.getRemoteAddr());
        Object result = joinPoint.proceed();
        System.out.println(result);
        return result;
    }
}
