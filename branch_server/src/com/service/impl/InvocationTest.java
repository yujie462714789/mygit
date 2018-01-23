package com.service.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.service.ProxyTest;

public class InvocationTest implements InvocationHandler
{
    private Object target;
    
    public InvocationTest(Object target)
    {
        super();
        this.target = target;
    }
    
    @Override
    public Object invoke(Object o, Method method, Object[] args)
        throws Throwable
    {
        // TODO Auto-generated method stub
        System.out.println("Method:" + method);
        // 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        return method.invoke(target, args);
    }
    
    public static void main(String[] args)
    {
        ProxyTest test = new ProxyTestImpl();
        
        // 我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new InvocationTest(test);
        ProxyTest proxy =
            (ProxyTest)Proxy.newProxyInstance(test.getClass().getClassLoader(),
                test.getClass().getInterfaces(),
                handler);
        System.out.println(proxy.getClass().getName());
        proxy.rent();
        proxy.hello("world");
    }
}
