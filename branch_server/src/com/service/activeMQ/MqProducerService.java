package com.service.activeMQ;

import javax.jms.Destination;

public interface MqProducerService
{
    public void sendMessage(Destination destination, final String message);
}
