package com.example.springcloud.web.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.api.smapleapi.service.FooService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *      DemoController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 10:15  修改内容:
 * </pre>
 */
@RestController
@RequestMapping(value = "/api/demo")
public class DemoController {

    @DubboReference
    private FooService fooService;

    @GetMapping(value = "/echo")
    @SentinelResource(value = "DemoService#echo" , defaultFallback = "sentinelFallback")
    public String echo(@RequestParam(value = "str", required = true) String str, @RequestParam(value = "slow",defaultValue = "false", required = false)Boolean slow) {
        return fooService.echo(str , slow);
    }

    public String sentinelFallback(Throwable t){
        if (BlockException.isBlockException(t)) {
            return String.format("Block by sentinel:%s", t.getClass().getSimpleName());
        }
        return String.format("snetinal fallback method , Oops failed : %s", t.getClass().getCanonicalName());
    }

}
