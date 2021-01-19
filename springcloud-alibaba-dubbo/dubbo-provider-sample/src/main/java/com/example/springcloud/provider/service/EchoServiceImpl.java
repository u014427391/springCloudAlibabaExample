package com.example.springcloud.provider.service;

import com.example.springcloud.api.service.ApiService;
import org.apache.dubbo.config.annotation.Service;

/**
 * <pre>
 *      EchoServiceImpl
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/01/19 15:13  修改内容:
 * </pre>
 */
@Service
public class EchoServiceImpl implements ApiService {
    @Override
    public String echo(String message) {
        return String.format("echo:%s",message);
    }
}
