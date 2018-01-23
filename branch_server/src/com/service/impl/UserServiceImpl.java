package com.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.action.common.PropertiesHelper;
import com.common.domain.User;
import com.dao.UserDao;
import com.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService
{
    private static Logger logger = Logger.getLogger(UserServiceImpl.class);
    
    @Resource
    public UserDao userdao;
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)//����Ҫ��������(ֻ��ѯ��)���� 
    //�����Լ��ϣ�@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)������������һ��ֻ�����񣬿������Ч�ʡ� 
    public User queryByMap(Map map)
    {
      String content=  PropertiesHelper.getInstance().read("conf/common/common.properties", "test"); 
      System.out.println("conf/common/common.properties.test   ="+content);
        List<User> list = new ArrayList<User>();
        /***
         * .���Ҫ���������������� = String �ַ�������

����������������2.���̲߳����ַ��������� �²����������� = StringBuilder �ַ�������

����������������3.���̲߳����ַ��������� �²����������� = StringBuffer �ַ�������
         */
        String hql ="select distinct u from User u ";
        if(map!=null&&map.size()>0){
            Iterator<String> it=map.keySet().iterator();
            while(it.hasNext()){
                String key=it.next();
                if(key.equals("account")){
                    hql+=(" where u.userAccount =:"+key);
                }
                if(key.equals("password")){
                    hql+=(" and u.password =:"+key);//�������пո�
                }
            }
        }
        list= userdao.findByMap(map, hql);
        if(list.isEmpty())
        {
            return null;
        }
        return list.get(0);
    }
    
    public UserDao getUserdao()
    {
        return userdao;
    }
    
    public void setUserdao(UserDao userdao)
    {
        this.userdao = userdao;
    }
    
}
