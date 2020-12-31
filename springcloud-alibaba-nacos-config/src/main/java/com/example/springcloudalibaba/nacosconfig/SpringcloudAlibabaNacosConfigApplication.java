package com.example.springcloudalibaba.nacosconfig;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.example.springcloudalibaba.nacosconfig.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

@SpringBootApplication
@RefreshScope
@EnableConfigurationProperties(User.class)
@RestController
public class SpringcloudAlibabaNacosConfigApplication {

    @Value("${user.name}")
    private String userName;

    @Autowired
    private User user;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    @PostConstruct
    public void init() {
       System.out.println(String.format("从Nacos配置中心获取数据,username:%s",userName));
    }

    @GetMapping("/username")
    public String username() {
        return String.format("get user name : %s", userName);
    }

    @GetMapping("/user")
    public String user() {
        return String.format("获取用户信息：%s" , user);
    }


    @Bean
    public ApplicationRunner runner() {
        return args -> {
            String dataId = "springcloud-alibaba-nacos-config.properties";
            String group = "DEFAULT_GROUP";
            nacosConfigManager.getConfigService().addListener(dataId, group, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    System.out.println(String.format("[Listener] :%s" , configInfo));
                    System.out.println("[Before User] " + user);
                    Properties properties = new Properties();
                    try {
                        properties.load(new StringReader(configInfo));
                        String name = properties.getProperty("user.name");
                        user.setName(name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("[After User] " + user);
                }
            });
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAlibabaNacosConfigApplication.class, args);
    }

}
