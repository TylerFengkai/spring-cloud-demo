package com.sugelakai.hystrix.controller;

import com.sugelakai.hystrix.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kai
 * @date 2020/9/11 16:28
 */
@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 转发超时服务
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 16:30
     * @since 1.0.0
    */
    @RequestMapping("/hystrix/pay/timeout")
    @ResponseBody
    public String pay(){
        return paymentService.payTimeout();
    }

    /**
     * 测试熔断
     *
     * @param num
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-12 09:37
     * @since 1.0.0
    */
    @RequestMapping("/hystrix/pay/circuit/{num}")
    @ResponseBody
    public String circuitBreaker(@PathVariable("num") Integer num){
        return paymentService.circuitBreak(num);
    }
}
