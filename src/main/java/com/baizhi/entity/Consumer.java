package com.baizhi.entity;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Consumer {
    @JmsListener(destination = "springboot-queue")
    public void receiveQueue(TextMessage msg){
        try {
            String text = msg.getText();
            System.out.println("15"+text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
