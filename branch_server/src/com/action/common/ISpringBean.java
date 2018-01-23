package com.action.common;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ISpringBean  implements ApplicationContextAware
{
    private static final String SPRINGPATH = "classpath:conf/spring/applicationContext.xml"; //spring�����ļ�·��
    
    private static ApplicationContext ctx;
   //����Ŀǰ������ѡ��ContextLoaderListener��ContextLoaderServle
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        ISpringBean.ctx = ctx;
    }
    public static ApplicationContext getCtx() {
        return ctx;
    }

    /**
     * 
    * Discription :��Ҫ���ڱ��ػ����� 
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
