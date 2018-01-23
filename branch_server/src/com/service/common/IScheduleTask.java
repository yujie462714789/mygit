package com.service.common;

import org.quartz.JobExecutionContext;

public interface IScheduleTask
{
    public void run(JobExecutionContext context);
}
