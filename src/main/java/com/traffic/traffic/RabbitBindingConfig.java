package com.traffic.traffic;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RabbitBindingConfig {

    private String queue;
    private String exchange;
    private String routingKey;
}
