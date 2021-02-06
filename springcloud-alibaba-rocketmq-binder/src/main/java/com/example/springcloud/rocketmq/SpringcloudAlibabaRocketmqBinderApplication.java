package com.example.springcloud.rocketmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({SpringcloudAlibabaRocketmqBinderApplication.Source1.class, SpringcloudAlibabaRocketmqBinderApplication.Source2.class})
public class SpringcloudAlibabaRocketmqBinderApplication {

    Logger log = LoggerFactory.getLogger(SpringcloudAlibabaRocketmqBinderApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaRocketmqBinderApplication.class, args);
    }

    @Autowired
    private Source1 source1;

    @Bean
    public CommandLineRunner runner(){
        return (args -> source1.output().send(MessageBuilder.withPayload("paloadStr").setHeader("k1","v1").build()));
    }

    @StreamListener("source1")
    @SendTo("source2")
    public String receiveFromSource1(String msg) {
        if (log.isInfoEnabled()) {
            log.info("receive message from source1:{}", msg);
        }
        return msg.toUpperCase();
    }

    @StreamListener("source2")
    public void receiveFromSource2(String msg) {
        if (log.isInfoEnabled()) {
            log.info("receive message from source2:{}", msg);
        }
    }

    public interface Source1 {
        @Output("source1")
        MessageChannel output();
        @Input("source1")
        SubscribableChannel input();
    }

    public interface Source2 {
        @Output("source2")
        MessageChannel output();
        @Input("source2")
        SubscribableChannel input();
    }


}
