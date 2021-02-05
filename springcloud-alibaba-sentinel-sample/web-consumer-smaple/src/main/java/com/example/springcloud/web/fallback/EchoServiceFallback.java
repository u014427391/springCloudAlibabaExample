package com.example.springcloud.web.fallback;

import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * <pre>
 *  EchoServiceFallback
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2021/02/05 15:11  修改内容:
 * </pre>
 */
public class EchoServiceFallback implements BlockExceptionHandler{
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setStatus(429);
        PrintWriter pw = response.getWriter();
        pw.print(String.format("Oops , blocked by sentinel:%s", e.getClass().getSimpleName()));
        pw.flush();
        pw.close();
    }
}
