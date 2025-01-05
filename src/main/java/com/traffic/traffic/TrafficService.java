package com.traffic.traffic;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TrafficService {



    @Scheduled(fixedRate = 4000)
    public void generateRandomNumberWithDelay() {


    }

    @Scheduled(fixedRate = 20000)
    public void reduceVechical() {

    }

}
