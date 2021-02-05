package com.example.springcloud.web.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BlockExceptionHandler {
    void handle(HttpServletRequest request, HttpServletResponse response, BlockException e)
throws Exception;
}