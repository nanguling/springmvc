package com.mystudy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect//定义切面，表示aop编程
@Component
public class TestAOP {
    @Pointcut("execution(* com.mystudy.controller.*.*(..))")
    public void loginPointCut() {

    }

    //前置通知，传入 切点方法名()
    @Before("loginPointCut()")
    public void beforeRequest() {
        System.out.println("前置通知,请求映射方法开始执行");
    }

    //后置通知
    @After("loginPointCut()")
    public void afterRequest() {
        System.out.println("最终通知，请求映射方法执行完毕");
    }

    @AfterReturning("loginPointCut()")
    public void afterRequestReturn() {
        System.out.println("后置通知，请求映射方法返回结果");
    }

    @AfterThrowing("loginPointCut()")
    public void afterRequestThrow() {
        System.out.println("异常通知，请求映射方法抛出异常");
    }

    @Around("loginPointCut()")
    public Object arountReuqest(ProceedingJoinPoint joinPoint) {
        Object res = null;
        try {
            //方法前可以加入前置逻辑
            System.out.println("Around前执行");
            res = joinPoint.proceed();
            System.out.println("Around后执行");
        }catch (Throwable e) {
            System.out.println("Around捕获异常");
        }
        return res;
    }
}
