package com.traffic.traffic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainController {



    @Autowired
    private MessageSender messageSender;


    @GetMapping("/send")
    public ResponseEntity<String> sendMessage() {
        messageSender.sendMessage("GPS and Sensors data getting");
        return ResponseEntity.ok("Response sent!");
    }

}
