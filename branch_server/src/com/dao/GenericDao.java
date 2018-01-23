package com.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao  <T, PK extends Serializable> 
{
    /**
     * 根据map查询列表。map中存放key、value值需要和实体对应
     * @param map
     * @param hql
     * @return
     */
    public List<T> findByMap(final Map<String,Object> map,final String hql);
    
}
