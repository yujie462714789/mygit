package com.service.common;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.service.activeMQ.MqProducerService;
@Component
public class MessagePrinterTask implements Runnable
{
    public MessagePrinterTask()
    {
        
    }
    private String message;
    
    @Resource
    private MqProducerService mqProducerService;
    
    @Autowired
    @Qualifier("mqTopic")
    private Destination destination;
    
    public MessagePrinterTask(String message)
    {
        this.message = message;
    }
    
    public void run()
    {
        this.mqProducerService.sendMessage(destination,Thread.currentThread().getName()+"线程发送信息");
    }
    
    public MqProducerService getMqProducerService()
    {
        return mqProducerService;
    }
    
    public void setMqProducerService(MqProducerService mqProducerService)
    {
        this.mqProducerService = mqProducerService;
    }

    public Destination getDestination()
    {
        return destination;
    }

    public void setDestination(Destination destination)
    {
        this.destination = destination;
    }
    
}
