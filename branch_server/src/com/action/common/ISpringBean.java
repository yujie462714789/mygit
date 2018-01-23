package com.action.common;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ISpringBean  implements ApplicationContextAware
{
    private static final String SPRINGPATH = "classpath:conf/spring/applicationContext.xml"; //spring配置文件路径
    
    private static ApplicationContext ctx;
   //载器目前有两种选择：ContextLoaderListener和ContextLoaderServle
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        ISpringBean.ctx = ctx;
    }
    public static ApplicationContext getCtx() {
        return ctx;
    }

    /**
     * 
    * Discription :主要用于本地化测试 
    * @param beanName
    * @return
    * Object
    * @throws     
     */
    public Object getLocalBean(String beanName) {
        // TODO Auto-generated method stub
        return new ClassPathXmlApplicationContext(SPRINGPATH).getBean(beanName);
    }

    public static Object getActionBean(String beanName,Class<T> className) {
        // TODO Auto-generated method stub
        return getCtx().getBean(beanName);
    }
}
