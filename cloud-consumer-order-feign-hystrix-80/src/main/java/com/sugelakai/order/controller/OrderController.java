package com.sugelakai.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sugelakai.order.service.OrderService;
import com.sugelakai.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kai
 * @date 2020/9/11 17:20
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("c/hystrix/order/create")
    @ResponseBody
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    public String create(){
        String payResult = orderService.order();
        System.out.println(payResult);
        return payResult;
    }

    @RequestMapping("c/hystrix/circuitBreaker/{num}")
    @ResponseBody
    public String circuitBreaker(@PathVariable("num") Integer num){
        return orderService.testCircuitBreaker(num);
    }
//
//    private String paymentTimeOutFallbackMethod() {
//        return "消费者80，对方支付系统繁忙，或自己运行出错请检查自己，请10秒后再试。";
//    }

}
