package com.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.GenericDao;

@SuppressWarnings("unchecked")
@Repository("genericDao")
public class GenericDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK>
{
    private Class<T> type;
    private static Logger logger = Logger.getLogger(GenericDaoImpl.class);
    public GenericDaoImpl(Class<T> type)
    {
        logger.info("GenericDaoImpl(Class<T> type)  ------------"+type.getName());
        this.type = type;
    }
    
    public GenericDaoImpl(){
        
    }//�ù��췽�������� No default constructor found
    /**
     * �̳���HibernateDaoSupport������ȡsessionʱ���Ѳ�����SessionFactory.OpenSessioon����ʽ����
     * ȡSession�̳���HibernateDaoSupport������ȡsessionʱ���Ѳ�����SessionFactory.OpenSessioon����ʽ���� ȡSession
     */
    
    private SessionFactory sessionFacotry;
    
    /**
     * ע����� ��@Resourceû����ʽ�ṩ���ֵ�ʱ���������Ĭ�������Ҳ�����Ӧ��Spring�������ע����ƻ�ع�������ƥ�䣨type-match��������պ�ֻ��һ��Spring���������ϸ����������ͣ���ô���ᱻע��
     * 
     * @param sessionFacotry
     */
    @Resource
    public void setSessionFacotry(SessionFactory sessionFacotry)
    {
        super.setSessionFactory(sessionFacotry);
    }
    
    @Override
    public List<T> findByMap(final Map<String, Object> map, final String hql)
    {
        return (List<T>)getHibernateTemplate().execute(new HibernateCallback()
        {
            
            public Object doInHibernate(Session session)
                throws HibernateException, SQLException
            {
                Query query = session.createQuery(hql);
                if (map != null && map.size() > 0)
                {
                    query.setProperties(map);//map�е� ��������    Ҫ��ʵ���� �е��������ͱ���һ�·��򱨴� java.lang.** can't to case to**
                }
                List<T> list = query.list();
                return list;
            }
        });
    }
}
