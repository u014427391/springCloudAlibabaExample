package com.example.springcloud.sample.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.springcloud.sample.service.EchoServiceImpl;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *      DemoController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 16:27  修改内容:
 * </pre>
 */
@RequestMapping(value = "/api/service")
@RestController  public class DemoController {

    @Autowired
    EchoServiceImpl echoService;

    @GetMapping(value = "/echo")
    @SentinelResource(value = "service" )
    public String echo(@RequestParam(value = "str", required = true) String str) {
        return echoService.echo(str);
    }


}
