package com.action.common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented//��������javaDoc�ĵ�
@Target(ElementType.FIELD)
/*
ȡֵ(ElementType)�У�
1.CONSTRUCTOR:��������������
2.FIELD:����������
3.LOCAL_VARIABLE:���������ֲ�����
4.METHOD:������������
5.PACKAGE:����������
6.PARAMETER:������������
7.TYPE:���������ࡢ�ӿ�(����ע������) ��enum����
*/
@Retention(RetentionPolicy.RUNTIME)
/*
1.SOURCE:��Դ�ļ�����Ч����Դ�ļ�������
2.CLASS:��class�ļ�����Ч����class������
3.RUNTIME:������ʱ��Ч��������ʱ������
*/
public @interface MyAnnotation
{
    public String id() default "";
    
    public String name() default "";
}
