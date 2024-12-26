package com.traffic.traffic;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String orderId) {
        // Simulate processing payment and send order to the payment queue
        rabbitTemplate.convertAndSend(RabbitMqConfiguration.GPS_DATA_EXCHANGE,RabbitMqConfiguration.ROUTING_KEY_GPS, orderId);
        System.out.println("Sent message: " + orderId);
    }

    public void sendMessageOld(String message) {
       // amqpTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, message);
      //  System.out.println("Sent message: " + message);
    }
}
