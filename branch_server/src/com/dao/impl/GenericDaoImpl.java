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
        
    }//该构造方法必须有 No default constructor found
    /**
     * 继承了HibernateDaoSupport类的类获取session时，已不可用SessionFactory.OpenSessioon的形式来获
     * 取Session继承了HibernateDaoSupport类的类获取session时，已不可用SessionFactory.OpenSessioon的形式来获 取Session
     */
    
    private SessionFactory sessionFacotry;
    
    /**
     * 注入对象 当@Resource没有显式提供名字的时候，如果根据默认名字找不到对应的Spring管理对象，注入机制会回滚至类型匹配（type-match）。如果刚好只有一个Spring管理对象符合该依赖的类型，那么它会被注入
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
                    query.setProperties(map);//map中的 参数类型    要和实体类 中的属性类型保持一致否则报错 java.lang.** can't to case to**
                }
                List<T> list = query.list();
                return list;
            }
        });
    }
}
