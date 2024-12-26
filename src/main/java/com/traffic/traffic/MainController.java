package com.traffic.traffic;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    private static final String EXCHANGE_NAME = "dynamicExchange";
    private static final String ROUTING_KEY = "dynamic.routing.key";

    @Autowired
    private MessageSender messageSender;

    @Autowired
    TrafficService trafficService;

    @GetMapping("/send")
    public String sendMessage() {
        messageSender.sendMessage("GPS and Sensors data getting");
        return "Message Sent!";
    }


    private Random random = new Random();

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        sendMessage();

        model.addAttribute("road1", trafficService.getRoad(1));
        model.addAttribute("road2", trafficService.getRoad(2));
        model.addAttribute("road3", trafficService.getRoad(3));


        model.addAttribute("v1", trafficService.getVechical(1));
        model.addAttribute("v2", trafficService.getVechical(2));
        return "dashboard.html";
    }

    @GetMapping("/getParams")
    public String getUpdatedParams(Model model) {
        model.addAttribute("param1", getRandomParam());
        model.addAttribute("param2", getRandomParam());
        return "fragments :: paramValues";
    }

    private int getRandomParam() {
        return random.nextInt(100); // Returns a random number between 0 and 100
    }


    public void sendMessage(String exchange, String routingKey, Object message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
    }




}
