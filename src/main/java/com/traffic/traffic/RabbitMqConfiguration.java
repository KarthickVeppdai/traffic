package com.traffic.traffic;


import lombok.Getter;
import lombok.Setter;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class RabbitMqConfiguration {


    public static final String GPS_DATA_EXCHANGE = "gps-data-exchange";
    public static final String GPS_QUEUE = "gps-queue";
    public static final String ROUTING_KEY_GPS = "gps";

    @Bean
    public DirectExchange gpsDirectExchange() {
        return new DirectExchange(GPS_DATA_EXCHANGE);
    }

    @Bean
    public Queue gpsQueue() {
        return new Queue(GPS_QUEUE);
    }

    @Bean
    public Binding gpsBinding() {
        return BindingBuilder.bind(gpsQueue()).to(gpsDirectExchange()).with(ROUTING_KEY_GPS);
    }

}
