package edu.soft2.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class UserServiceAop {
    //1.设置切点
    @Pointcut("execution(* edu.soft2.service..*.*(..))")//设置切入点拦截范围
    public void pointB(){}

    //设置前置增强
    @Before("pointB()")
    public void beforeB(){
        System.out.println("UserServiceAop前置增强");
    }
    //设置后置增强
    @After("pointB()")
    public void afterB(){
        System.out.println("UserServiceAop后置增强");
    }
}
