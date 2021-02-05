package com.example.springcloud.web.service;

import com.example.springcloud.web.configuration.FeignConfiguration;
import com.example.springcloud.web.configuration.SentinelWebConfiguration;
import com.example.springcloud.web.fallback.BlockExceptionHandler;
import com.example.springcloud.web.fallback.EchoServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <pre>
 *      FooService
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 16:02  修改内容:
 * </pre>
 */
@FeignClient(value = "dubbo-provider-sample", fallback = EchoServiceFallback.class ,configuration = FeignConfiguration.class)
@Service
public interface FeignService {

    @GetMapping(value = "/api/service/echo")
    String echo(@RequestParam(value = "str", required = true) String str);

}
