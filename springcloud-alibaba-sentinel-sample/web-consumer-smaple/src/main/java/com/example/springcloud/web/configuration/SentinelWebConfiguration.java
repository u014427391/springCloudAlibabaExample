package com.example.springcloud.web.configuration;

import com.example.springcloud.web.fallback.BlockExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.PrintWriter;

/**
 * <pre>
 *      SentinelWebConfiguration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 15:01  修改内容:
 * </pre>
 */
@Configuration public class SentinelWebConfiguration {
    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHandler() {
        return ((request, response, e) -> {
            response.setStatus(429);
            PrintWriter pw = response.getWriter();
            pw.print(String.format("Oops , blocked by sentinel:%s", e.getClass().getSimpleName()));
            pw.flush();
            pw.close();
        });
    }
}
