package com.example.nacos.controller;

import com.example.nacos.service.FeignClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/12/25 14:32  修改内容:
 * </pre>
 */
@RestController
public class OpenFeignController {

    @Autowired
    private FeignClientService feignClientService;

    @GetMapping(value = {"/api/feign/call/{message}"})
    public String feignCall(@PathVariable String message){
        return feignClientService.call(message);
    }
}
