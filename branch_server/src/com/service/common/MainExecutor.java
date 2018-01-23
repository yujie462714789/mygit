package com.service.common;

import javax.annotation.Resource;

import org.springframework.core.task.TaskExecutor;

import com.service.activeMQ.MqProducerService;

public class MainExecutor implements Runnable
{
 
    private TaskExecutor taskExecutor;
    @Resource
    private MessagePrinterTask messagePrinterTask;
    public MainExecutor(TaskExecutor taskExecutor)
    {
        this.taskExecutor = taskExecutor;
    }
    
    public void printMessages()
    {
        for (int i = 0; i < 1; i++)
        {
            taskExecutor.execute(messagePrinterTask);
        }
    }
    

    @Override
    public void run()
    {
        // TODO Auto-generated method stub

    }

    public MessagePrinterTask getMessagePrinterTask()
    {
        return messagePrinterTask;
    }

    public void setMessagePrinterTask(MessagePrinterTask messagePrinterTask)
    {
        this.messagePrinterTask = messagePrinterTask;
    }

 
}
