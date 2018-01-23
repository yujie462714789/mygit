package com.service.common;

import java.util.List;

import com.common.domain.ScheduleTask;

public interface ScheduleService
{
    public void run()
        throws Exception;
    
    void stop()
        throws Exception;
    
    void save(ScheduleTask task)
        throws Exception;
    
    void delete(ScheduleTask task)
        throws Exception;
    
    List<ScheduleTask> findAll();

    
}
