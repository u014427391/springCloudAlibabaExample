package com.example.springcloud.web.controller;

import com.example.springcloud.web.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *      FeignController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 16:00  修改内容:
 * </pre>
 */
@RestController
public class FeignController {

    @Autowired
    private FeignService feignService;

    @GetMapping(value = "/feignEcho")
    public String echo(@RequestParam String str){
        return feignService.echo(str);
    }

}
