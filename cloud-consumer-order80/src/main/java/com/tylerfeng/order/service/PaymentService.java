package com.tylerfeng.order.service;

import com.tylerfeng.order.config.FooConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kai
 * @date 2020/9/11 14:30
 */
@FeignClient(name = "CLOUD-PAYMENT-SERVICE", configuration = FooConfiguration.class)
//@Component
public interface PaymentService {

    @RequestMapping("/payment/pay")
    public String pay();

    @GetMapping("/payment/page")
    public String payPage();

}
