package com.sugelakai.order.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kai
 * @date 2020/9/11 17:18
 */
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX", fallback = PaymentFallbackService.class)
//@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX", fallback = PaymentFallbackService.class)
@Component
public interface PaymentService {

    @RequestMapping("/hystrix/pay/timeout")
    @ResponseBody
    public String pay();

    @RequestMapping("/hystrix/pay/circuit/{num}")
    @ResponseBody
    public String circuitBreaker(@PathVariable("num") Integer num);

}
