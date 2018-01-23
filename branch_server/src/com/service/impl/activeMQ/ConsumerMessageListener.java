package com.service.impl.activeMQ;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener
{
    
    @Override
    public void onMessage(Message message)
    {
        TextMessage textMsg = (TextMessage)message;
        try
        {
            System.out.println("接收者受到消息：" + textMsg.getText());
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
}
