package com.service.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware
{
    private static ApplicationContext ctx;
    
    public void setApplicationContext(ApplicationContext ctx)
        throws BeansException
    {
        SpringContextUtil.ctx = ctx;
    }
    
    public static ApplicationContext getCtx()
    {
        return ctx;
    }
    
}