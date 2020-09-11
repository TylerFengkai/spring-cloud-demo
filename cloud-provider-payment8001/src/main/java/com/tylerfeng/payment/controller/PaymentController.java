package com.tylerfeng.payment.controller;

import com.tylerfeng.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "支付成功..." + port;
    }

    /***
     * 返回页面
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 14:37
     * @since 1.0.0
    */
    @GetMapping("/payment/page")
    public String payPage(){
        return "/test.html";
    }

}
