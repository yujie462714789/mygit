package com.service.impl;

import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.common.IScheduleTask;
import com.service.common.MainExecutor;

public class TestScheduleTask implements IScheduleTask
{
    
    @Override
    public void run(JobExecutionContext context)
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");     
        MainExecutor te = (MainExecutor)appContext.getBean("mainExecutor");  
        te.printMessages();  
        System.out.println("11111111111111111111111");  
    }
    
}
