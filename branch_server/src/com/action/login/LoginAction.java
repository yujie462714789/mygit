package com.action.login;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.action.BaseAction;
import com.action.common.MyAnnotation;
import com.action.common.NetworkUtil;
import com.common.domain.AnnotationTest;
import com.common.domain.User;
import com.service.UserService;
import com.service.common.ObserverService;
import com.service.impl.common.ObserveServiceImpl;

public class LoginAction extends BaseAction
{
    @Resource
    public UserService userService;
    @Resource
    public ObserverService observerService;
    public NetworkUtil netWorkUtil;
    public String login()
    {
        {
            //自定义注解获取用户信息测试
            Class clazz= AnnotationTest.class; 
            Field[] fields = clazz.getDeclaredFields();
            for(Field field :fields){
                if(field.isAnnotationPresent(MyAnnotation.class)){
                    MyAnnotation an=   field.getAnnotation(MyAnnotation.class);
                    String account = an.id();
                    String password = an.name();
                    System.out.println("test   annotation：                 "+account+password);
                }
            }
        }
 
        String account = this.getRequest().getParameter("account");
        String password = this.getRequest().getParameter("password");
        String ip="";
        try
        {
            ip = netWorkUtil.getIpAddress(this.getRequest());
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("登录用户的Ip是：                 "+ip);
        {
            //获取登录用户的账户信息：
            ObserveServiceImpl ob = new ObserveServiceImpl();
            ob.addRece(new AccountAction(ob));
            ob.Notify();
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put("account", account);
        map.put("password", password);
        User user = this.userService.queryByMap(map);
        if (user != null)
        {
            return "loginsuccess";
        }
        else
        {
            this.getSession().put("message", "<div style='color: red'>登陆失败，用户名或密码错误！</div>");
            return "loginfail";
        }
        
    }
    
    @Override
    public String add()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String save()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String edit()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String update()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String delete()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String list()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String detail()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public String search()
        throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public UserService getUserService()
    {
        return userService;
    }
    
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }
    
}
