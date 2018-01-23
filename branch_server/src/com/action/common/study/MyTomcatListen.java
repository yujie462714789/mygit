package com.action.common.study;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyTomcatListen implements ServletContextListener
{
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0)
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void contextInitialized(ServletContextEvent arg0)
    {
        // TODO Auto-generated method stub
        Runtime runtime= Runtime.getRuntime();
        System.out.println("java 总内存      ："+runtime.totalMemory());
        System.out.println("java 剩余内存      ："+runtime.freeMemory());
        System.out.println("java 最大内存的字节数      ："+runtime.maxMemory());
    }
    
}
