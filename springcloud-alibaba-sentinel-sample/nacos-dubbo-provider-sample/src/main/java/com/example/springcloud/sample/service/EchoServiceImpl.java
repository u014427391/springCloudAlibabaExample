package com.example.springcloud.sample.service;

import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *    Service
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 16:29  修改内容:
 * </pre>
 */
@Service
public class EchoServiceImpl{
    public String echo(String message) {
        return String.format("echo:%s", message);
    }
}
