package com.example.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class NacosDiscoveryConsumerSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryConsumerSampleApplication.class, args);
    }

}
