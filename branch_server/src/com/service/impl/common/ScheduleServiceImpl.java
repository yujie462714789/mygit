package com.service.impl.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.action.common.ISpringBean;
import com.action.common.ScheduleJobBean;
import com.common.domain.ScheduleTask;
import com.dao.ScheduleDao;
import com.service.common.MainExecutor;
import com.service.common.ScheduleService;
import com.service.common.SpringContextUtil;
import com.service.impl.webservice.JaxbXmlUtil;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService
{
    @Resource
    private ScheduleDao scheduleDao;
    @Resource
    private MainExecutor mainExecutor;
    @Resource
    private JaxbXmlUtil jaxbXmlUtil;
    public ScheduleServiceImpl()
    {
        System.out.println("ScheduleServiceImpl ���캯���ʼ��");
    }
    
    @Override
    public void run()
        throws Exception
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scheduler scheduler = (Scheduler)ISpringBean.getActionBean("scheduler", null);
        String hql = "select t from ScheduleTask t where t.runFlag =:flag";
        Map<String, Object> map = new HashMap<>();
        map.put("flag", "1");
        List<ScheduleTask> tasks = this.scheduleDao.findByMap(map, hql);
       // mainExecutor.printMessages(); 
        jaxbXmlUtil.test();
        if (!tasks.isEmpty())
        {
            for (ScheduleTask task : tasks)
            {
                JobDetail jobDetail = scheduler.getJobDetail(task.getTaskName(), Scheduler.DEFAULT_GROUP);
                if (jobDetail == null)
                {
                    JobDetail job = new JobDetail();
                    job.setName(task.getTaskName());
                    job.setJobClass(ScheduleJobBean.class);
                    job.getJobDataMap().put("className", task.getClassName());
                    scheduler.addJob(job, true);
                    CronTrigger cronTrigger =
                        new CronTrigger(job.getName(), Scheduler.DEFAULT_GROUP, job.getName(), Scheduler.DEFAULT_GROUP);
                    cronTrigger.setCronExpression(task.getCron());
                    scheduler.scheduleJob(cronTrigger);
                }
            }
        }
        
    }
    
    @Override
    public void stop()
        throws Exception
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void save(ScheduleTask task)
        throws Exception
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void delete(ScheduleTask task)
        throws Exception
    {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public List<ScheduleTask> findAll()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public ScheduleDao getScheduleDao()
    {
        return scheduleDao;
    }
    
    public void setScheduleDao(ScheduleDao scheduleDao)
    {
        this.scheduleDao = scheduleDao;
    }

    public MainExecutor getMainExecutor()
    {
        return mainExecutor;
    }

    public void setMainExecutor(MainExecutor mainExecutor)
    {
        this.mainExecutor = mainExecutor;
    }
    
}
