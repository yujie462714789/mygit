package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao  <T, PK extends Serializable> 
{
    /**
     * ����map��ѯ�б�map�д��key��valueֵ��Ҫ��ʵ���Ӧ
     * @param map
     * @param hql
     * @return
     */
    public List<T> findByMap(final Map<String,Object> map,final String hql);
    
}
