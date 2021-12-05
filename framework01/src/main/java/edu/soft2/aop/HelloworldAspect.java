package edu.soft2.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Component  //声明组件类
//@Aspect     //声明切面类
public class HelloworldAspect {
    //设置切面
    /**
     * 设置切点
     */
    @Pointcut("execution(* edu.soft2.service.impl.HelloworldService.sayHello())")
    //@Pointcut("execution(* edu.soft2.service..*.*(..))")
    public void myPointcut(){}
    /**
     * 前置增强
     */
    @Before("myPointcut()")
    public void beforeAdvice(){
        System.out.println("————前置通知(先执行这里)————");
    }

    /**
     * 后置增强
     */
    @After("myPointcut()")
    public void afterAdvice(){
        System.out.println("————后置通知(后执行这里)————");
    }

    /**
     * 环绕通知，要有ProceedingJoinPoint参数传入
     * @param jp
     */
    @Around("myPointcut()")
    public void around(ProceedingJoinPoint jp){
       // System.out.println("环绕通知");
    }

}
