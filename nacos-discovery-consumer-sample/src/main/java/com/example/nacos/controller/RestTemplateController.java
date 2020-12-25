package com.example.nacos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
 *    修改后版本:     修改人：  修改日期: 2020/12/25 11:44  修改内容:
 * </pre>
 */
@RestController
public class RestTemplateController {

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = {"/api/call/{message}"})
    public String call(@PathVariable String message){
        return restTemplate.getForObject("http://springcloud-alibaba-nacos-discovery/api/test/"+message,String.class);
    }


}
