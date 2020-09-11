package com.tylerfeng.order.controller;

import com.tylerfeng.order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
    private PaymentService paymentService;

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

    /***
     * feign方式远程服务
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 14:32
     * @since 1.0.0
    */
    @GetMapping("/c/feign/createOrder")
    @ResponseBody
    public String createFeign(){
        return paymentService.pay();
    }

    /**
     * 获取远程服务页面
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 14:40
     * @since 1.0.0
    */
    @GetMapping(value = "/c/feign/getPage", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String getPaymentPage(){
        return paymentService.payPage();
    }
}
