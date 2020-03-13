package com.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectJ {

    @Pointcut("execution(* com.aop..*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("前置通知···");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕通知~~方法执行之前");
        //执行方法
        Object proceed = point.proceed(point.getArgs());

        System.out.println("环绕通知~~方法执行之后");
    }


}
