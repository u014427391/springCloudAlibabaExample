package com.example.nacos.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <pre>
 *      FeignClientService
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/12/25 14:08  修改内容:
 * </pre>
 */
@FeignClient(value = "springcloud-alibaba-nacos-discovery")
@Service
public interface FeignClientService {
    @GetMapping(value = {"/api/test/{message}"})
    String call(@PathVariable(value = "message") String message);
}
