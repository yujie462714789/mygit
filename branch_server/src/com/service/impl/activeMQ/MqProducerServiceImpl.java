package com.service.impl.activeMQ;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.service.activeMQ.MqProducerService;

@Service("mqProducerService")
public class MqProducerServiceImpl implements MqProducerService
{
    private static JmsTemplate jmsTemplate = null;
    @Autowired  
    @Qualifier("responseQueue")  
    private Destination responseDestination; 
    @Override
    public void sendMessage(Destination destination, final String message)
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("conf/spring/activeMQAdapter.xml");
        // 获取JmsTemplate对象
        jmsTemplate = (JmsTemplate)ctx.getBean("jmsTemplate");
        jmsTemplate.send(destination, new MessageCreator()
        {
            public Message createMessage(Session session)
                throws JMSException
            {
                System.out.println("开始往MQ写数据" + message);
                TextMessage textMessage = session.createTextMessage(message);
                textMessage.setJMSReplyTo(responseDestination);  
                return textMessage;  
            }
        });
    }
    
    public JmsTemplate getJmsTemplate()
    {
        return jmsTemplate;
    }
    
    public void setJmsTemplate(JmsTemplate jmsTemplate)
    {
        this.jmsTemplate = jmsTemplate;
    }
    
}
