package com.example.springcloud.web.configuration;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.example.springcloud.web.fallback.ExceptionUtil;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *      RestTemplateConfiguration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 15:51  修改内容:
 * </pre>
 */
@Configuration  public class RestTemplateConfiguration {

    @Bean
    @LoadBalanced
    @SentinelRestTemplate(blockHandler = "handleException", blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
