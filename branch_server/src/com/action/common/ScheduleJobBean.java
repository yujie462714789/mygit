package com.action.common;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.service.common.IScheduleTask;

public class ScheduleJobBean extends QuartzJobBean
{

    @Override
    protected void executeInternal(JobExecutionContext arg0)
        throws JobExecutionException
    {
        // TODO Auto-generated method stub
        try
        {
            String jobName = arg0.getJobDetail().getJobDataMap().getString("className");
            IScheduleTask task= (IScheduleTask)Class.forName(jobName).newInstance();
            System.out.println("ScheduleJobBean.executeInternal £º ¿ªÊ¼Ö´ÐÐ ¡¾jobName¡¿    £º"+jobName);
            task.run(arg0);
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
