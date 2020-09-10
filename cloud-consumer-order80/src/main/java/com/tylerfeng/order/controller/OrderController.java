package com.tylerfeng.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author kai
 * @date 2020/9/10 15:20
 */
@Controller
public class OrderController {

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 创建订单
     *
     * @param id
     * @return void
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-10 15:21
     * @since 1.0.0
    */
    @RequestMapping("/c/createOrder")
    @ResponseBody
    public String create(String id){
        String s = restTemplate.postForObject(PAYMENT_URL + "/payment/pay", "1", String.class);
        return s;
    }

}
