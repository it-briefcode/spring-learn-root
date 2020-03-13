package org.ioc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyApspect {



    @Pointcut(value = "execution(* org.ioc.annotation..*(..))")
    public void pointcut(){}

    @Before(value = "pointcut()")
    public void before(){
        System.out.println("方法之前执行了~~~");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after 执行了~~");
    }
    @AfterReturning("pointcut()")
    public void afterround(){
        System.out.println("afterround  ..... 执行了");
    }

    @AfterThrowing("pointcut()")
    public void afterthrown(){
        System.out.println("afterthrown .... 执行");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("环绕~之前");
        Object proceed = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("环绕之后~~~");
    }
}
