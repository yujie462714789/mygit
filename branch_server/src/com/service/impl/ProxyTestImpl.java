package com.service.impl;

import com.service.ProxyTest;

public class ProxyTestImpl implements ProxyTest
{
    
    @Override
    public void rent()
    {
        // TODO Auto-generated method stub
        System.out.println("I want to rent my house");
    }
    
    @Override
    public void hello(String str)
    {
        // TODO Auto-generated method stub
        System.out.println("hello: " + str);
    }
    
}
