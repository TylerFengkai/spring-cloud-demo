package com.tylerfeng.order;

import com.tylerfeng.rule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kai
 * @date 2020/9/10 15:36
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
@EnableFeignClients
public class OrderConsumer80 {

    public static void main(String[] args) {
        new SpringApplication(OrderConsumer80.class).run(args);
    }
}
