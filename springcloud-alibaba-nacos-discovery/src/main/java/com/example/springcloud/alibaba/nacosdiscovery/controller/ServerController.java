package com.example.springcloud.alibaba.nacosdiscovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *      ServerController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/12/25 10:49  修改内容:
 * </pre>
 */
@RestController
public class ServerController {

    @GetMapping("/api/test/{message}")
    public String echo(@PathVariable String message) {
        return String.format("echo message:%s", message);
    }

}
