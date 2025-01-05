package com.traffic.traffic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class MainController {



    @Autowired
    private MessageSender messageSender;


    @GetMapping("/send")
    public String sendMessage() {
        messageSender.sendMessage("GPS and Sensors data getting");
        return "Message Sent!";
    }

}
