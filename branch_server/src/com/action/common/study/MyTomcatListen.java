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
        System.out.println("java ���ڴ�      ��"+runtime.totalMemory());
        System.out.println("java ʣ���ڴ�      ��"+runtime.freeMemory());
        System.out.println("java ����ڴ���ֽ���      ��"+runtime.maxMemory());
    }
    
}
