package com.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.common.domain.ScheduleTask;
import com.dao.ScheduleDao;
@Repository("ScheduleDao")
public class ScheduleDaoImpl extends GenericDaoImpl<ScheduleTask,Long>implements ScheduleDao
{
    
    public  ScheduleDaoImpl()
    {
        super(ScheduleTask.class);
    }
}

