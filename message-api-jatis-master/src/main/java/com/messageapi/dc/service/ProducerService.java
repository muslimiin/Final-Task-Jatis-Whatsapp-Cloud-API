package com.messageapi.dc.service;

import com.messageapi.dc.controller.MessageApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jms.core.MessageCreator;
import javax.jms.Message;
import javax.jms.Session;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Component
public class ProducerService {

    Logger logger = LoggerFactory.getLogger(ProducerService.class);

    @Value("${spring.activemq.queue}")
    String queue;

    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(final String messageId, final Map<String, Object> payloadMessage) {
        try {
            jmsTemplate.send(queue, new MessageCreator() {

                public Message createMessage(Session session) throws JMSException {
                    MapMessage message = session.createMapMessage();
                    message.setObject("message_id", messageId);
                    message.setObject("payload", payloadMessage);
                    return message;
                }
            });
            logger.info("[Message] producer (send message) has successfuly executed");
        }catch (Exception e){
            logger.error("[Error] send message has failed because {} ",e.getMessage());
        }

    }
}
