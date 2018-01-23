package com.common.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "t_schedule_task")
public class ScheduleTask
{
    private Long taskId;
    
    private String taskName;
    
    private String className;
    
    private String cron;
    
    private String triggerName;
    
    private String runFlag;
    
    private Date runDate;
    @Id
    @GeneratedValue(generator="task_id") //自动生成ID  
    @GenericGenerator(name="task_id",strategy="increment")//自增长
    @Column(name="task_id", length=36) 
    public Long getTaskId()
    {
        return taskId;
    }
    
    public void setTaskId(Long taskId)
    {
        this.taskId = taskId;
    }
    
    @Column(name="task_name", length=30) 
    public String getTaskName()
    {
        return taskName;
    }
    
    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }
    @Column(name="class_name", length=60) 
    public String getClassName()
    {
        return className;
    }
    
    public void setClassName(String className)
    {
        this.className = className;
    }
    @Column(name="cron", length=30) 
    public String getCron()
    {
        return cron;
    }
    
    public void setCron(String cron)
    {
        this.cron = cron;
    }
    @Column(name="trigger_name", length=60) 
    public String getTriggerName()
    {
        return triggerName;
    }
    
    public void setTriggerName(String triggerName)
    {
        this.triggerName = triggerName;
    }
    @Column(name="run_flag", length=2) 
    public String getRunFlag()
    {
        return runFlag;
    }
    
    public void setRunFlag(String runFlag)
    {
        this.runFlag = runFlag;
    }
    @Column(name="run_date", length=20) 
    public Date getRunDate()
    {
        return runDate;
    }
    
    public void setRunDate(Date runDate)
    {
        this.runDate = runDate;
    }
    
}
