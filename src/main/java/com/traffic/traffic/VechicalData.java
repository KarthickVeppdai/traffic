package com.traffic.traffic;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class VechicalData {

    @Scheduled(fixedRate = 5000)
    public void runTask() {
        System.out.println("Task is running every 2 seconds");
    }

}
