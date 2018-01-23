package com.service.impl.activeMQ;

public class MessageListenerAdapter
{
    public String receiveMessage(String message)
    {
        System.out.println("MessageListenerAdapter通过receiveMessage接收到一个纯文本消息，消息内容是：" + message);
        return "这是MessageListenerAdapter对象的receiveMessage方法的返回值";
    }
}
