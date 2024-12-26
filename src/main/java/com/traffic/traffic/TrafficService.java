package com.traffic.traffic;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;

@Service
public class TrafficService {
    @Autowired
    private TrafficRepository trafficRepository;

    Traffic traffic;

    @Scheduled(fixedRate = 4000)
    public void generateRandomNumberWithDelay() {
        traffic = new Traffic();
        Random random = new Random();
        int road = random.nextInt(3) + 1;
        int vechicaltype = random.nextInt(2) + 1;
        int vechicalno = random.nextInt(1000000) + 1;
       traffic.setVechical(vechicalno);
       traffic.setRoad(road);
       traffic.setCategory(vechicaltype);
       trafficRepository.save(traffic);

    }

    @Scheduled(fixedRate = 20000)
    public void reduceVechical() {
        trafficRepository.deleteAll();
        System.out.println("Deleteing all");
    }

     public Integer getRoad(Integer road)
     {
         return trafficRepository.countByRoad(road);
     }

    public Integer getVechical(Integer vechical)
    {
        return trafficRepository.countByCategory(vechical);
    }



    public List<Traffic> getAllTraffic() {
        return trafficRepository.findAll();
    }

}
