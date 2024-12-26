package com.traffic.traffic;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

  //  @RabbitListener(queues = "myFirstQueue")
  //  public void receiveMessage(String message) {
   //     System.out.println("Received message: " + message);
   // }
}
