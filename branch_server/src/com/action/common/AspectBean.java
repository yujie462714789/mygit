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
//����һ������ 
public class AspectBean
{
    
    @Pointcut("execution (* com.service.impl.common.ScheduleServiceImpl.run*(..))")// �������ʽ  
    private void anyMethod() {  

    }// ����һ�������  
    @Before("anyMethod()")
  // @Before("anyMethod()&& args(userName)")����ǰ��֪ͨ ִ��ҵ�񷽷�ǰִ�� args(userName) ��ʾҪִ�еķ�ʽ����Ϊһ��������ΪPerson����.�����͸����ټ����������� 
    public void validateBefore(JoinPoint jp) throws Throwable {  
  
        System.out.println("1............ǰ��֪ͨ(validateBefore) \n");
        System.out.print("׼����" + jp.getTarget().getClass() + "��������");
        System.out.print(jp.getSignature().getName() + "�������ж� '");
       // System.out.print(jp.getArgs()[0] + "'���в�����\n\n");
       //  String jsonData = JSONArray.fromObject(jp.getArgs()[0]).toString();
      //�øı��Ĳ���ִ��Ŀ�귽��
       // Object returnValue = point.proceed(args);
    }
    @AfterReturning(pointcut="anyMethod()")//�������֪ͨ ִ����ҵ�񷽷���ִ�� �������ִ֪ͨ�У���ô������ִ��  
    public void doReturnCheck() {  
        System.out.println("4............ִ������֪ͨ \n");   
    }  
      
    @After("anyMethod()")//
    public void doReleaseAction() {  
        System.out.println(" 3............ִ�к���֪ͨ \n");   
    }  
      
    @AfterThrowing(pointcut="anyMethod()", throwing="ex")//��������֪ͨ  
    public void doExceptionAction(Exception ex) {  
        System.out.println("5............ִ������֪ͨ");   
    }  
       
    @Around("anyMethod()")//����֪ͨ doBasicProfiling    pjp�����޸�  ����Ȩ��  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        if(true){
        System.out.println("ִ�л���֪ͨ");   
         result =pjp.proceed();  
        System.out.println("�˳�����֪ͨ");   
      
        }
        return result; 
    }  
  
}