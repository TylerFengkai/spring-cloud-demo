package com.sugelakai.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author kai
 * @date 2020/9/11 16:14
 */
@Service
public class PaymentService {

    /**
     * 下单，返回流水号
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 16:19
     * @since 1.0.0
    */
    public String pay(){
        String uuid = UUID.randomUUID().toString();
        System.out.println("支付成功，流水号："+uuid);
        return uuid;
    }

    /**
     * 下单，但是超时
     *
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-11 16:21
     * @since 1.0.0
    */
//    @HystrixCommand(fallbackMethod = "payTimeoutHandler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String payTimeout(){
        String uuid = UUID.randomUUID().toString();
        int i = 10 /0;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("支付成功，流水号："+uuid);
        return uuid;
    }

    public String payTimeoutHandler(){
        return "支付失败，服务降级";
    }

    public String circuitBreak(int num){
        if (num < 0){
            throw new RuntimeException("不能为负数");
        }
        return num + "";
    }

}
