package com.example.springcloud.web.fallback;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;

/**
 * RestTemplate异常工具类
 */
public class ExceptionUtil {

    static Logger logger = LoggerFactory.getLogger(ExceptionUtil.class);

    public static ClientHttpResponse handleException(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException exception) {
        logger.info("Oops: {}" , exception.getClass().getCanonicalName());
        return new SentinelClientHttpResponse(String.format("custom block info!Oops:%s", exception.getClass().getCanonicalName()));
    }

    public static SentinelClientHttpResponse fallback(HttpRequest request,
                                                      byte[] body, ClientHttpRequestExecution execution, BlockException ex) {
        logger.info("fallback:{} " , ex.getClass().getCanonicalName());
        return new SentinelClientHttpResponse(String.format("custom fallback info! fallback:%s", ex.getClass().getCanonicalName()));
    }
}