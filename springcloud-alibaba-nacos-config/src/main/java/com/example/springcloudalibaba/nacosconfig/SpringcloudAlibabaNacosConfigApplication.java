package com.example.springcloudalibaba.nacosconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringcloudAlibabaNacosConfigApplication {

    @Value("${user.name}")
    private String userName;

    @PostConstruct
    public void init() {
       System.out.println(String.format("从Nacos配置中心获取数据,username:%s",userName));
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaNacosConfigApplication.class, args);
    }

}
