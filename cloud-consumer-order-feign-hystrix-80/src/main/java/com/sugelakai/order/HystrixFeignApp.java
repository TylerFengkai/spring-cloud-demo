package com.sugelakai.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author kai
 * @date 2020/9/11 17:13
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableCircuitBreaker
@EnableFeignClients
public class HystrixFeignApp {

    public static void main(String[] args) {
        new SpringApplication(HystrixFeignApp.class).run(args);
    }

}
