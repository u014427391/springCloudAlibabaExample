package com.example.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <pre>
 *      RestTemplateController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 15:57  修改内容:
 * </pre>
 */
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/restEcho")
    public String restEcho(@RequestParam("str")String str){
        return restTemplate.getForObject("http://dubbo-provider-sample/api/service/echo?str="+str,String.class);
    }
}
