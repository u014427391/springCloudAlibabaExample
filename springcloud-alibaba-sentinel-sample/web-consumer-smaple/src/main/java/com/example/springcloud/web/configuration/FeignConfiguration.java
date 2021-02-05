package com.example.springcloud.web.configuration;

import com.example.springcloud.web.fallback.BlockExceptionHandler;
import com.example.springcloud.web.fallback.EchoServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *      FeignConfiguration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 16:11  修改内容:
 * </pre>
 */
@Configuration public class FeignConfiguration {

    @Bean
    public EchoServiceFallback echoServiceFallback(){
        return new EchoServiceFallback();
    }
}
