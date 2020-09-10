package com.tylerfeng.payment.controller;

import com.tylerfeng.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kai
 * @date 2020/8/22 15:33
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/payment/pay")
    @ResponseBody
    public String pay(){
        paymentService.create("123");
        return "支付成功..." + port;
    }

}
