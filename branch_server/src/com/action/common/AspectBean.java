package com.action.common;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect  
//声明一个切面 
public class AspectBean
{
    
    @Pointcut("execution (* com.service.impl.common.ScheduleServiceImpl.run*(..))")// 切入点表达式  
    private void anyMethod() {  

    }// 声明一个切入点  
    @Before("anyMethod()")
  // @Before("anyMethod()&& args(userName)")定义前置通知 执行业务方法前执行 args(userName) 表示要执行的方式必须为一个参数并为Person类型.这样就给他再加了限制条件 
    public void validateBefore(JoinPoint jp) throws Throwable {  
  
        System.out.println("1............前置通知(validateBefore) \n");
        System.out.print("准备在" + jp.getTarget().getClass() + "对象上用");
        System.out.print(jp.getSignature().getName() + "方法进行对 '");
       // System.out.print(jp.getArgs()[0] + "'进行操作！\n\n");
       //  String jsonData = JSONArray.fromObject(jp.getArgs()[0]).toString();
      //用改变后的参数执行目标方法
       // Object returnValue = point.proceed(args);
    }
    @AfterReturning(pointcut="anyMethod()")//定义后置通知 执行完业务方法后执行 如果例外通知执行，那么它不会执行  
    public void doReturnCheck() {  
        System.out.println("4............执行最总通知 \n");   
    }  
      
    @After("anyMethod()")//
    public void doReleaseAction() {  
        System.out.println(" 3............执行后置通知 \n");   
    }  
      
    @AfterThrowing(pointcut="anyMethod()", throwing="ex")//定义例外通知  
    public void doExceptionAction(Exception ex) {  
        System.out.println("5............执行例外通知");   
    }  
       
    @Around("anyMethod()")//环绕通知 doBasicProfiling    pjp可以修改  用于权限  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        if(true){
        System.out.println("执行环绕通知");   
         result =pjp.proceed();  
        System.out.println("退出环绕通知");   
      
        }
        return result; 
    }  
  
}