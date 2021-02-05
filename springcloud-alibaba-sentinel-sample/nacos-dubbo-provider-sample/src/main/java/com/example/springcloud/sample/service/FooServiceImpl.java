package com.example.springcloud.sample.service;

import com.example.api.smapleapi.service.FooService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * <pre>
 *      FooServiceImpl
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 10:03  修改内容:
 * </pre>
 */
@DubboService
public class FooServiceImpl implements FooService {

    @Override
    public String echo(String str, boolean slow) {
        if (slow) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
        }
        return String.format("echo:%s", str);
    }
}
