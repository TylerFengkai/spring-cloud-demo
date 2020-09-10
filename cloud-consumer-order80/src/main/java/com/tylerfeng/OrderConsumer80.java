package com.tylerfeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author kai
 * @date 2020/9/10 15:36
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderConsumer80 {

    public static void main(String[] args) {
        new SpringApplication(OrderConsumer80.class).run(args);
    }
}
